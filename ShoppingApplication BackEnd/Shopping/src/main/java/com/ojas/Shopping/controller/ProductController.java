package com.ojas.Shopping.controller;

import com.ojas.Shopping.dto.CategoryDTO;
import com.ojas.Shopping.dto.ProductDTO;
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
    public List<ProductDTO> viewAllProducts() {
        return productService.getAllProducts();
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
        return productService.createProduct(file, productDTO1);
    }

    @GetMapping("/data/{filename}")
    public Map<String, String> getImage(@PathVariable String filename) {
        byte[] data = productService.downloadImage(filename);
        String baseString = Base64.getEncoder().encodeToString(data);
        Map<String, String> filedata = new HashMap<>();
        filedata.put("baseUrl", baseString);
        return filedata;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
