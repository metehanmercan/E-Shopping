package com.example.eShopping.business.concretes;

import com.example.eShopping.business.abstracts.ProductService;
import com.example.eShopping.business.request.CreateCategoryRequest;
import com.example.eShopping.business.request.CreateProductRequest;
import com.example.eShopping.business.request.UpdateProductRequest;
import com.example.eShopping.business.response.GetAllProductResponse;
import com.example.eShopping.business.response.GetByIdProductResponse;
import com.example.eShopping.business.rule.ProductBusinessRules;
import com.example.eShopping.core.utilities.mappers.ModelMapperService;
import com.example.eShopping.dataAccess.abstracts.ProductRepository;
import com.example.eShopping.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ModelMapperService modelMapperService;
    private ProductRepository productRepository;
    private ProductBusinessRules productBusinessRules;

    @Override
    public List<GetAllProductResponse> getAll() {
        List<Product> products=productRepository.findAll();
        List<GetAllProductResponse> productResponses=products.stream()
                .map(product -> this.modelMapperService.forResponse().map(product, GetAllProductResponse.class)).collect(Collectors.toList());
        return productResponses;
    }

    @Override
    public GetByIdProductResponse getById(int id) {
        productBusinessRules.chekIfCategoryExistsId(id);
       Product product= productRepository.findById(id).orElseThrow();
       GetByIdProductResponse getByIdProductResponse=this.modelMapperService.forResponse().map(product,GetByIdProductResponse.class);
        return getByIdProductResponse;
    }

    @Override
    public void add(CreateProductRequest createProductRequest) {
        productBusinessRules.chekIfProductExistsName(createProductRequest.getName());
        Product product=this.modelMapperService.forRequest().map(createProductRequest, Product.class);
        this.productRepository.save(product);
    }

    @Override
    public void update(UpdateProductRequest updateProductRequest) {
        this.productBusinessRules.chekIfCategoryExistsId(updateProductRequest.getId());
        Product product=this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
        this.productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        this.productBusinessRules.chekIfCategoryExistsId(id);
        this.productRepository.deleteById(id);
    }
}
