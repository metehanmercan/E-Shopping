package com.example.eShopping.dataAccess.abstracts;

import com.example.eShopping.entities.concretes.FavoriteProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FavoriteProductRepository extends JpaRepository<FavoriteProduct, Integer> {
    List<FavoriteProduct> findByUserName(String userName);
    List<FavoriteProduct> findByProduct_NameContaining(String keyword);

    List<FavoriteProduct> findByCategory_IdOrderByProduct_PriceAsc(int categoryId);

    default List<FavoriteProduct> search(String sortBy, int categoryId) {
        // Kategoriye göre filtreleme
        if (categoryId != 0) {
            return findByCategory_IdOrderByProduct_PriceAsc(categoryId);
        }
        return findAll(); // Varsayılan olarak tüm favori ürünleri getir
    }



}
