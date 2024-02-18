package com.example.laundry_project.domain.client.social;

import com.example.laundry_project.service.clientService.KakaoAuthService;
import com.example.laundry_project.service.clientService.SocialService;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SocialSignType {
    KAKAO(new KakaoAuthService());

    private SocialService socialService;
}
