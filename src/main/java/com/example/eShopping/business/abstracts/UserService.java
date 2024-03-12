package com.example.eShopping.business.abstracts;

import com.example.eShopping.business.request.CreateUserRequest;
import com.example.eShopping.business.response.GetAllUsersResponse;

import java.util.List;

public interface UserService {
    List<GetAllUsersResponse> getAll();
    void add(CreateUserRequest createUserRequest);
}
