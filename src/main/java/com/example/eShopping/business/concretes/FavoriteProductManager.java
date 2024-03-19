package com.example.eShopping.business.concretes;

import com.example.eShopping.business.abstracts.FavoriteProductService;
import com.example.eShopping.business.request.CreateFavoriteProductRequest;
import com.example.eShopping.business.response.GetAllFavoriteProductResponse;
import com.example.eShopping.business.rule.CategoryBusinessRules;
import com.example.eShopping.business.rule.ProductBusinessRules;
import com.example.eShopping.business.rule.UserBusinessRules;
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
    private ProductBusinessRules productBusinessRules;
    private CategoryBusinessRules categoryBusinessRules;
    private UserBusinessRules userBusinessRules;

    @Override
    public List<GetAllFavoriteProductResponse> getAll() {
        List<FavoriteProduct> favoriteProducts = this.favoriteProductRepository.findAll();
        List<GetAllFavoriteProductResponse> getAllFavoriteProductResponses = favoriteProducts.stream().map(favoriteProduct -> this.modelMapperService.forResponse().map(favoriteProduct, GetAllFavoriteProductResponse.class)).collect(Collectors.toList());

        return getAllFavoriteProductResponses;
    }

    @Override
    public List<GetAllFavoriteProductResponse> search(String keyword) {
       if (keyword!=null){
           List<FavoriteProduct> favoriteProducts=this.favoriteProductRepository.findByProduct_NameContaining(keyword);
           List<GetAllFavoriteProductResponse> getAllFavoriteProductResponses=favoriteProducts.stream().map(favoriteProduct -> this.modelMapperService.forResponse().map(favoriteProduct, GetAllFavoriteProductResponse.class)).collect(Collectors.toList());
           return getAllFavoriteProductResponses;
       }else {
           List<FavoriteProduct> favoriteProducts=this.favoriteProductRepository.findAll();
           List<GetAllFavoriteProductResponse> getAllFavoriteProductResponses = favoriteProducts.stream().map(favoriteProduct -> this.modelMapperService.forResponse().map(favoriteProduct, GetAllFavoriteProductResponse.class)).collect(Collectors.toList());
           return getAllFavoriteProductResponses;
       }
    }

    @Override
    public void add(CreateFavoriteProductRequest createFavoriteProductRequest) {
        this.productBusinessRules.chekIfCategoryExistsId(createFavoriteProductRequest.getProductId());
        this.categoryBusinessRules.chekIfCategoryExistsId(createFavoriteProductRequest.getCategoryId());
        FavoriteProduct favoriteProduct = this.modelMapperService.forRequest().map(createFavoriteProductRequest, FavoriteProduct.class);
        this.favoriteProductRepository.save(favoriteProduct);
    }

    @Override
    public void delete(int id) {
        this.productBusinessRules.chekIfProductExistsId(id);
        this.favoriteProductRepository.deleteById(id);
    }

    @Override
    public List<GetAllFavoriteProductResponse> getFavoriteProductAll(String userName) {
        this.userBusinessRules.chekIfExistsNamee(userName);
        List<FavoriteProduct> favoriteProducts = favoriteProductRepository.findByUserName(userName);
        List<GetAllFavoriteProductResponse> getAllFavoriteProductResponseList = favoriteProducts.stream().map(favoriteProduct -> this.modelMapperService.forResponse().map(favoriteProduct, GetAllFavoriteProductResponse.class)).collect(Collectors.toList());
        return getAllFavoriteProductResponseList;
    }

    @Override
    public List<GetAllFavoriteProductResponse> search(String sortBy, int categoryId) {
        this.categoryBusinessRules.chekIfCategoryExistsId(categoryId);
        List<FavoriteProduct> favoriteProducts = favoriteProductRepository.search(sortBy, categoryId);
        List<GetAllFavoriteProductResponse> getAllFavoriteProductResponses = favoriteProducts.stream().map(favoriteProduct -> this.modelMapperService.forResponse().map(favoriteProduct, GetAllFavoriteProductResponse.class)).collect(Collectors.toList());
        return getAllFavoriteProductResponses;
    }
}
