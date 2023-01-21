package com.ojas.Shopping.services.dao;

import com.ojas.Shopping.entities.Product;
import com.ojas.Shopping.models.ImageModel;
import com.ojas.Shopping.models.ProductModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductServiceDAO {

    public List<Product> getAllProducts();
    public Optional<Product> getProductById(int id);
    public void createProduct(MultipartFile file,ProductModel productModel) throws IOException;
    public void updateProductById(int id,ProductModel productModel,MultipartFile imageModel) throws IOException;
    public void deleteProductById(int id);
    public void uploadImage(MultipartFile file);

}
