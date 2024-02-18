package com.example.laundry_project.domain.client;
import com.example.laundry_project.domain.client.validation.annotations.LoginConstraint;
import com.example.laundry_project.domain.client.validation.groups.LoginValidGroup;
import lombok.Getter;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;

@Getter
@LoginConstraint(groups=LoginValidGroup.class)
public class LoginClientCommand {

    @NotNull(message="일치하는 회원 정보가 존재하지 않습니다")
    private final Client client;

    @AssertFalse(message="잘못된 회원 정보입니다")
    private final Boolean activation;

    public LoginClientCommand(Client client){
        this.client = client;
        this.activation = client == null || client.isClientActivation();;
    }

}
