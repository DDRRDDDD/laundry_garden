package com.example.laundry_project.controller;

import com.example.laundry_project.domain.FcmToken.FcmToken;
import com.example.laundry_project.domain.FcmToken.FcmTokenDto;
import com.example.laundry_project.repository.FCMTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class FCMTokenController {

    private final FCMTokenRepository fcmTokenRepository;

    @PostMapping("/saveToken")
    public String saveToken (@RequestBody FcmTokenDto fcmTokenDto) {
        String token = fcmTokenRepository.getClientTokenByClientCode(fcmTokenDto.getClientCode());
        if(token == null) {
            FcmToken clientToken = new FcmToken(fcmTokenDto);

            fcmTokenRepository.save(clientToken);
            return "success";
        } else if (!token.equals(fcmTokenDto.getClientToken())) {
            fcmTokenRepository.updateClientCodeByClientCode(fcmTokenDto.getClientToken(), fcmTokenDto.getClientCode());
            return "update";
        } else {
            return "fail";
        }
    }

    @PostMapping("/getToken")
    public String getToken (@RequestParam int clientCode) {

        return fcmTokenRepository.getClientTokenByClientCode(clientCode);
    }

    @PostMapping("/deleteToken")
    public void deleteToken (@RequestParam int clientCode) {
        fcmTokenRepository.deleteByClientCode(clientCode);
    }

}
