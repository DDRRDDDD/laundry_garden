package com.example.laundry_project.service.clientService;

import com.example.laundry_project.domain.client.SocialLoginInfoDTO;

public interface SocialService {

    public SocialLoginInfoDTO getSocialLoginKey(String authorizationCode);
}
