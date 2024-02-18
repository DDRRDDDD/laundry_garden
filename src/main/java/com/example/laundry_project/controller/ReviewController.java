package com.example.laundry_project.controller;

import com.example.laundry_project.domain.review.Review;
import com.example.laundry_project.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("review")
@RequiredArgsConstructor
@RestController

public class ReviewController {

    private  final ReviewService reviewService;

    // R
    @PostMapping("getAll")
    public List<Review> getReviewAll(){
        List<Review> list = reviewService.getReviewAll();
        return list;
    }
    @PostMapping("getOne")
    public Review getReviewBySeq(@RequestParam int boardSeq){
        Review review = reviewService.getReviewBySeq(boardSeq);
        return review;
    }
    @GetMapping("page")
    public Page<Review> getReviewWithPage(@RequestParam int page, @PageableDefault(size = 10, sort = {"boardSeq"}, direction = Sort.Direction.DESC) Pageable pageable){
        return reviewService.getReviewWithPage(pageable.withPage(page-1));
    }
}
