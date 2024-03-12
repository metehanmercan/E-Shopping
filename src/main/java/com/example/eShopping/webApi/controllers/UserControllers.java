package com.example.eShopping.webApi.controllers;


import com.example.eShopping.business.abstracts.UserService;
import com.example.eShopping.business.request.CreateUserRequest;
import com.example.eShopping.business.response.GetAllUsersResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserControllers {

    private UserService userService;

    @GetMapping()
    public List<GetAllUsersResponse> getAll(){
        return this.userService.getAll();
    }

    @PostMapping
    @ResponseStatus(code=HttpStatus.CHECKPOINT)
    public void add(CreateUserRequest createUserRequest){
        this.userService.add(createUserRequest);
    }
}
