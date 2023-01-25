package com.ojas.Shopping.service;

import com.ojas.Shopping.dto.ProductDTO;
import com.ojas.Shopping.model.ProductModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    public List<ProductModel> getAllProducts();
    public ProductDTO getProductById(Long id) ;
    public String createProduct(MultipartFile file, ProductDTO productDTO) ;

    public ProductDTO updateProduct(ProductDTO productDTO);

    public void deleteProduct(Long id) ;

    public byte[] downloadImage(String fileName) ;

}
