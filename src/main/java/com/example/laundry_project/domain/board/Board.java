package com.example.laundry_project.domain.board;

import com.example.laundry_project.util.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Optional;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="board")
@Entity
public class Board extends Timestamp {

    @Id
    private int boardSeq;
    private int boardCategoryCode;
    private int clientCode;
    private String boardTitle;
    private String boardContent;
    private int boardViewCount;
    private String boardImg;

    public Board(BoardRequestDto boardDto){
        this.boardSeq = boardDto.getBoardSeq();
        this.boardCategoryCode = boardDto.getBoardCategoryCode();
        this.clientCode = boardDto.getClientCode();
        this.boardTitle = boardDto.getBoardTitle();
        this.boardContent = boardDto.getBoardContent();
        this.boardViewCount = boardDto.getBoardViewCount();
        this.boardImg = boardDto.getBoardImg();
    }

    public void setBoard(Board board){
        this.boardTitle = board.getBoardTitle();
        this.boardContent = board.getBoardContent();
        this.boardImg = board.getBoardImg();
    }

}