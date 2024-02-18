package com.example.laundry_project.domain.client;

import com.example.laundry_project.domain.client.social.SocialSignType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Table(name="CLIENT")
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName="Builder")
public class Client {
    @Id
    private int clientCode;
    private String clientName;
    private String clientPassword;
    private String clientEmail;
    private String clientPhone;
    private String clientAddress;

    @Column(name = "client_social_login_key")
    private String socialLoginKey;

    @Column(name = "client_social_login_host")
    @Enumerated(EnumType.STRING)
    private SocialSignType socialLoginHost;

    private Timestamp clientRegDate;
    private boolean clientActivation;
    private Timestamp clientDeactivationDate;

    public boolean equalsForLoginForm(LoginFormRequest loginForm){
        return Objects.equals(this.clientEmail, loginForm.getClientEmail()) &&
               Objects.equals(this.clientPassword, loginForm.getClientPassword());
    }

    public boolean equalsForSocialLoginInfo(SocialLoginInfoDTO loginInfo){
        return Objects.equals(this.socialLoginKey, loginInfo.getSocialLoginKey()) &&
                (this.socialLoginHost == loginInfo.getSocialLoginHost());
    }

    public boolean equalsForRegistForm(RegistCommand registForm){
        return equalsForLoginForm(
                new LoginFormRequest(registForm.getClientEmail(), registForm.getClientPassword()));
    }

    public static class Builder{
        public Builder of(RegistCommand registForm){
            this.clientName = registForm.getClientName();
            this.clientPassword = registForm.getClientPassword();
            this.clientEmail = registForm.getClientEmail();
            this.clientPhone = registForm.getClientPhone();
            this.clientAddress = registForm.getClientAddress();
            return this;
        }
    }
}
