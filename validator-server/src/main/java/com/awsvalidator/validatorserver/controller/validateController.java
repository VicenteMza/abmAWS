package com.awsvalidator.validatorserver.controller;

import com.awsvalidator.validatorserver.mapper.UserMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/validation")
public class validateController {

    @PostMapping("/user")
    public ResponseEntity<?> validateUser(@Valid @RequestBody UserMapper mapper){
        System.out.println(mapper);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
