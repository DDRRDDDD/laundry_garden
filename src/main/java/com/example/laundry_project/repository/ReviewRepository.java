package com.example.laundry_project.repository;

import com.example.laundry_project.domain.review.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepository extends JpaRepository<Review, Integer> {

    public Page<Review> findByBoardTitleContaining(String keyword, Pageable pageable); // 제목으로 검색
    public Page<Review> findByBoardContentContaining(String text, Pageable pageable); // 내용으로 검색
    public Page<Review> findByBoardContentContainingOrBoardTitleContaining(String text1,String text2, Pageable pageable); // 제목+내용으로 검색
    public Page<Review> findByNameContaining(String text, Pageable pageable); // 이름으로검색


}
