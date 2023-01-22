package com.ojas.Shopping.repository;

import com.ojas.Shopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
//    List<Product> findByCategories_Name(String categoryName);
    // other custom methods
}
