package com.example.eShopping.business.concretes;

import com.example.eShopping.business.abstracts.FavoriteProductService;
import com.example.eShopping.business.request.CreateFavoriteProductRequest;
import com.example.eShopping.business.response.GetAllFavoriteProductResponse;
import com.example.eShopping.core.utilities.mappers.ModelMapperService;
import com.example.eShopping.dataAccess.abstracts.FavoriteProductRepository;
import com.example.eShopping.entities.concretes.FavoriteProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class FavoriteProductManager implements FavoriteProductService {

    private ModelMapperService modelMapperService;
    private FavoriteProductRepository favoriteProductRepository;

    @Override
    public List<GetAllFavoriteProductResponse> getAll() {
        List<FavoriteProduct> favoriteProducts = this.favoriteProductRepository.findAll();
        List<GetAllFavoriteProductResponse> getAllFavoriteProductResponses = favoriteProducts.stream().map(favoriteProduct -> this.modelMapperService.forResponse().map(favoriteProduct, GetAllFavoriteProductResponse.class)).collect(Collectors.toList());

        return getAllFavoriteProductResponses;
    }

    @Override
    public void add(CreateFavoriteProductRequest createFavoriteProductRequest) {
        FavoriteProduct favoriteProduct = this.modelMapperService.forRequest().map(createFavoriteProductRequest, FavoriteProduct.class);
        this.favoriteProductRepository.save(favoriteProduct);
    }

    @Override
    public void delete(int id) {
        this.favoriteProductRepository.deleteById(id);
    }

    @Override
    public List<GetAllFavoriteProductResponse> getFavoriteProductAll(String userName) {
        List<FavoriteProduct> favoriteProducts = favoriteProductRepository.findByUserName(userName);
        List<GetAllFavoriteProductResponse> getAllFavoriteProductResponseList = favoriteProducts.stream().map(favoriteProduct -> this.modelMapperService.forResponse().map(favoriteProduct, GetAllFavoriteProductResponse.class)).collect(Collectors.toList());
        return getAllFavoriteProductResponseList;
    }

    @Override
    public List<GetAllFavoriteProductResponse> search(String sortBy, int categoryId) {
        List<FavoriteProduct> favoriteProducts = favoriteProductRepository.search(sortBy, categoryId);
        List<GetAllFavoriteProductResponse> getAllFavoriteProductResponses = favoriteProducts.stream().map(favoriteProduct -> this.modelMapperService.forResponse().map(favoriteProduct, GetAllFavoriteProductResponse.class)).collect(Collectors.toList());
        return getAllFavoriteProductResponses;
    }
}
