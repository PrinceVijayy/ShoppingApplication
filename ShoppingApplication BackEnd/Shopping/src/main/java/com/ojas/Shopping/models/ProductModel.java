package com.ojas.Shopping.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 @Data
 @NoArgsConstructor
 @AllArgsConstructor
 public class ProductModel {
     private String name;
     private String description;
     private double price;
     private int quantity;

 }



