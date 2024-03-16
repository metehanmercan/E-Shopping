package com.example.eShopping.business.concretes;


import com.example.eShopping.business.abstracts.UserService;
import com.example.eShopping.business.request.CreateUserRequest;
import com.example.eShopping.business.request.UpdateUserRequest;
import com.example.eShopping.business.response.GetAllUsersResponse;
import com.example.eShopping.business.response.GetByIdUserResponse;
import com.example.eShopping.business.rule.UserBusinessRules;
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
    private UserBusinessRules userBusinessRules;


    @Override
    public List<GetAllUsersResponse> getAll() {
        List<User> users = this.userRepository.findAll();
        List<GetAllUsersResponse> getAllUsersResponses = users.stream().map(user -> this.modelMapperService.forResponse().map(user, GetAllUsersResponse.class)).collect(Collectors.toList());
        return getAllUsersResponses;
    }

    @Override
    public GetByIdUserResponse getById(int id) {
        this.userBusinessRules.chekIfExistsId(id);
        User user = this.userRepository.findById(id).orElseThrow();
        GetByIdUserResponse getByIdUserResponse = this.modelMapperService.forResponse().map(user, GetByIdUserResponse.class);
        return getByIdUserResponse;
    }


    @Override
    public void add(CreateUserRequest createUserRequest) {
        this.userBusinessRules.chekIfExistsName(createUserRequest.getName());
        this.userBusinessRules.chekIfExistsEmail(createUserRequest.getEmail());
        User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);
        this.userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        this.userBusinessRules.chekIfExistsId(id);
        userRepository.deleteById(id);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        this.userBusinessRules.chekIfExistsId(updateUserRequest.getId());
        this.userBusinessRules.chekIfExistsEmail(updateUserRequest.getEmail());
      //   this.userBusinessRules.chekIfExistsName(updateUserRequest.getName()); // burası çalıştığı zaman kullanıcın sadece email kısmını değişemiyorum
                                                                                 //   çünkü d.base de aynı ismi farklı kullanıcıya ait gibi görüyor
        User user = this.modelMapperService.forRequest().map(updateUserRequest, User.class);
        this.userRepository.save(user);
    }
}
