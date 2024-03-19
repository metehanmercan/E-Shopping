package com.example.eShopping.dataAccess.abstracts;

import com.example.eShopping.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    boolean existsByName(String name);

    boolean existsById(int id);

    List<Category> findByNameContaining(String keyword);
}
