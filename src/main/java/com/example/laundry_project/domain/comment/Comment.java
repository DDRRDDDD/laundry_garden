package com.example.laundry_project.domain.comment;

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
@Table(name = "comment")
@Entity
public class Comment {
    @Id
    private int commentSeq;
    private int boardSeq;
    private int clientCode;
    private String commentContent;
    private Timestamp commentPostDate;
    private Timestamp commentEditDate;

    public Comment(CommentRequestDto commentDto){
        this.commentSeq = commentDto.getCommentSeq();
        this.boardSeq = commentDto.getBoardSeq();
        this.clientCode = commentDto.getClientCode();
        this.commentContent = commentDto.getCommentContent();
        this.commentPostDate = commentDto.getCommentPostDate();
        this.commentEditDate = commentDto.getCommentEditDate();
    }

    public void setComment(Comment comment){
        this.commentContent = comment.getCommentContent();
    }
}
