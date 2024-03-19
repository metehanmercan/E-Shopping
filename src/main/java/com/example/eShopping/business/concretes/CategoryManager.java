package com.example.eShopping.business.concretes;

import com.example.eShopping.business.abstracts.CategoryService;
import com.example.eShopping.business.request.CreateCategoryRequest;
import com.example.eShopping.business.response.GetAllCategoryResponse;
import com.example.eShopping.business.response.GetByIdCategoriesResponse;
import com.example.eShopping.business.request.UpdateCategoryRequest;
import com.example.eShopping.business.rule.CategoryBusinessRules;
import com.example.eShopping.core.utilities.mappers.ModelMapperService;
import com.example.eShopping.dataAccess.abstracts.CategoryRepository;
import com.example.eShopping.entities.concretes.Category;
import com.example.eShopping.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;
    private CategoryBusinessRules categoryBusinessRules;


    @Override
    public void add(CreateCategoryRequest createCategoryRequest) {
        categoryBusinessRules.chekIfCategoryExistsName(createCategoryRequest.getName());
        Category category = this.modelMapperService.forRequest().map(createCategoryRequest, Category.class);
        this.categoryRepository.save(category);
    }

    @Override
    public List<GetAllCategoryResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoryResponse> categoryResponses = categories.stream().map(category -> this.modelMapperService.forResponse().map(category, GetAllCategoryResponse.class)).collect(Collectors.toList());
        return categoryResponses;
    }

    @Override
    public List<GetAllCategoryResponse> search(String keyword) {

        if(keyword!=null){
        List<Category> categories=this.categoryRepository.findByNameContaining(keyword);
        List<GetAllCategoryResponse> getAllCategoryResponses=categories.stream().map(category -> this.modelMapperService.forResponse().map(category, GetAllCategoryResponse.class)).collect(Collectors.toList());
        return getAllCategoryResponses;
    }else {
            List<Category> categories = categoryRepository.findAll();
            List<GetAllCategoryResponse> categoryResponses = categories.stream().map(category -> this.modelMapperService.forResponse().map(category, GetAllCategoryResponse.class)).collect(Collectors.toList());
            return categoryResponses;

        }
    }

    @Override
    public GetByIdCategoriesResponse getById(int id) {
        this.categoryBusinessRules.chekIfCategoryExistsId(id);
        Category category = this.categoryRepository.findById(id).orElseThrow();
        GetByIdCategoriesResponse getByIdCategoriesResponse = this.modelMapperService.forResponse().map(category, GetByIdCategoriesResponse.class);
        return getByIdCategoriesResponse;
    }

    @Override
    public void delete(int id) {
        this.categoryBusinessRules.chekIfCategoryExistsId(id);
        this.categoryRepository.deleteById(id);
    }

    @Override
    public void update(UpdateCategoryRequest updateCategoryRequest) {

        categoryBusinessRules.chekIfCategoryExistsId(updateCategoryRequest.getId());
        Category category = this.modelMapperService.forRequest().map(updateCategoryRequest, Category.class);
        this.categoryRepository.save(category);


    }




}
