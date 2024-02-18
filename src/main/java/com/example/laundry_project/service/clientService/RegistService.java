package com.example.laundry_project.service.clientService;

import com.example.laundry_project.domain.client.Client;
import com.example.laundry_project.domain.client.RegistCommand;
import com.example.laundry_project.domain.client.validation.groups.RegistrationGroup;
import com.example.laundry_project.exception.RegistrationException;
import com.example.laundry_project.repository.ClientRepository;
import com.example.laundry_project.util.DateStamp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Validated(RegistrationGroup.class)
public class RegistService {

    private final ClientRepository clientRepository;

    @Transactional
    public void saveClient(RegistCommand registCommand) {
        if(registCommand.isDuplication())
            this.clientRepository.saveAndFlush(createClient(registCommand));
    }

    public @Valid RegistCommand clientVerification(RegistCommand registCommand) {
        this.clientRepository.findAll().stream().anyMatch(registCommand::isSameAs);
        return registCommand;
    }

    private Client createClient(RegistCommand registCommand) {
        return Client.builder()
                .of(registCommand)
                .clientRegDate(DateStamp.getCurrentDate())
                .build();
    }
}