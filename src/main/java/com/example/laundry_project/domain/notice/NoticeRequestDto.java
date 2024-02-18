package com.example.laundry_project.domain.notice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
public class NoticeRequestDto {

    private int boardSeq;
    private String boardTitle;
    private String boardContent;
    private Timestamp boardRegDate;
    private Timestamp boardEditDate;
    private int boardViewCount;

}
