package com.awsvalidator.validatorserver.validation.annotation;

import com.awsvalidator.validatorserver.validation.validator.PastOrMaxYearsAgoValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PastOrMaxYearsAgoValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface IPastOrMaxYearsAgo {
    int maxYears() default 110;
    String message() default "La fecha de nacimiento debe ser en el pasado y no puede ser mayor a {max} años.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
