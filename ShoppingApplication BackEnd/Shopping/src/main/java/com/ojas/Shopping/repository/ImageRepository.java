package com.ojas.Shopping.repository;

import com.ojas.Shopping.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
    ImageEntity findByFileName(String fileName);
    // other custom methods
}
