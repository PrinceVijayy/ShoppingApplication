package com.ojas.Shopping.service.impl;

import com.ojas.Shopping.entity.Image;
import com.ojas.Shopping.entity.Product;
import com.ojas.Shopping.dto.ProductDTO;
import com.ojas.Shopping.repository.ImageRepository;
import com.ojas.Shopping.repository.ProductRepository;
import com.ojas.Shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ImageRepository imageRepository) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
    }
    public List<ProductDTO> getAllProducts() {
        return Collections.EMPTY_LIST;
    }


    public ProductDTO getProductById(Long id) {
        return null;
    }


    public String createProduct(MultipartFile file, ProductDTO productDTO)  {
        System.out.println("service top");
        Product product=new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setQuantity(productDTO.getQuantity());
        Image image= new Image();
        image.setFileName(file.getOriginalFilename());
        image.setFileType(file.getContentType());
        try {
            image.setImageData(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        product.setImage(image);
        product.setCategory(productDTO.getCategory());
        /*Set<Category> categories=new HashSet<>();
        for (CategoryDTO c: productDTO.getCategories()) {
            Category category=new Category();
            category.setName(c.getName());
        }
        product.setCategories(categories);*/
        try {
            productRepository.save(product);
            return "Successfully Created";
        } catch (Exception e) {
            return "Failed To Create";
        }
    }


    public ProductDTO updateProduct(ProductDTO productDTO) {
        return null;
    }


    public void deleteProduct(Long id) {

    }

    public byte[] downloadImage(String fileName) {
        Image image= imageRepository.findByFileName(fileName);
        return image.getImageData();
    }


}
