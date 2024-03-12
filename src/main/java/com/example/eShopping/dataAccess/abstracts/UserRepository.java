package com.example.eShopping.dataAccess.abstracts;

import com.example.eShopping.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
