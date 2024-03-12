package com.example.eShopping.dataAccess.abstracts;

import com.example.eShopping.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
   boolean existsByName(String name);
   boolean existsById(int id);
}
