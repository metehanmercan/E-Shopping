package com.example.eShopping.webApi.controllers;


import com.example.eShopping.business.abstracts.FavoriteProductService;
import com.example.eShopping.business.request.CreateFavoriteProductRequest;
import com.example.eShopping.business.response.GetAllFavoriteProductResponse;
import com.example.eShopping.entities.concretes.FavoriteProduct;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/favoriteProduct")
@AllArgsConstructor
public class FavoriteProductControllers {
    private FavoriteProductService favoriteProductService;


    @GetMapping
    public List<GetAllFavoriteProductResponse> getAll() {
        return this.favoriteProductService.getAll();
    }


    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateFavoriteProductRequest createFavoriteProductRequest) {
        this.favoriteProductService.add(createFavoriteProductRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.favoriteProductService.delete(id);
    }


    @GetMapping("/api/favoriteProduct/{userName}")
    public List<GetAllFavoriteProductResponse> getFavoriteAll(String userName){
        return this.favoriteProductService.getFavoriteProductAll(userName);
    }

    @GetMapping("/api/favoriteSearch")
    public ResponseEntity<List<GetAllFavoriteProductResponse>> searchFavoriteProducts(@RequestParam(required = false) String sortBy, @RequestParam(required = false) int categoryId) {
        List<GetAllFavoriteProductResponse> favoriteProducts = favoriteProductService.search(sortBy, categoryId);
        return ResponseEntity.ok(favoriteProducts);
    }
}
