package com.api.service;

import com.api.model.Product;
import com.api.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductoService{

    @Autowired
    public ProductRepository repository;


    @Override
    public Product createProduct(Product product) {
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setAmount(product.getAmount());
        newProduct.setPrice(product.getPrice());

        return repository.save(newProduct);
    }

    @Override
    public List<Product> listAll() {
        return repository.findAll();
    }

    @Override
    public Product ListByProductId(Integer id) {
        Product product =  repository.findById(id).orElseThrow(()-> new ResolutionException());
        return product;
    }

    @Override
    public Product updateProductById(Integer id, Product product) {
        Product productUpdate = repository.findById(id).orElseThrow(()-> new ResolutionException());
        productUpdate.setName(product.getName());
        productUpdate.setDescription(product.getDescription());
        productUpdate.setAmount(product.getAmount());
        productUpdate.setPrice(product.getPrice());
        Product productnew = repository.save(productUpdate);
        return productnew;
    }

    @Override
    public void deleteProductById(Integer id) {
        repository.deleteById(id);
    }
}
