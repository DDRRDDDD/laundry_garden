package com.example.laundry_project.exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

public class RegistrationException extends RuntimeException{
    private Gson gson = new Gson();
    private Map<String, String> errors;
    public RegistrationException(Map<String,String> errors) {
        super(errors.toString());
        this.errors = errors;
    }

    public String getMessageByJson(){
        Gson testGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(testGson.toJson(this.errors));

        return this.gson.toJson(this.errors);
    }
}