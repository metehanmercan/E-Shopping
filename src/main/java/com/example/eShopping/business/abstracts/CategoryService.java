package com.example.eShopping.business.abstracts;

import com.example.eShopping.business.request.CreateCategoryRequest;
import com.example.eShopping.business.response.GetAllCategoryResponse;
import com.example.eShopping.business.response.GetByIdCategoriesResponse;
import com.example.eShopping.business.request.UpdateCategoryRequest;

import java.util.List;

public interface CategoryService {
    void add(CreateCategoryRequest createCategoryRequest);

    List<GetAllCategoryResponse> getAll();

    List<GetAllCategoryResponse> search(String keyword);

    GetByIdCategoriesResponse getById(int id);

    void delete(int id);

    void update(UpdateCategoryRequest updateCategoryRequest);
}
