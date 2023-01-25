package com.ojas.Shopping.model;

import com.ojas.Shopping.dto.ImageDTO;
import com.ojas.Shopping.entity.ImageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private String description;
    private String category;

    private ImageModel image;
//     private Set<CategoryDTO> categories;
}


