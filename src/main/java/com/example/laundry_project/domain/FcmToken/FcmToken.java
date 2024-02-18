package com.example.laundry_project.domain.FcmToken;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="fcm_token")
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FcmToken {
    @Id
    private int clientTokenSeq;
    private int clientCode;
    private String clientToken;

    public FcmToken(FcmTokenDto clientTokenDto) {
        this.clientCode = clientTokenDto.getClientCode();
        this.clientToken = clientTokenDto.getClientToken();
    }
}
