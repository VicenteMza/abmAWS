package com.crudAWS.crud.repository;

import com.crudAWS.crud.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByDni(String dni);
}
