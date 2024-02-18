package com.example.laundry_project.domain.client.social.kakao;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class KakaoTokenRequest {

        private final String grantType = "authorization_code";
        private final String clientId = "19f3073e18916acec0a298992f4eda22";
        private final String redirectUri = "http://localhost:8080/login/kakaoLogin";

        private String code;

        private KakaoTokenRequest(String code){
            this.code = code;
        }

        public static KakaoTokenRequest toMap(String code){
            MultiValueMap<String, String> bodys = new LinkedMultiValueMap<>();
            return null;
        }

}
