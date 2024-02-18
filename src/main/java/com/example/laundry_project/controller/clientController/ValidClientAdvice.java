package com.example.laundry_project.controller.clientController;
import com.example.laundry_project.exception.LoginException;
import com.example.laundry_project.exception.RegistrationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestControllerAdvice("com.example.laundry_project.controller.clientController")
public class ValidClientAdvice {

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<String> loginBusinessError(LoginException exception){
        return ResponseEntity
                .badRequest()
                .contentType(APPLICATION_JSON)
                .body(exception.getMessage());
    }

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<String> registBusinessError(RegistrationException exception){
        return ResponseEntity
                .badRequest()
                .contentType(APPLICATION_JSON)
                .body(exception.getMessageByJson());
    }
}
