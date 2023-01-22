package com.ojas.Shopping.repository;

import com.ojas.Shopping.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findByFileName(String fileName);
    // other custom methods
}
