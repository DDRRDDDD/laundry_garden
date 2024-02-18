package com.example.laundry_project.service;

import com.example.laundry_project.domain.board.Board;
import com.example.laundry_project.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    // C
    public Board addBoard(Board board) {
        return boardRepository.save(board);
    }

    // R
    public Board getBoardBySeq(int boardSeq){
        Board board = boardRepository.findBoardByBoardSeq(boardSeq);
        return board;
    }

    // U
    @Transactional
    public void updateBySeq(Board newBoard){
        Board board = getBoardBySeq(newBoard.getBoardSeq());
        if(board != null)
            board.setBoard(newBoard);
    }

    // D
    @Transactional
    public void deleteBySeq(int boardSeq){
        Board board = boardRepository.findById(boardSeq).orElseThrow(() ->
                new IllegalArgumentException());
        if(board != null)
            boardRepository.deleteById(board.getBoardSeq());
    }

}