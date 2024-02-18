package com.example.laundry_project.controller;

import com.example.laundry_project.domain.notice.Notice;
import com.example.laundry_project.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("notice")
@RequiredArgsConstructor
@RestController
public class NoticeController {

    private final NoticeService noticeService;

    // R

    @PostMapping("getAll")
    public List<Notice> getNoticeAll(){
        List<Notice> list = noticeService.getNoticeAll();
        return list;
    }

    @PostMapping("getOne")
    public Notice getNoticeBySeq(@RequestParam int boardSeq){
        Notice notice = noticeService.getNoticeBySeq(boardSeq);
        return notice;
    }

    @GetMapping("page")
    public Page<Notice> getNoticeWithPage(@RequestParam int page, @PageableDefault(size = 10, sort = {"boardSeq"}, direction = Sort.Direction.DESC) Pageable pageable){
        return noticeService.getNoticeWithPage(pageable.withPage(page-1));
    }
}
