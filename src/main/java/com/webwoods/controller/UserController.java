package com.webwoods.controller;


import com.webwoods.dto.UserDto;
import com.webwoods.entity.UserEntity;
import com.webwoods.service.UserService;
import com.webwoods.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @MutationMapping
    public ResponseEntity<StandardResponse> createUser(@Argument UserDto userDto) {
        String message = userService.createUser(userDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message), HttpStatus.CREATED
        );
    }


    @QueryMapping
    public List<UserEntity> userAll() {
        return userService.findAll();
    }

    @QueryMapping
    public UserEntity userById(@Argument Integer id) {
        return userService.findById(id);
    }
}
