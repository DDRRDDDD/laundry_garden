package com.example.laundry_project.controller;

import com.example.laundry_project.domain.item.Item;
import com.example.laundry_project.domain.orderDetails.OrderDetails;
import com.example.laundry_project.domain.orderView.OrderView;
import com.example.laundry_project.domain.orderdetailshistory.OrderDetailsHistory;
import com.example.laundry_project.domain.orderstatusCategory.OrderStatusCategory;
import com.example.laundry_project.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final OrderViewService orderViewService;
//    @GetMapping("orders")
//    public String orderView(Model model, @RequestParam int page, @PageableDefault(size= 10) Pageable pageable) {
//        Page<OrderView> orderView = orderViewService.getOrderViewByPage(pageable.withPage(page-1));
//        model.addAttribute("orderView",orderView);
//        return "orders";
//    }

    @GetMapping("orders")
    public ModelAndView OrderViewList(@PageableDefault(size = 10)
                                   Pageable pageable
            , String orderCode, String clientCode, String collectDate, String categoryCode) {

        Page<OrderView> order = orderViewService.getOrderViewByPage(pageable);

        // 1) orderCode  결과셋 -> a. 검색 b. all
        // 2) clientCode 결과셋 -> a. 검색 b. all
        // 3) collectDate 결과셋 -> a. 검색 b. all
        // 4) categoryCode 결과셋 -> a. 검색 b. all

        if(orderCode != "" && clientCode != "" && collectDate != "" && categoryCode != "") {
            collectDate += " 00:00:00";
            order = orderViewService.getOrdersByAll(Integer.parseInt(orderCode), Integer.parseInt(clientCode), Timestamp.valueOf(collectDate), Integer.parseInt(categoryCode), pageable);
        } else if (orderCode != "" && clientCode != "" && collectDate != "") {
            collectDate += " 00:00:00";
            order = orderViewService.getOrdersByOrderCodeAndClientCodeAndOrderCollectionDate(Integer.parseInt(orderCode), Integer.parseInt(clientCode), Timestamp.valueOf(collectDate), pageable);
        } else if (orderCode != "" && collectDate != "" && categoryCode != "") {
            collectDate += " 00:00:00";
            order = orderViewService.getOrdersByOrderCodeAndOrderCollectionDateAndOrderstatusCategoryCode(Integer.parseInt(orderCode), Timestamp.valueOf(collectDate), Integer.parseInt(categoryCode), pageable);
        } else if(orderCode != "" && clientCode != "" && categoryCode != "") {
            order = orderViewService.getOrdersByOrderCodeAndClientCodeAndOrderstatusCategoryCode(Integer.parseInt(orderCode), Integer.parseInt(clientCode), Integer.parseInt(categoryCode), pageable);
        } else if(clientCode != "" && collectDate != "" && categoryCode != "") {
            collectDate += " 00:00:00";
            order = orderViewService.getOrdersByClientCodeAndOrderCollectionDateAndOrderstatusCategoryCode(Integer.parseInt(clientCode), Timestamp.valueOf(collectDate), Integer.parseInt(categoryCode), pageable);
        } else if(orderCode != "" && clientCode != "") {
            order = orderViewService.getOrdersByOrderCodeAndClientCode(Integer.parseInt(orderCode), Integer.parseInt(clientCode), pageable);
        } else if(clientCode != "" && collectDate != "") {
            collectDate += " 00:00:00";
            order = orderViewService.getOrdersByClientCodeAndOrderCollectionDate(Integer.parseInt(clientCode), Timestamp.valueOf(collectDate), pageable);
        } else if(collectDate != "" && categoryCode != "") {
            collectDate += " 00:00:00";
            order = orderViewService.getOrdersByOrderCollectionDateAndOrderstatusCategoryCode(Timestamp.valueOf(collectDate), Integer.parseInt(categoryCode), pageable);
        } else if(orderCode != "" && collectDate != "") {
            collectDate += " 00:00:00";
            order = orderViewService.getOrdersByOrderCodeAndOrderCollectionDate(Integer.parseInt(orderCode), Timestamp.valueOf(collectDate), pageable);
        } else if(orderCode != "" && categoryCode != "") {
            order = orderViewService.getOrdersByOrderCodeAndOrderstatusCategoryCode(Integer.parseInt(orderCode), Integer.parseInt(categoryCode), pageable);
        } else if(clientCode != "" && categoryCode != "") {
            order = orderViewService.getOrdersByClientCodeAndOrderstatusCategoryCode(Integer.parseInt(clientCode), Integer.parseInt(categoryCode), pageable);
        } else if (orderCode != "") {
            order = orderViewService.getOrderByOrderCodeByPage(Integer.parseInt(orderCode), pageable);
        } else if (clientCode != "") {
            order = orderViewService.getOrderByClientCodeByPage(Integer.parseInt(clientCode), pageable);
        } else if (collectDate != "") {
            collectDate += " 00:00:00";
            order = orderViewService.getOrderByCollectDateByPage(Timestamp.valueOf(collectDate), pageable);
        } else if (categoryCode != "") {
            order = orderViewService.getOrderByCategoryCodeByPage(Integer.parseInt(categoryCode), pageable);
        } else {
            order = orderViewService.getOrderViewByPage(pageable);
        }

        int nowPage = order.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, order.getTotalPages());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orders");
        modelAndView.addObject("order" , order.getContent());
        modelAndView.addObject("nowPage", nowPage);
        modelAndView.addObject("startPage", startPage);
        modelAndView.addObject("endPage", endPage);

        return modelAndView;
    }

    private final OrderstatusCategoryService orderstatusCategoryService;
    // 팝업
    @GetMapping("statusPopup")
    public String statusPopup(Model model) {
        List<OrderStatusCategory> list = orderstatusCategoryService.getOrderstatusCategoryAll();
        model.addAttribute("status", list);
        return "statusPopup";
    }

    private final ItemService itemService;
    @GetMapping("categorizePopup")
    public String getItemAll(Model model) {
        List<Item> list = itemService.getItemAll();
        model.addAttribute("items", list);
        return "categorizePopup";
    }

    private final OrderDetailsHistoryService orderDetailsHistoryService;
    @GetMapping("orderDetailsPopup")
    public String getOrderDetailsByOrderCode(@RequestParam int orderCode,Model model) {
        List<OrderDetailsHistory> list = orderDetailsHistoryService.getOrderDetailByOrderCode(orderCode);
        model.addAttribute("orderDetalis",list);
        return "orderDetailsPopup";
    }

}
