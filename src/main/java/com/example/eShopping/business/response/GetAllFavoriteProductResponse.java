package com.example.eShopping.business.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllFavoriteProductResponse {

    private int id;

    private String userName;

    private String productName;

    private String categoryName;

    private double price;
}
