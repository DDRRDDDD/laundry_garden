package com.example.laundry_project.domain.client.validation.annotations;

import com.example.laundry_project.domain.client.validation.LoginConstraintValidator;

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
@Constraint(validatedBy= LoginConstraintValidator.class)
public @interface LoginConstraint {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "Invalid input data. Please check and try again";
}
