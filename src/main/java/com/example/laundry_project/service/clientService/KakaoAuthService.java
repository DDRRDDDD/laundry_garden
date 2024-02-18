package com.example.laundry_project.service.clientService;

import com.example.laundry_project.domain.client.SocialLoginInfoDTO;
import com.example.laundry_project.domain.client.social.SocialSignType;
import com.example.laundry_project.domain.client.social.kakao.KakaoProfile;
import com.example.laundry_project.domain.client.social.kakao.KaKaoAuthToken;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoAuthService implements SocialService{


    public SocialLoginInfoDTO getSocialLoginKey(String authorizationCode){
        return SocialLoginInfoDTO.builder()
                .socialLoginHost(SocialSignType.KAKAO)
                .socialLoginKey(getKakaoKey(accessTokenRequest(authorizationCode)))
                .build();
    }

    private String accessTokenRequest(String code) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> bodys = new LinkedMultiValueMap<>();
        bodys.add("grant_type", "authorization_code");
        bodys.add("client_id", "19f3073e18916acec0a298992f4eda22");
        bodys.add("redirect_uri", "https://laundrygarden.store/login/KAKAO");
        bodys.add("code", code);

        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(bodys, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
                "https://kauth.kakao.com/oauth/token",
                kakaoTokenRequest,
                String.class);

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        KaKaoAuthToken accessToken = gson.fromJson(String.valueOf(response.getBody()), KaKaoAuthToken.class);

        return accessToken.getAccessToken();
    }

    public String getKakaoKey(String accessToken) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Bearer " + accessToken);

        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
                "https://kapi.kakao.com/v2/user/me",
                kakaoProfileRequest,
                String.class
        );

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        KakaoProfile kakaoProfile = gson.fromJson(String.valueOf(response.getBody()), KakaoProfile.class);

        return String.valueOf(kakaoProfile.getId());
    }
}
