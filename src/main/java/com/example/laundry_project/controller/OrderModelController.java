package com.example.laundry_project.controller;

import com.example.laundry_project.domain.client.Client;
import com.example.laundry_project.domain.orderView.OrderView;
import com.example.laundry_project.service.OrderViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
public class OrderModelController {

    private final OrderViewService orderViewService;

    @GetMapping("myOrderList")
    public String myOrderList(HttpServletRequest request,
                              @PageableDefault(sort = "orderCode", direction = Sort.Direction.DESC)
                              Pageable pageable,
                              Model model) {

        Client client = (Client) request.getSession().getAttribute("loginClient");

        if (client != null) {
            int clientCode = client.getClientCode();
            Page<OrderView> list = null;
            list = orderViewService.getOrderByClientCode(clientCode, pageable);

            int nowPage = list.getPageable().getPageNumber() + 1;
            int startPage = Math.max(nowPage - 3, 1);
            int endPage = Math.min(nowPage + 3, list.getTotalPages());

            model.addAttribute("list", list.getContent());
            model.addAttribute("nowPage", nowPage);
            model.addAttribute("startPage", startPage);
            model.addAttribute("endPage", endPage);
            return "mylaundryorder";
        } else {
            return "redirect:/";
        }
    }
}
