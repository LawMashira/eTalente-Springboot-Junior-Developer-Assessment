package com.enviro.assessment.grad001.lawsonmatutu.service;

import com.enviro.assessment.grad001.lawsonmatutu.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    Product saveProduct(Product product);

    void deleteProduct(Long id);


}
