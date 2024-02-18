package com.example.laundry_project.repository;

import com.example.laundry_project.domain.notice.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {

    public Page<Notice> findByBoardTitleContaining(String keyword, Pageable pageable);
    public Page<Notice> findByBoardContentContaining(String text, Pageable pageable);
    public Page<Notice> findByBoardContentContainingOrBoardTitleContaining(String text1,String text2, Pageable pageable);
}
