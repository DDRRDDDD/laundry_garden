package com.example.laundry_project.controller;

import com.example.laundry_project.domain.client.Client;
import com.example.laundry_project.repository.FCMTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/washinformation")
    public String WashItemInfo() {
        return "washinformation";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/review")
    public String review() {
        return "review";
    }

    @GetMapping("/notice")
    public String notice() {
        return "notice";
    }

    @GetMapping("/readNotice")
    public String readNotice() {
        return "readNotice";
    }

    @GetMapping("/readReview")
    public String readReview() {
        return "readReview";
    }

    @GetMapping("/writeReview")
    public String writeReview() {
        return "writeReview";
    }

    @GetMapping("/writeNotice")
    public String writeNotice() {
        return "writeNotice";
    }

    @GetMapping("/modifyNotice")
    public String modifyNotice() {
        return "modifyNotice";
    }

    @GetMapping("/modifyReview")
    public String modifyReview() {
        return "modifyReview";
    }

    @RequestMapping(value = "/regist")
    public String regist() {
        return "regist";
    }

    @GetMapping("/order")
    public String order() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Client client = (Client) request.getSession().getAttribute("loginClient");

        if (client != null) {
            return "order";
        } else {
            return "index";
        }
    }

    private final FCMTokenRepository fcmTokenRepository;
    @GetMapping("/myPage")
    public String myPage(Model model) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Client client = (Client) request.getSession().getAttribute("loginClient");

        if (client != null) {
            String token = fcmTokenRepository.getClientTokenByClientCode(client.getClientCode());
            model.addAttribute("isAllowedPush",token);
            return "myPage";
        } else {
            return "index";
        }
    }

    @GetMapping("/payment")
    public String payment() {
        return "payment";
    }

    @GetMapping("/admin")
    public String admin() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Client client = (Client) request.getSession().getAttribute("loginClient");

        if (client.getClientCode() == 9999) {
            return "admin";
        } else {
            return "index";
        }
    }

    @GetMapping("/mylaundryorder")
    public String mylaundryorder() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Client client = (Client) request.getSession().getAttribute("loginClient");

        if (client != null) {
            return "mylaundryorder";
        } else {
            return "index";
        }
    }

    @GetMapping("/mylaundryorderDetail")
    public String mylaundryorderDetail() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Client client = (Client) request.getSession().getAttribute("loginClient");

        if (client != null) {
            return "mylaundryorderDetail";
        } else {
            return "index";
        }
    }

    @GetMapping("kakaoPayFail")
    public String kakaoPayFail() {
        return "kakaoPayFail";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}