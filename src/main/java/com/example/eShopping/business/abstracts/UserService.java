package com.example.eShopping.business.abstracts;

import com.example.eShopping.business.request.CreateUserRequest;
import com.example.eShopping.business.request.UpdateUserRequest;
import com.example.eShopping.business.response.GetAllUsersResponse;
import com.example.eShopping.business.response.GetByIdUserResponse;

import java.util.List;

public interface UserService {
    List<GetAllUsersResponse> getAll();


    GetByIdUserResponse getById(int id);

    void add(CreateUserRequest createUserRequest);

    void delete(int id);
    void update(UpdateUserRequest updateUserRequest);
}
