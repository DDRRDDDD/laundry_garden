package com.example.laundry_project.domain.client;

import com.example.laundry_project.domain.client.validation.annotations.RegistrationConstraint;
import com.example.laundry_project.domain.client.validation.groups.RegistrationGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Getter
@AllArgsConstructor
@RegistrationConstraint(groups = RegistrationGroup.class)
public class RegistCommand {

    @NotEmpty(message="이름을 입력하세요")
    private String clientName;

    @NotEmpty(message="비밀번호를 입력하세요")
    private String clientPassword;

    @NotEmpty(message="이메일을 입력하세요")
    @Email(message="유효하지 않은 이메일입니다")
    private String clientEmail;

    @NotEmpty(message="핸드폰 번호를 입력하세요")
    @Pattern(regexp="^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$",
            message="유효하지 않은 핸드폰 번호입니다")
    private String clientPhone;

    @NotEmpty(message="주소를 입력하세요")
    private String clientAddress;

    @AssertFalse(message="사용이 불가능한 회원 정보입니다")
    private boolean isDuplication;

    public boolean isSameAs(Client client) {
        if(client == null)
            return false;

        boolean isName = Objects.equals(this.clientName, client.getClientName());
        boolean isPassword = Objects.equals(this.clientPassword, client.getClientPassword());
        boolean isEmail = Objects.equals(this.clientEmail, client.getClientEmail());
        boolean isPhone = Objects.equals(this.clientPhone, client.getClientPhone());
        boolean isAddress = Objects.equals(this.clientAddress, client.getClientAddress());

        return this.isDuplication = isEmail || isPhone || (isName && isPassword && isAddress);
    }
}
