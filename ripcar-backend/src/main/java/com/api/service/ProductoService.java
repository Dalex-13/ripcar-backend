package com.api.service;

import com.api.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    public Product createProduct(Product product);

    public List<Product> listAll();

    public Product ListByProductId(Integer id);

    public Product updateProductById(Integer id, Product product);

    public void deleteProductById(Integer id);
}
