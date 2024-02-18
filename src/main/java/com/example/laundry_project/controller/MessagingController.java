package com.example.laundry_project.controller;

import com.example.laundry_project.domain.message.MessageDto;
import com.example.laundry_project.service.MessagingService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class MessagingController {

    private final MessagingService messagingService;

    @PostMapping("/push")
    public String push (@RequestBody MessageDto messageDto) throws IOException {
        String accessToken = messagingService.getAccessToken();

        Gson gson = new Gson();
        String body = gson.toJson(messageDto);
        messagingService.send(body, accessToken);
        return body;
    }

}
