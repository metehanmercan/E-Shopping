package com.example.eShopping.webApi.controllers;


import com.example.eShopping.business.abstracts.ProductService;
import com.example.eShopping.business.request.CreateProductRequest;
import com.example.eShopping.business.request.UpdateCategoryRequest;
import com.example.eShopping.business.request.UpdateProductRequest;
import com.example.eShopping.business.response.GetAllProductResponse;
import com.example.eShopping.business.response.GetByIdProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductControllers {
    private ProductService productService;


    @GetMapping()
    public List<GetAllProductResponse> getAll(){
        return productService.getAll();
    }
    @PostMapping
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateProductRequest createProductRequest){
        this.productService.add(createProductRequest);
    }

    @PutMapping()
    public void update(UpdateProductRequest updateProductRequest){
        this.productService.update(updateProductRequest);
    }
    @DeleteMapping("/{id}")
    public void delete( @PathVariable int id){
        this.productService.delete(id);
    }

    @GetMapping("/{id}")
    public GetByIdProductResponse getById(@PathVariable  int id){
        return  this.productService.getById(id);
    }
}
