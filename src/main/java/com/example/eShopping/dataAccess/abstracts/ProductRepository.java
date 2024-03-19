package com.example.eShopping.dataAccess.abstracts;

import com.example.eShopping.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    boolean existsByName(String name);

    boolean existsById(int id);

    List<Product> findByNameContaining(String keyword);
}
