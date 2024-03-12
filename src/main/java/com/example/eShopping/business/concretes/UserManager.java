package com.example.eShopping.business.concretes;


import com.example.eShopping.business.abstracts.UserService;
import com.example.eShopping.business.request.CreateUserRequest;
import com.example.eShopping.business.response.GetAllUsersResponse;
import com.example.eShopping.core.utilities.mappers.ModelMapperService;
import com.example.eShopping.dataAccess.abstracts.UserRepository;
import com.example.eShopping.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private UserRepository userRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllUsersResponse> getAll() {
        List<User> users=this.userRepository.findAll();
        List<GetAllUsersResponse> getAllUsersResponses=users.stream().map(user -> this.modelMapperService.forResponse().map(user, GetAllUsersResponse.class)).collect(Collectors.toList());
        return getAllUsersResponses;
    }

    @Override
    public void add(CreateUserRequest createUserRequest) {
        User user=this.modelMapperService.forRequest().map(createUserRequest, User.class);
        this.userRepository.save(user);
    }
}
