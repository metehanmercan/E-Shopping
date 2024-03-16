package com.example.eShopping.business.rule;

import com.example.eShopping.core.utilities.exceptions.BusinessException;
import com.example.eShopping.dataAccess.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryBusinessRules {
    private CategoryRepository categoryRepository;


    public void chekIfCategoryExistsName(String name) {
        if (categoryRepository.existsByName(name)) {
            throw new BusinessException("category name already exists");
        }
    }

    public void chekIfCategoryExistsId(int id) {
        if (categoryRepository.existsById(id) == false) {
            throw new BusinessException("category does not exists");
        }
    }

    public void chekIfCategoryExistsNamee(String name) {
        if (categoryRepository.existsByName(name) == false) {
            throw new BusinessException("Category not found.");
        }
    }
}
