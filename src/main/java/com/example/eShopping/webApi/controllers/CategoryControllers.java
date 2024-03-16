package com.example.eShopping.webApi.controllers;


import com.example.eShopping.business.abstracts.CategoryService;
import com.example.eShopping.business.request.CreateCategoryRequest;
import com.example.eShopping.business.response.GetAllCategoryResponse;
import com.example.eShopping.business.response.GetByIdCategoriesResponse;
import com.example.eShopping.business.request.UpdateCategoryRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryControllers {
    private CategoryService categoryService;

    @GetMapping
    public List<GetAllCategoryResponse> getAll() {
        return categoryService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateCategoryRequest createCategoryRequest) {
        this.categoryService.add(createCategoryRequest);
    }

    @GetMapping("/{id}")
    public GetByIdCategoriesResponse geyById(@PathVariable int id) {
        return categoryService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.categoryService.delete(id);
    }

    @PutMapping()
    public void update(UpdateCategoryRequest updateCategoryRequest) {
        this.categoryService.update(updateCategoryRequest);
    }


}
