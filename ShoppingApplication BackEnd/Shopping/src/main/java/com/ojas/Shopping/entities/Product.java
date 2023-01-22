package com.ojas.Shopping.entities;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "this is a product table")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "this is the id of the product")
    private int id;

    @Column(name = "name")
    @ApiModelProperty(value = "this is the name of the product")
    private String name;

    @Column(name = "description")
    @ApiModelProperty(value = "this is the description of the product")
    private String description;

    @Column(name = "price")
    @ApiModelProperty(value = "this is the price of the product")
    private double price;

    @Column(name = "quantity")
    @ApiModelProperty(value = "this is the quantity of the product")
    private int quantity;

//    @Column(name = "category", nullable = false)
//    private String category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    @ApiModelProperty(value = "this is the image of the product")
    private Image image;


}

