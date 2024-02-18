package com.example.laundry_project.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class MessagingService {

    private String accessToken;

    public String getAccessToken() throws IOException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("./static/json/service-account.json");

        GoogleCredential googleCredential = GoogleCredential.fromStream(stream)
                .createScoped(Arrays.asList("https://www.googleapis.com/auth/firebase",
                "https://www.googleapis.com/auth/cloud-platform",
                "https://www.googleapis.com/auth/firebase.readonly"));

        googleCredential.refreshToken();

        this.accessToken = googleCredential.getAccessToken();

        return this.accessToken;
    }

    public String send(String body, String accessToken) throws IOException {

        URL url = new URL("https://fcm.googleapis.com/v1/projects/laundry-project-32172/messages:send");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("POST");
        http.setDoInput(true);
        http.setRequestProperty("Authorization",  "Bearer " + accessToken);
        http.setRequestProperty("Content-Type",  "application/json; UTF-8");
        http.setDoOutput(true);

        byte[] out = body.getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
            os.flush();
        }
        System.out.println(http.getResponseMessage());
        http.disconnect();
        return http.getResponseMessage();
    }

}
