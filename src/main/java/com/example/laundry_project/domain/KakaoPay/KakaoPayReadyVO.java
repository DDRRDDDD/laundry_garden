package com.example.laundry_project.domain.KakaoPay;

import lombok.Data;

import java.util.Date;

@Data
public class KakaoPayReadyVO {

    private String tid;
    private String next_redirect_pc_url;
    private Date created_at;

}
