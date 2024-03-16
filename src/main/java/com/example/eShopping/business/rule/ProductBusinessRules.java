package com.example.eShopping.business.rule;

import com.example.eShopping.core.utilities.exceptions.BusinessException;
import com.example.eShopping.dataAccess.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class ProductBusinessRules {
    private ProductRepository productRepository;

    private CategoryBusinessRules categoryBusinessRules;

    public void chekIfProductExistsName(String name) {
        if (this.productRepository.existsByName(name)) {
            throw new BusinessException("product name already exists");
        }
    }

    public void chekIfCategoryExistsId(int id) {
        if (this.productRepository.existsById(id) == false) {
            throw new BusinessException("product does not exists");
        }
    }

    public void checkProductPrice(double price) {
        if (price < 100.0) {
            throw new BusinessException("Product price cannot be less than 100 TL.");
        }

    }

    public void dontFindCategory(String name) {
        this.categoryBusinessRules.chekIfCategoryExistsNamee(name);
    }

}
