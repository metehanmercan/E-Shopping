package com.example.eShopping.business.rule;

import com.example.eShopping.core.utilities.exceptions.BusinessException;
import com.example.eShopping.dataAccess.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class ProductBusinessRules {
    private ProductRepository productRepository;

    public void chekIfProductExistsName(String name){
        if (this.productRepository.existsByName(name)){
            throw new BusinessException("product name already exists");
        }}
    public void chekIfCategoryExistsId(int id){
        if (this.productRepository.existsById(id)==false){
            throw new BusinessException("product does not exists");
        }
    }
}
