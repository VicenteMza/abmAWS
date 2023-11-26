package com.crudAWS.crud.service;

import com.crudAWS.crud.model.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserEntity> getAllUser();
    UserEntity getUserById(Long id);
    UserEntity createUser(UserEntity user);
    void deleteUser(Long id);
    UserEntity updateUser(Long id, UserEntity user);

    List<String> getProfession();
}
