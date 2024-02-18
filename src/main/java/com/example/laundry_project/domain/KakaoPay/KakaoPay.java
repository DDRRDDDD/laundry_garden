package com.example.laundry_project.domain.KakaoPay;

import lombok.extern.java.Log;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
@Log
public class KakaoPay {

    private static final String HOST = "https://kapi.kakao.com";
    private String key = "KakaoAK d325887f9d1767786a9579bb01c26a68";

    private KakaoPayReadyVO kakaoPayReadyVO;
    private KakaoPayApprovalVO kakaoPayApprovalVO;

    public String kakaoPayReady(String totalPrice, String count, String orderCode) {
        RestTemplate restTemplate = new RestTemplate();

        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", key);
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=utf-8");

        // 서버로 요청할 Body
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
        body.add("cid", "TC0ONETIME");
        body.add("partner_order_id", orderCode); // 가맹점 주문번호 (주문코드 : order_code)
        body.add("partner_user_id", "partner_user_id");
        body.add("item_name", "맞춤세탁");
        body.add("quantity", count); // 상품수량
        body.add("total_amount", totalPrice); // 상품 총액
        body.add("tax_free_amount", "0");
        body.add("approval_url", "https://laundrygarden.store/kakaoPaySuccess");
        body.add("fail_url", "https://laundrygarden.store/kakaoPayFail");
        body.add("cancel_url", "https://laundrygarden.store/kakaoPayFail");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(body, headers);
        try {
            kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), request, KakaoPayReadyVO.class);
            return kakaoPayReadyVO.getNext_redirect_pc_url();
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "/kakaoPayFail"; // 실패시 돌아갈 맵핑
    }

    public KakaoPayApprovalVO kakaoPayInfo(String pg_token,
                                           String totalAmount,
                                           String orderId) {
        RestTemplate restTemplate = new RestTemplate();

        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", key);
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=utf-8");

        // 서버로 요청할 Body
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
        body.add("cid", "TC0ONETIME");
        body.add("tid", kakaoPayReadyVO.getTid());
        body.add("partner_order_id", orderId);
        body.add("partner_user_id", "partner_user_id");
        body.add("pg_token", pg_token);
        body.add("total_amount", totalAmount);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(body, headers);

        try {
            kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), request, KakaoPayApprovalVO.class);
            return kakaoPayApprovalVO;
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        //return null;
    }


}
