package com.example.laundry_project.service;

import com.example.laundry_project.domain.board.Board;
import com.example.laundry_project.domain.review.Review;
import com.example.laundry_project.domain.review.ReviewRequestDto;
import com.example.laundry_project.repository.BoardRepository;
import com.example.laundry_project.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final BoardRepository boardRepository;

    // R

    public List<Review> getReviewAll() {
        return reviewRepository.findAll();
    }

    public Review getReviewBySeq(int boardSeq) {
        boardRepository.updateBoardByBoardViewCount(boardSeq);
        Review review = reviewRepository.findById(boardSeq).orElseThrow(() -> new IllegalArgumentException());
        return review;
    }
    public Page<Review> getReviewByTitle(String keyword, Pageable pageable){
        return reviewRepository.findByBoardTitleContaining(keyword, pageable);
    }

    public Page<Review> getReviewByContent(String keyword, Pageable pageable){
        return reviewRepository.findByBoardContentContaining(keyword, pageable);
    }


    public Page<Review> getReviewByContentAndTitle(String keyword, Pageable pageable){
        return reviewRepository.findByBoardContentContainingOrBoardTitleContaining(keyword,keyword,pageable);
    }
    public Page<Review> getReviewByName(String keyword, Pageable pageable){
        return reviewRepository.findByNameContaining(keyword,pageable);
    }

    public Page<Review> getReviewWithPage(Pageable pageable){
        return reviewRepository.findAll(pageable);
    }
}
