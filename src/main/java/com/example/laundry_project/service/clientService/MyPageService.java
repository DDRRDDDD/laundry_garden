package com.example.laundry_project.service.clientService;

import com.example.laundry_project.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyPageService {

    private final ClientRepository clientRepository;



}
