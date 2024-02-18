package com.example.laundry_project.domain.client.validation;

import com.example.laundry_project.domain.client.validation.annotations.LoginConstraint;
import com.example.laundry_project.exception.LoginException;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.Set;

@AllArgsConstructor
public class LoginConstraintValidator implements ConstraintValidator<LoginConstraint, Object> {

    private Validator validator;
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        final Set<ConstraintViolation<Object>> violations = validator.validate(value);

        violations.stream()
                .findFirst()
                .ifPresent(violation -> {
                    throw new LoginException(violation.getMessage());
                });

        return true;
    }
}
