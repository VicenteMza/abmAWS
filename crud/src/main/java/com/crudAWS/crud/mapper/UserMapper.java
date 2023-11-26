package com.crudAWS.crud.mapper;

import com.crudAWS.crud.model.Profession;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
@Data
@Builder
public class UserMapper implements Serializable {
    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private LocalDate birthdate;
    private String profession;
}
