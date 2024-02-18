package com.example.laundry_project.domain.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
public class ReviewRequestDto {

    private int boardSeq;
    private String boardTitle;
    private String boardContent;
    private Timestamp boardRegDate;
    private Timestamp boardEditDate;
    private int boardViewCount;
    private int clientCode;
    private String name;
    private String boardImg;

}
