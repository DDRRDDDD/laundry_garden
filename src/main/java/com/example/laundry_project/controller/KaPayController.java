package com.example.laundry_project.controller;

import com.example.laundry_project.domain.KakaoPay.KakaoPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Controller
public class KaPayController {

    @Setter(onMethod_ = @Autowired)
    private KakaoPay kakaopay;

    @GetMapping("/kapay")
    public void kakaoPayGet(){

    }

    private String totalAmount;
    private String partnerOrderId;

    @PostMapping("/kapay")
    public String kakaoPay(@RequestParam(name = "totalPrice") String totalPrice,
                           @RequestParam(name = "count") String count,
                           @RequestParam(name = "orderCode") String orderCode){
        log.info("kakaoPay post................................................");

        totalAmount = totalPrice;
        partnerOrderId = orderCode;
        return "redirect:" + kakaopay.kakaoPayReady(totalPrice,count,orderCode);
    }

    @GetMapping("/kakaoPaySuccess")
    public void KakaoPaySuccess(@RequestParam("pg_token") String pg_token,
                                Model model){
        log.info("kakaoPaySuccess get..............................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);
        model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token, totalAmount, partnerOrderId));
    }

}

