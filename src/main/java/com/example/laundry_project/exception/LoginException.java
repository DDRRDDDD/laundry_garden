package com.example.laundry_project.exception;

import com.google.gson.Gson;
import java.util.Map;

public class LoginException extends RuntimeException {

    private Gson gson = new Gson();

    public LoginException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return this.gson.toJson(Map.of("errorMessage", super.getMessage()));
    }
}
