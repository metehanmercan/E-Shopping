package com.example.eShopping.dataAccess.abstracts;

import com.example.eShopping.entities.concretes.FavoriteProduct;
import com.example.eShopping.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;


public interface FavoriteProductRepository extends JpaRepository<FavoriteProduct,Integer> {
    List<FavoriteProduct> findByUserName(String userName);

    List<FavoriteProduct> findByCategory_IdOrderByProduct_PriceAsc(int categoryId);

    default List<FavoriteProduct> search(String sortBy, int categoryId) {
        // Kategoriye göre filtreleme
        if (categoryId != 0) {
            return findByCategory_IdOrderByProduct_PriceAsc(categoryId);
        }

        return findAll(); // Varsayılan olarak tüm favori ürünleri getir
    }

}
