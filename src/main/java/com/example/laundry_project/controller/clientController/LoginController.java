package com.example.laundry_project.controller.clientController;

import com.example.laundry_project.domain.client.Client;
import com.example.laundry_project.domain.client.LoginFormRequest;

import com.example.laundry_project.domain.client.SocialLoginInfoDTO;
import com.example.laundry_project.domain.client.social.SocialSignType;
import com.example.laundry_project.domain.client.validation.groups.LoginValidGroup;
import com.example.laundry_project.service.clientService.LoginService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import javax.validation.Valid;


@RequiredArgsConstructor
@RequestMapping("/login")
@Controller
public class LoginController {

    private final LoginService generalLoginService;

    @PostMapping("/loginPro")
    @ResponseBody
    public boolean loginPro(@Validated(LoginValidGroup.class)
                                @RequestBody LoginFormRequest loginForm,
                                             HttpSession session){

        Client client = this.generalLoginService.login(loginForm).getClient();
        session.setAttribute("loginClient", client);
        return true;
    }

    @GetMapping("/{socialSignType}")
    public String socialLogin(@RequestParam String code,
                            @PathVariable SocialSignType socialSignType,
                            HttpSession session){

        SocialLoginInfoDTO loginInfo = socialSignType.getSocialService().getSocialLoginKey(code);
        Client client = this.generalLoginService.login(loginInfo).getClient();

        session.setAttribute("loginClient", client);
        return "redirect:/";
    }
}