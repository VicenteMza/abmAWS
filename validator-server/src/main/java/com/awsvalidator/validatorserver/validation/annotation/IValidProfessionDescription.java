package com.awsvalidator.validatorserver.validation.annotation;

import com.awsvalidator.validatorserver.validation.validator.ValidProfessionDescription;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidProfessionDescription.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface IValidProfessionDescription {
    String message() default "La descripsión de la profesión no es valida.";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
