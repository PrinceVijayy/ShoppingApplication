package com.ojas.Shopping.repositories;

import com.ojas.Shopping.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image,Integer> {
    @Query("select i from Image i where name = ?1")
    Optional<Image> findByName(String fileName);
}
