package com.crudAWS.crud.service;

import com.crudAWS.crud.exception.DniExistException;
import com.crudAWS.crud.model.Profession;
import com.crudAWS.crud.model.UserEntity;
import com.crudAWS.crud.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserRepository repository;

    @Override
    public List<UserEntity> getAllUser() {
        return repository.findAll();
    }

    @Override
    public UserEntity getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public UserEntity createUser(UserEntity user){
        if (isDniExist(user.getDni())) {
           throw new DniExistException("El Dni existe en el sistema");
        }
        return this.repository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity user) {
        UserEntity userBd = getUserById(id);

        userBd.setName(user.getName());
        userBd.setLastName(user.getLastName());
        userBd.setDni(user.getDni());
        userBd.setBirthday(user.getBirthday());
        userBd.setProfession(user.getProfession());

    return repository.save(userBd);
    }

    @Override
    public List<java.lang.String> getProfession() {
        return Arrays.stream(Profession.values())
                .map(Profession::getDescription)
                .collect(Collectors.toList());
    }

    public boolean isDniExist(java.lang.String dni) {
        return repository.existsByDni(dni);
    }
}
