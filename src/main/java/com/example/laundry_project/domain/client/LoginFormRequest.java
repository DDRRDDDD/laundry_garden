package com.example.laundry_project.domain.client;

import com.example.laundry_project.domain.client.validation.annotations.LoginConstraint;
import com.example.laundry_project.domain.client.validation.groups.LoginValidGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@LoginConstraint(groups=LoginValidGroup.class)
public class LoginFormRequest {

    @NotEmpty(message="이메일을 입력하세요")
    private String clientEmail;

    @NotEmpty(message="비밀번호를 입력하세요")
    private String clientPassword;
}
