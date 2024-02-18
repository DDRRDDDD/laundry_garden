package com.example.laundry_project.domain.client.validation;

import com.example.laundry_project.domain.client.validation.annotations.RegistrationConstraint;
import com.example.laundry_project.domain.client.validation.groups.RegistrationGroup;
import com.example.laundry_project.exception.RegistrationException;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.*;

@AllArgsConstructor
public class RegistrationConstraintValidator implements ConstraintValidator<RegistrationConstraint, Object> {

    private Validator validator;

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        final Set<ConstraintViolation<Object>> violations = this.validator.validate(value);

        if(!violations.isEmpty()){
            Map<String, String> errors = new HashMap<>();

            for(ConstraintViolation<Object> violation : violations){
                String property = violation.getPropertyPath().toString();
                String message = violation.getMessage();
                errors.put(property, message);
            }
            throw new RegistrationException(errors);
        }

        return true;
    }
}
