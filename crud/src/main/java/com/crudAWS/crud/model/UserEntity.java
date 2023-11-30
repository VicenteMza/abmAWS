package com.crudAWS.crud.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "user")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private Profession profession;
}