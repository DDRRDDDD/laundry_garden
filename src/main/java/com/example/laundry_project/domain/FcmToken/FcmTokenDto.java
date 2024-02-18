package com.example.laundry_project.domain.FcmToken;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FcmTokenDto {

    private int clientTokenSeq;
    private int clientCode;
    private String clientToken;
}

