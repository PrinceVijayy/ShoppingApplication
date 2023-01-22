package com.ojas.Shopping.service;

import com.ojas.Shopping.dto.ProductDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    public List<ProductDTO> getAllProducts();
    public ProductDTO getProductById(Long id) ;
    public String createProduct(MultipartFile file, ProductDTO productDTO) ;

    public ProductDTO updateProduct(ProductDTO productDTO);

    public void deleteProduct(Long id) ;

    public byte[] downloadImage(String fileName) ;

}
