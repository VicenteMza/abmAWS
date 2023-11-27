package com.crudAWS.crud.controller;

import com.crudAWS.crud.mapper.UserMapper;
import com.crudAWS.crud.model.UserEntity;
import com.crudAWS.crud.mapper.UserToMapper;
import com.crudAWS.crud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:8082")
public class UserController {
    @Autowired
    private IUserService service;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserMapper mapper){
        UserEntity user = service.createUser(UserToMapper.toUser(mapper));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserToMapper.toDto(user));
    }
    @GetMapping
    public ResponseEntity<?> getUsers(){
        List<UserMapper> usersDto = service.getAllUser().stream()
                .map(UserToMapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(usersDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        service.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable Long id, @RequestBody UserMapper dto) {

        UserEntity user= UserToMapper.toUser(dto);
        UserEntity userUpdate = service.updateUser(id, user);
        return userUpdate != null ?
                new ResponseEntity<>(userUpdate, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/profession")
    public ResponseEntity<?> getProfession(){
        List<String> profession = service.getProfession();
        return ResponseEntity.ok().body(profession);
    }
}
