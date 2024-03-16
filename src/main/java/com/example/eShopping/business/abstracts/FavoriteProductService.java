package com.example.eShopping.business.abstracts;

import com.example.eShopping.business.request.CreateFavoriteProductRequest;
import com.example.eShopping.business.response.GetAllFavoriteProductResponse;

import java.util.List;

public interface FavoriteProductService {
    List<GetAllFavoriteProductResponse> getAll();

    void add(CreateFavoriteProductRequest createFavoriteProductRequest);


    void delete(int id);

    List<GetAllFavoriteProductResponse> getFavoriteProductAll(String userName);

    List<GetAllFavoriteProductResponse> search(String sortBy, int categoryId);
}
