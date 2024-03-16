package com.example.eShopping.business.response;


import com.example.eShopping.business.request.CreateProductRequest;
import com.example.eShopping.entities.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponse {





    private int id;
    private String name;
    private String categoryName;
    private double price;
    private String colour;
}
