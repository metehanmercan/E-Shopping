package com.example.eShopping.dataAccess.abstracts;

import com.example.eShopping.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByName(String name);

    boolean existsById(int id);

    boolean existsByEmail(String email);

    List<User> findByNameContaining(String keyword);

}
