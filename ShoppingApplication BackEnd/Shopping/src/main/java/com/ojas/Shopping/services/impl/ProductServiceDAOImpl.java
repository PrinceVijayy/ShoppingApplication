package com.ojas.Shopping.services.impl;

import com.ojas.Shopping.entities.Image;
import com.ojas.Shopping.entities.Product;
import com.ojas.Shopping.models.ImageModel;
import com.ojas.Shopping.models.ProductModel;
import com.ojas.Shopping.repositories.ImageRepository;
import com.ojas.Shopping.repositories.ProductRepository;
import com.ojas.Shopping.services.dao.ProductServiceDAO;
import com.ojas.Shopping.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductServiceDAOImpl implements ProductServiceDAO {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ImageRepository imageRepository;
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public void createProduct(MultipartFile file,ProductModel productModel)  {
        System.out.println("service top");
        Product product=new Product();
        product.setName(productModel.getName());
        product.setPrice(productModel.getPrice());
        product.setDescription(productModel.getDescription());
        product.setQuantity(productModel.getQuantity());
        Image image= new Image();
        image.setName(file.getOriginalFilename());
        image.setType(file.getContentType());
        try {
            image.setImage(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        product.setImage(image);
//        product.setCategory(productModel.getCategory());
        productRepository.save(product);
        System.out.println("service bottom");
    }

    public void updateProductById(int id, ProductModel productModel,MultipartFile file) {

        Product product=new Product();
        product.setName(productModel.getName());
        product.setPrice(productModel.getPrice());
        product.setDescription(productModel.getDescription());
        product.setQuantity(productModel.getQuantity());
        Image image= null;
        try {
            image = Image.builder()
                    .name(file.getOriginalFilename())
                    .type(file.getContentType())
                    .image(ImageUtils.compressImage(file.getBytes())).build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        product.setImage(image);
//        product.setCategory(productModel.getCategory());
        productRepository.save(product);
    }

    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }

    public void uploadImage(MultipartFile file) {
        Image image=new Image();
        image.setName(file.getOriginalFilename());
        image.setType(file.getContentType());
        try {
            image.setImage(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        imageRepository.save(image);
    }

    public byte[] downloadImage(String fileName){
        Optional<Image> dbImageData = imageRepository.findByName(fileName);
        byte[] images=dbImageData.get().getImage();
        return images;
    }
}
