package com.example.eShopping.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ıd")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "colour")
    private String colour;

    @Column(name = "price")
    private double price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;


    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<FavoriteProduct> favoriteProduct;
}
