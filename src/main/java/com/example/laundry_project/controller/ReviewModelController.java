package com.example.laundry_project.controller;

import com.example.laundry_project.domain.review.Review;
import com.example.laundry_project.service.ReviewService;
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
public class ReviewModelController {

    private  final ReviewService reviewService;

    @GetMapping("list")
    public ModelAndView reviewList(@PageableDefault(page = 0, size = 10, sort = "boardSeq",
                                    direction = Sort.Direction.DESC)
                            Pageable pageable
            , String searchKeyword, String category){
        Page<Review> list = null;
        if(searchKeyword == null || searchKeyword.isEmpty() || searchKeyword == ""){
            list = reviewService.getReviewWithPage(pageable);
        }else {
            if (category.equals("1") && searchKeyword != null) {
                list = reviewService.getReviewByTitle(searchKeyword, pageable);
            } else if (category.equals("2") && searchKeyword != null) {
                list = reviewService.getReviewByContent(searchKeyword, pageable);
            } else if (category.equals("3") && searchKeyword != null) {
                list = reviewService.getReviewByContentAndTitle(searchKeyword, pageable);
            } else if (category.equals("4") && searchKeyword != null) {
                list = reviewService.getReviewByName(searchKeyword, pageable);
            }
        }
        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 5, 1);
        int endPage = Math.min(nowPage + 5, list.getTotalPages());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("review");
        modelAndView.addObject("list" , list.getContent());
        modelAndView.addObject("nowPage", nowPage);
        modelAndView.addObject("startPage", startPage);
        modelAndView.addObject("endPage", endPage);

        return modelAndView;
    }
}
