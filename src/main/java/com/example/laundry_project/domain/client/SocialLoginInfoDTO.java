package com.example.laundry_project.domain.client;

import com.example.laundry_project.domain.client.social.SocialSignType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SocialLoginInfoDTO {
    private SocialSignType socialLoginHost;
    private String socialLoginKey;
}
