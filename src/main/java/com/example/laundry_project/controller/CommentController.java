package com.example.laundry_project.controller;

import com.example.laundry_project.domain.comment.Comment;
import com.example.laundry_project.domain.comment.CommentRequestDto;
import com.example.laundry_project.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("comment")
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

//    @PostMapping("write")
//    public boolean write(@RequestBody CommentRequestDto commentDto) {
//        Comment comment = new Comment(commentDto);
//        Comment result = commentService.addComment(comment);
//        if (result != null) {
//            return true;
//        } else {
//            return false;
//        }
//    }









}