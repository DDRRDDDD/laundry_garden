package com.example.laundry_project.domain.client.validation.annotations;

import com.example.laundry_project.domain.client.validation.RegistrationConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import java.lang.annotation.Target;


import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy= RegistrationConstraintValidator.class)
public @interface RegistrationConstraint {
    Class<?>[] groups() default {};
    String message() default "invalid input data. Please check and try again";
    Class<? extends Payload>[] payload() default {};
}
