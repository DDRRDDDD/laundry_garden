package com.example.laundry_project.domain.client.social.kakao;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KakaoProfile {
    public Long id;
    public String connectedAt;
    public Properties properties;
    public KakaoAccount kakaoAccount;
    @Getter
    @NoArgsConstructor
    public class Properties {
        public String nickname;
    }
    @Getter
    @NoArgsConstructor
    public class KakaoAccount {
        public Boolean profileNicknameNeedsAgreement;
        public Profile profile;
        public Boolean hasEmail;
        public Boolean emailNeedsAgreement;
        public Boolean isEmailValid;
        public Boolean isEmailVerified;
        public String email;
        @Getter
        @NoArgsConstructor
        public class Profile {
            public String nickname;
        }
    }
}