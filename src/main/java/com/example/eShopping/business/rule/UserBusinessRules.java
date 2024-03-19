package com.example.eShopping.business.rule;


import com.example.eShopping.core.utilities.exceptions.BusinessException;
import com.example.eShopping.dataAccess.abstracts.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRules {
    private UserRepository userRepository;

    public void chekIfExistsName(String name) {
        if (userRepository.existsByName(name)) {
            throw new BusinessException("user name already exists");
        }
    }
    public void chekIfExistsNamee(String name) {
        if (userRepository.existsByName(name)==false) {
            throw new BusinessException("user name dont found");
        }
    }

    public void chekIfExistsId(int id) {
        if (userRepository.existsById(id) == false) {
            throw new BusinessException("id does not exists");
        }
    }

    public void chekIfExistsEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new BusinessException("email name already exists");
        }
    }

}
