package com.example.eShopping.webApi.controllers;


import com.example.eShopping.business.abstracts.UserService;
import com.example.eShopping.business.request.CreateUserRequest;
import com.example.eShopping.business.request.UpdateUserRequest;
import com.example.eShopping.business.response.GetAllUsersResponse;
import com.example.eShopping.business.response.GetByIdUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserControllers {

    private UserService userService;

    @GetMapping()
    public List<GetAllUsersResponse> getAll() {
        return this.userService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateUserRequest createUserRequest) {
        this.userService.add(createUserRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.userService.delete(id);
    }

    @GetMapping("/{id}")

    public GetByIdUserResponse getById(int id) {
        return this.userService.getById(id);
    }

    @PutMapping
    public void update(UpdateUserRequest updateUserRequest) {
        this.userService.update(updateUserRequest);
    }
}
