package com.ojas.Shopping.controller;

import com.ojas.Shopping.dto.CategoryDTO;
import com.ojas.Shopping.dto.ProductDTO;
import com.ojas.Shopping.model.ProductModel;
import com.ojas.Shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public List<ProductModel> viewAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/view/{id}")
    public ProductModel viewProduct(@PathVariable Long id){
        return productService.getProductById(id);
    }


    @PostMapping("/create")
    public String createProduct(@RequestPart MultipartFile file,
                                @RequestParam(value = "product") String productDTO) {
        System.out.println(productDTO);
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(productDTO);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        ProductDTO productDTO1 = new ProductDTO();
        try {
            productDTO1.setName(jsonObject.getString("name"));
            productDTO1.setPrice(jsonObject.getDouble("price"));
            productDTO1.setQuantity(jsonObject.getInt("quantity"));
            productDTO1.setDescription(jsonObject.getString("description"));
            productDTO1.setCategory(jsonObject.getString("category"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        System.out.println(productDTO1);
        if(productService.createProduct(file, productDTO1)==1){
            return "Successfully Created";
        }else return "Failed to Create";
    }

    @PostMapping("/update")
    public String updateProduct(@RequestPart MultipartFile file,
                                @RequestParam(value = "product") String productDTO) {
        System.out.println(productDTO);
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(productDTO);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        ProductDTO productDTO1 = new ProductDTO();
        try {
            productDTO1.setName(jsonObject.getString("name"));
            productDTO1.setPrice(jsonObject.getDouble("price"));
            productDTO1.setQuantity(jsonObject.getInt("quantity"));
            productDTO1.setDescription(jsonObject.getString("description"));
            productDTO1.setCategory(jsonObject.getString("category"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        System.out.println(productDTO1);
        if(productService.updateProduct(file, productDTO1)==1){
            return "Successfully Updated";
        }else return "Failed to Update";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
