package com.ra.service;

import com.ra.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> displayProducts(String productName, int page, int size, String direction, String sortBy);

    List<Integer> getListPage(String productName, int size);

    Product getProductById(String productId);

    Product save(Product product);

    boolean delete(String productId);
}
