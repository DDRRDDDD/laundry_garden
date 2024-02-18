package com.example.laundry_project.service;

import com.example.laundry_project.domain.notice.Notice;
import com.example.laundry_project.repository.BoardRepository;
import com.example.laundry_project.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final BoardRepository boardRepository;

    // R

    public List<Notice> getNoticeAll(){
        return noticeRepository.findAll();
    }

    public Notice getNoticeBySeq(int boardSeq){
        boardRepository.updateBoardByBoardViewCount(boardSeq);
        Notice notice = noticeRepository.findById(boardSeq).orElseThrow(
                ()-> new IllegalArgumentException());
        return notice;
    }
    public Page<Notice> getNoticeWithPage(Pageable pageable) {
        return noticeRepository.findAll(pageable);
    }

    public Page<Notice> getNoticeByTitle(String keyword, Pageable pageable){
        return noticeRepository.findByBoardTitleContaining(keyword, pageable);
    }

    public Page<Notice> getNoticeByContent(String keyword, Pageable pageable){
        return noticeRepository.findByBoardContentContaining(keyword, pageable);
    }


    public Page<Notice> getNoticeByContentAndTitle(String keyword, Pageable pageable){
        return noticeRepository.findByBoardContentContainingOrBoardTitleContaining(keyword,keyword,pageable);
    }

}
