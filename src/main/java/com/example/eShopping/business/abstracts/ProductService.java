package com.example.eShopping.business.abstracts;

import com.example.eShopping.business.request.CreateCategoryRequest;
import com.example.eShopping.business.request.CreateProductRequest;
import com.example.eShopping.business.request.UpdateProductRequest;
import com.example.eShopping.business.response.GetAllProductResponse;
import com.example.eShopping.business.response.GetByIdProductResponse;

import java.util.List;

public interface ProductService {
    List<GetAllProductResponse> getAll();

    GetByIdProductResponse getById(int id);

    void add(CreateProductRequest createProductRequest);

    void update(UpdateProductRequest updateProductRequest);

    void delete(int id);

}
