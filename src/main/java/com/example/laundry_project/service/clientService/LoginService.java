package com.example.laundry_project.service.clientService;

import com.example.laundry_project.domain.client.Client;
import com.example.laundry_project.domain.client.LoginFormRequest;
import com.example.laundry_project.domain.client.SocialLoginInfoDTO;
import com.example.laundry_project.domain.client.LoginClientCommand;
import com.example.laundry_project.domain.client.validation.groups.LoginValidGroup;
import com.example.laundry_project.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@RequiredArgsConstructor
@Validated(LoginValidGroup.class)
@Service
public class LoginService {

    private final ClientRepository clientRepository;

    public @Valid LoginClientCommand login(LoginFormRequest loginForm){
        Client client = getClientByLoginForm(loginForm);
        return new LoginClientCommand(client);
    }

    public @Valid LoginClientCommand login(SocialLoginInfoDTO loginInfo){
        Client client = getClientBySocialInfo(loginInfo);
        return new LoginClientCommand(client);
    }

    private Client getClientByLoginForm(LoginFormRequest loginForm){
        return this.clientRepository.findAll().stream()
                .filter(e -> e.equalsForLoginForm(loginForm))
                .findFirst()
                .orElse(null);
    }

    private Client getClientBySocialInfo(SocialLoginInfoDTO loginInfo){
        return this.clientRepository.findAll().stream()
                .filter(e -> e.equalsForSocialLoginInfo(loginInfo))
                .findFirst()
                .orElse(null);
    }
}
