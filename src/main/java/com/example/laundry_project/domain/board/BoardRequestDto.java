package com.example.laundry_project.domain.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardRequestDto {
    private int boardSeq;
    private int boardCategoryCode;
    private int clientCode;
    private String boardTitle;
    private String boardContent;
    private int boardViewCount;
    private String boardImg;
}