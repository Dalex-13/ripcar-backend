package com.api.controller;

import com.api.model.Product;
import com.api.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProductController {

    @Autowired
    private ProductoService service;

    @PostMapping
    public ResponseEntity<Product> crearProduct(@RequestBody Product product){
        return new ResponseEntity<>(service.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> listarTodo(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/listall/{id}")
    public ResponseEntity<Product> listarProductoPorId(@PathVariable Integer id){
        return new ResponseEntity<>(service.ListByProductId(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> actualizarProductPorId(@PathVariable Integer id, @RequestBody Product product){
        //Product productupdate =  service.updateProductById(id, product);
        return new ResponseEntity<>(service.updateProductById(id, product), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarProductPorId(@PathVariable Integer id){
        service.deleteProductById(id);
    }


}
