package com.ojas.Shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
 @NoArgsConstructor
 @AllArgsConstructor
 public class ProductDTO {
     private Long id;
     private String name;
     private Double price;
     private Integer quantity;
     private String description;
     private String category;
//     private Set<CategoryDTO> categories;
 }



