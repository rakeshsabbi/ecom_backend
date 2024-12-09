package com.telusko.ecom_proj.repository;

import com.telusko.ecom_proj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p from Product p WHERE " +
            "LOWER(p.name) Like lower(concat('%', :keyword, '%') ) OR "+
            "LOWER(p.description) Like lower(concat('%', :keyword, '%') ) OR "+
            "LOWER(p.brand) Like lower(concat('%', :keyword, '%') ) OR "+
            "LOWER(p.category) Like lower(concat('%', :keyword, '%') ) ")
    List<Product> searchProducts(String keyword);
}
