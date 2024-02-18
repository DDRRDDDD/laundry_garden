package com.example.laundry_project.controller;

import com.example.laundry_project.domain.notice.Notice;
import com.example.laundry_project.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class NoticeModelController {

    private final NoticeService noticeService;

    @GetMapping("noticeList")
    public ModelAndView noticeList(@PageableDefault(page = 0, size = 10, sort = "boardSeq",
            direction = Sort.Direction.DESC)
                                       Pageable pageable
            , String searchKeyword, String category){
        Page<Notice> list = null;

        if(searchKeyword == null || searchKeyword.isEmpty()){
            list = noticeService.getNoticeWithPage(pageable);
        }else {
            if (category.equals("1") && searchKeyword != null) {
                list = noticeService.getNoticeByTitle(searchKeyword, pageable);
            } else if (category.equals("2") && searchKeyword != null) {
                list = noticeService.getNoticeByContent(searchKeyword, pageable);
            } else if (category.equals("3") && searchKeyword != null) {
                list = noticeService.getNoticeByContentAndTitle(searchKeyword, pageable);
            }
        }
        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 5, 1);
        int endPage = Math.min(nowPage + 5, list.getTotalPages());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("notice");
        modelAndView.addObject("list" , list.getContent());
        modelAndView.addObject("nowPage", nowPage);
        modelAndView.addObject("startPage", startPage);
        modelAndView.addObject("endPage", endPage);

        return modelAndView;
    }
}
