package com.ojas.Shopping.service.impl;

import com.ojas.Shopping.entity.ImageEntity;
import com.ojas.Shopping.entity.ProductEntity;
import com.ojas.Shopping.dto.ProductDTO;
import com.ojas.Shopping.model.ImageModel;
import com.ojas.Shopping.model.ProductModel;
import com.ojas.Shopping.repository.ImageRepository;
import com.ojas.Shopping.repository.ProductRepository;
import com.ojas.Shopping.service.ProductService;
import com.ojas.Shopping.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ProductModel> getAllProducts() {
      List<ProductEntity> products= productRepository.findAll();
      List<ProductModel> productModels= new ArrayList<>();
        for (ProductEntity p:products ) {
            ProductModel productModel=new ProductModel();
            productModel.setId(p.getId());
            productModel.setName(p.getName());
            productModel.setDescription(p.getDescription());
            productModel.setQuantity(p.getQuantity());
            productModel.setPrice(p.getPrice());
            productModel.setCategory(p.getCategory());
            ImageModel imageModel=new ImageModel();
            imageModel.setFileName(p.getImage().getFileName());
            imageModel.setFileType(p.getImage().getFileType());
            imageModel.setImageInBase64(
                    ImageUtils.imageToBase64(p.getImage().getImageData())
            );
            productModel.setImage(imageModel);
            productModels.add(productModel);
        }
        return productModels;
    }



    public ProductModel getProductById(Long id) {
        ProductEntity p = productRepository.findById(id).get();
        ProductModel productModel=new ProductModel();
        productModel.setId(p.getId());
        productModel.setName(p.getName());
        productModel.setDescription(p.getDescription());
        productModel.setQuantity(p.getQuantity());
        productModel.setPrice(p.getPrice());
        productModel.setCategory(p.getCategory());
        ImageModel imageModel=new ImageModel();
        imageModel.setFileName(p.getImage().getFileName());
        imageModel.setFileType(p.getImage().getFileType());
        imageModel.setImageInBase64(
                ImageUtils.imageToBase64(p.getImage().getImageData())
        );
        productModel.setImage(imageModel);
        return productModel;
    }


    public int createProduct(MultipartFile file, ProductDTO productDTO)  {
        System.out.println("service top");
        ProductEntity productEntity =new ProductEntity();
        productEntity.setName(productDTO.getName());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setQuantity(productDTO.getQuantity());
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setFileName(file.getOriginalFilename());
        imageEntity.setFileType(file.getContentType());
        try {
            imageEntity.setImageData(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        productEntity.setImage(imageEntity);
        productEntity.setCategory(productDTO.getCategory());
        /*Set<Category> categories=new HashSet<>();
        for (CategoryDTO c: productDTO.getCategories()) {
            Category category=new Category();
            category.setName(c.getName());
        }
        product.setCategories(categories);*/
        try {
            productRepository.save(productEntity);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }


    public int updateProduct(MultipartFile file, ProductDTO productDTO) {
        System.out.println("service top");
        ProductEntity productEntity =new ProductEntity();
        productEntity.setName(productDTO.getName());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setQuantity(productDTO.getQuantity());
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setFileName(file.getOriginalFilename());
        imageEntity.setFileType(file.getContentType());
        try {
            imageEntity.setImageData(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        productEntity.setImage(imageEntity);
        productEntity.setCategory(productDTO.getCategory());
        /*Set<Category> categories=new HashSet<>();
        for (CategoryDTO c: productDTO.getCategories()) {
            Category category=new Category();
            category.setName(c.getName());
        }
        product.setCategories(categories);*/
        try {
            productRepository.save(productEntity);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }

    }


}
