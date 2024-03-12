package com.example.eShopping.business.abstracts;

import com.example.eShopping.business.request.CreateCategoryRequest;
import com.example.eShopping.business.request.CreateProductRequest;
import com.example.eShopping.business.request.UpdateProductRequest;
import com.example.eShopping.business.response.GetAllProductResponse;

import java.util.List;

public interface ProductService {
    List<GetAllProductResponse> getAll();
    void  add(CreateProductRequest createProductRequest);

    void update(UpdateProductRequest updateProductRequest);
    void delete(int id);
}
