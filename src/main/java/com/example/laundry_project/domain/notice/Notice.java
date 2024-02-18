package com.example.laundry_project.domain.notice;

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
@Table(name = "notice")
@Entity
public class Notice {

    @Id
    private int boardSeq;
    private String boardTitle;
    private String boardContent;
    private Timestamp boardRegDate;
    private Timestamp boardEditDate;
    private int boardViewCount;

    public Notice(NoticeRequestDto noticeDto){
        this.boardSeq = noticeDto.getBoardSeq();
        this.boardTitle = noticeDto.getBoardTitle();
        this.boardContent = noticeDto.getBoardContent();
        this.boardRegDate = noticeDto.getBoardRegDate();
        this.boardEditDate = noticeDto.getBoardEditDate();
        this.boardViewCount = noticeDto.getBoardViewCount();
    }

    public void setNotice(Notice notice){
        this.boardTitle = notice.getBoardTitle();
        this.boardContent = notice.getBoardContent();
    }
}
