package com.example.eShopping.dataAccess.abstracts;

import com.example.eShopping.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    boolean existsByName(String name);
    boolean  existsById(int id);
}
