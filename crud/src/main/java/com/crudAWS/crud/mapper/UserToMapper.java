package com.crudAWS.crud.mapper;

import com.crudAWS.crud.exception.ProfessionNotFountException;
import com.crudAWS.crud.model.Profession;
import com.crudAWS.crud.model.UserEntity;

import java.util.Arrays;

public class UserToMapper {
    public static UserMapper toDto(UserEntity user){
        return UserMapper.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .dni(user.getDni())
                .birthday(user.getBirthday())
                .profession(user.getProfession().getDescription())
                .build();
    }
    public static UserEntity toUser(UserMapper mapper){
        return UserEntity.builder()
                .id(mapper.getId())
                .name(mapper.getName())
                .lastName(mapper.getLastName())
                .dni(mapper.getDni())
                .birthday(mapper.getBirthday())
                .profession(getProfessionByDescription(mapper.getProfession()))
                .build();
    }
    private static Profession getProfessionByDescription(String description){
        return Arrays.stream(Profession.values())
                .filter(profession -> profession.getDescription().equalsIgnoreCase(description))
                .findFirst()
                .orElseThrow(() -> new ProfessionNotFountException(description));
    }
}
