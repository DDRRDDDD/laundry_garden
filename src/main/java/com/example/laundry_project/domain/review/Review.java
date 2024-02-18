package com.example.laundry_project.domain.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "review")
@Entity
public class Review {

    @Id
    private int boardSeq;
    private String boardTitle;
    private String boardContent;
    private Timestamp boardRegDate;
    private Timestamp boardEditDate;
    private int boardViewCount;
    private int clientCode;
    private String name;
    private String boardImg;

    public Review(ReviewRequestDto reviewDto){
        this.boardSeq = reviewDto.getBoardSeq();
        this.boardTitle = reviewDto.getBoardTitle();
        this.boardContent = reviewDto.getBoardContent();
        this.boardRegDate = reviewDto.getBoardRegDate();
        this.boardEditDate = reviewDto.getBoardEditDate();
        this.boardViewCount = reviewDto.getBoardViewCount();
        this.clientCode = reviewDto.getClientCode();
        this.name = reviewDto.getName();
        this.boardImg = reviewDto.getBoardImg();
    }
    public void setReview(Review review){
        this.boardTitle = review.getBoardTitle();
        this.boardContent = review.getBoardContent();
        this.boardViewCount = review.getBoardViewCount();
        this.boardImg = review.getBoardImg();
    }
}