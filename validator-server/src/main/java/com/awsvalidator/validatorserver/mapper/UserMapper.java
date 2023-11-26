package com.awsvalidator.validatorserver.mapper;

import com.awsvalidator.validatorserver.validation.annotation.IPastOrMaxYearsAgo;
import com.awsvalidator.validatorserver.validation.annotation.IValidProfessionDescription;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserMapper {
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]+$")
    @Size(max = 50)
    private java.lang.String name;
    @NotBlank
    @Size(max = 50)
    @Pattern(regexp = "^[a-zA-Z ]+$")
    private java.lang.String lastName;
    @NotBlank
    @Pattern(regexp = "\\d{8}")
    private java.lang.String dni;
    @NotNull
    @IPastOrMaxYearsAgo(maxYears = 110)
    private LocalDate birthday;
    @NotNull
    @IValidProfessionDescription
    private String profession;
}
