package com.example.laundry_project.controller.clientController;

import com.example.laundry_project.domain.client.RegistCommand;
import com.example.laundry_project.domain.client.validation.groups.RegistrationGroup;
import com.example.laundry_project.service.clientService.RegistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/regist")
@Controller
public class RegistController {

    private final RegistService registService;

    @PostMapping("/registPro")
    @ResponseBody
    public boolean registPro2(@Validated(RegistrationGroup.class)
                                  @RequestBody RegistCommand registCommand){

        registCommand = this.registService.clientVerification(registCommand);
        this.registService.saveClient(registCommand);
        return true;
    }
}

