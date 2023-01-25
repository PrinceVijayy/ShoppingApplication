package com.ojas.Shopping.repository;

import com.ojas.Shopping.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity findByName(String name);
//    List<Product> findByCategories_Name(String categoryName);
    // other custom methods
}
