package com.ojas.Shopping.service;

import com.ojas.Shopping.dto.ProductDTO;
import com.ojas.Shopping.model.ProductModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    public List<ProductModel> getAllProducts();
    public ProductModel getProductById(Long id) ;
    public int createProduct(MultipartFile file, ProductDTO productDTO) ;

    public int updateProduct(MultipartFile file, ProductDTO productDTO);

    public int deleteProduct(Long id) ;


}
