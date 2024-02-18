package com.example.laundry_project.domain.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestDto {

    private int commentSeq;
    private int boardSeq;
    private int clientCode;
    private String commentContent;
    private Timestamp commentPostDate;
    private Timestamp commentEditDate;
}
