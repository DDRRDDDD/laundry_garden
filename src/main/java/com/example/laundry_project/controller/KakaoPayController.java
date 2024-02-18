package com.example.laundry_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RequestMapping("/pay")
@Controller
public class KakaoPayController {

    @RequestMapping("/kakaopay")
    @ResponseBody
    public String kakaopay() {
        try {
            // <Header>
            // 보내는 부분
            URL address = new URL("https://kapi.kakao.com/v1/payment/ready");
            // 서버연결 담당 : connection
            HttpURLConnection connection = (HttpURLConnection) address.openConnection();
            connection.setRequestMethod("POST");
            // 나의 Admin Key
            connection.setRequestProperty("Authorization", "KakaoAK d325887f9d1767786a9579bb01c26a68");
            connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
            // 서버로 전달할것이 있는지 없는지 , input은 Default true;
            connection.setDoOutput(true);

            // <Body>
            // 필수요소 parameter value
            String parameter = "cid=TC0ONETIME" // 가맹점 코드 [테스트용 가맹점 코드]
                    + "&partner_order_id=partner_order_id" // 가맹점 주문번호
                    + "&partner_user_id=partner_user_id" // 가맹점 회원 id
                    + "&item_name=맞춤세탁" // 상품명
                    + "&quantity=1" // 상품 수량
                    + "&total_amount=90" // 총 금액
                    + "&tax_free_amount=0" // 상품 비과세 금액
                    + "&approval_url=http://localhost:8080" // 결제 성공 시
                    + "&fail_url=https://developers.kakao.com/fail" // 결제 실패 시
                    + "&cancel_url=https://developers.kakao.com/cancel"; // 결제 취소 시
            // https://developers.kakao.com : domain 등록
            // https://developers.kakao.com/success

            // 서버에 먼갈 줄 수 있따.
            OutputStream send = connection.getOutputStream();
            // 서버에 데이터를 줄 수 있따!
            DataOutputStream dataSend = new DataOutputStream(send);
            // OutputStream은 데이터를 바이트 형식으로 주고 받기로 약속되어 있다.
            // 그러므로 parameter value를 바이트형식으로 형변환
            dataSend.writeBytes(parameter);
            dataSend.flush();
            dataSend.close();

            // 전송 잘 됐나 안됐나 번호를 받는다.
            int result = connection.getResponseCode();
            // 받는 용도
            InputStream receive;

            if(result == 200) {
                receive = connection.getInputStream();
            }else {
                receive = connection.getErrorStream();
            }
            // 읽는 부분
            InputStreamReader read = new InputStreamReader(receive); // 받은걸 읽는다.
            // 바이트를 읽기 위해 (형변환)
            // 버퍼리더는 실제로 형변환을 위해 존제하는 클래스는 아니다.
            BufferedReader change = new BufferedReader(read);
            // 받는 부분
            // System.out.println("change.readLine() : " + change.readLine() );
            // {"tid":"T452137841ce089115b1",
            // "tms_result":false,
            // "next_redirect_app_url":"https://online-pay.kakao.com/mockup/v1/
            // 6d53b8a71a70e0f71ede15c8133698cac093f559878de82f90ee5a9cd694389b/aInfo",
            // "next_redirect_mobile_url":"https://online-pay.kakao.com/mockup/v1/
            // 6d53b8a71a70e0f71ede15c8133698cac093f559878de82f90ee5a9cd694389b/mInfo",
            // "next_redirect_pc_url":"https://online-pay.kakao.com/mockup/v1/
            // 6d53b8a71a70e0f71ede15c8133698cac093f559878de82f90ee5a9cd694389b/info",
            // "android_app_scheme":"kakaotalk://kakaopay/pg?url=https://online-pay.kakao.com/
            // pay/mockup/6d53b8a71a70e0f71ede15c8133698cac093f559878de82f90ee5a9cd694389b",
            // "ios_app_scheme":"kakaotalk://kakaopay/pg?url=https://online-pay.kakao.com/pay/
            // mockup/6d53b8a71a70e0f71ede15c8133698cac093f559878de82f90ee5a9cd694389b",
            // "created_at":"2023-05-03T16:55:36"}

            return change.readLine(); // 문자열로 형변환을 알아서 해주고 찍어낸다 그리고 본인은 비워진다.
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/";
    }





}
