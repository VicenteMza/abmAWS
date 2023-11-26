package com.awsvalidator.validatorserver.validation.validator;

import com.awsvalidator.validatorserver.validation.annotation.IPastOrMaxYearsAgo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class PastOrMaxYearsAgoValidator implements ConstraintValidator<IPastOrMaxYearsAgo, LocalDate> {
    private int maxYear;
    @Override
    public void initialize(IPastOrMaxYearsAgo constraintAnnotation) {
        this.maxYear = constraintAnnotation.maxYears();
    }

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {
        if (date == null){
            return true;
        }
        LocalDate maxDate = LocalDate.now().minusYears(maxYear);
        return date.isBefore(LocalDate.now()) && date.isAfter(maxDate);
    }
}
