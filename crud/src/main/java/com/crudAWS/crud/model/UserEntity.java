package com.crudAWS.crud.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private java.lang.String name;
    private java.lang.String lastName;
    private java.lang.String dni;
    private LocalDate birthdate;
    @Enumerated(EnumType.STRING)
    private Profession profession;
}