package com.awsvalidator.validatorserver.validation.validator;

import com.awsvalidator.validatorserver.mapper.Profession;
import com.awsvalidator.validatorserver.validation.annotation.IValidProfessionDescription;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class ValidProfessionDescription implements ConstraintValidator<IValidProfessionDescription, java.lang.String> {
    @Override
    public void initialize(IValidProfessionDescription constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null){
            return true;
        }
        return Arrays.stream(Profession.values())
                .map(Profession::getDescription)
                .anyMatch(value::equals);
    }
}
