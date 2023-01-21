package com.ojas.Shopping.controllers;

import com.ojas.Shopping.entities.Product;
import com.ojas.Shopping.models.ProductModel;
import com.ojas.Shopping.services.impl.ProductServiceDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ProductController {
    private final ProductServiceDAOImpl productServiceDAO;

    @Autowired
    public ProductController(ProductServiceDAOImpl productServiceDAO) {
        this.productServiceDAO = productServiceDAO;

    }

    @PostMapping("/hello")
    public void hello(@RequestParam MultipartFile file) {
        productServiceDAO.uploadImage(file);
    }

    @GetMapping("/list")
    public List<Product> viewAllProducts() {
        return productServiceDAO.getAllProducts();
    }

    @GetMapping("view/{id}")
    public Optional<Product> downloadImage(@PathVariable int id) {
        return productServiceDAO.getProductById(id);
    }

    @PostMapping("/create")
    public void createProduct(@RequestPart MultipartFile file,
                              @RequestParam(value = "product") String productModel) {
        System.out.println(productModel);
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(productModel);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        ProductModel productModel1 = new ProductModel();
        try {
            productModel1.setName(jsonObject.getString("name"));
            productModel1.setPrice(jsonObject.getDouble("price"));
            productModel1.setQuantity(jsonObject.getInt("quantity"));
            productModel1.setDescription(jsonObject.getString("description"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        System.out.println(productModel1);
        productServiceDAO.createProduct(file, productModel1);
    }

    @PutMapping("/update/{id}")
    public void updateProductById(@PathVariable int id
            , @RequestBody ProductModel productModel
            , @RequestParam("image") MultipartFile imageModel) {
        productServiceDAO.updateProductById(id, productModel, imageModel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable int id) {
        productServiceDAO.deleteProductById(id);
    }

}
