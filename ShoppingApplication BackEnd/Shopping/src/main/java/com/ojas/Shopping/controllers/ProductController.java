package com.ojas.Shopping.controllers;

import com.ojas.Shopping.entities.Product;
import com.ojas.Shopping.models.ProductModel;
import com.ojas.Shopping.services.impl.ProductServiceDAOImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/product")
public class ProductController {
    private final ProductServiceDAOImpl productServiceDAO;

    @Autowired
    public ProductController(ProductServiceDAOImpl productServiceDAO) {
        this.productServiceDAO = productServiceDAO;

    }

    @GetMapping("view/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
        byte[] imageData=productServiceDAO.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);

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
    @ApiOperation(value = "Creates a Product",
    notes = "It will create a product which has a image in it and add it to the database",
    response = void.class)
    public void createProduct(@ApiParam(value = "this is an image file") @RequestPart MultipartFile file,
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
