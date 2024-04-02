package com.projetowebspring.course.resources;

import com.projetowebspring.course.entities.Product;
import com.projetowebspring.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.Long;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping (value = "/products")
public class ProductResources {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>>findAll(){
        List<Product> list = productService.findAll();

        return ResponseEntity.ok().body(list);
    }
    @GetMapping (value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){

        Product product = productService.findById(id);
        return ResponseEntity.ok().body(product);
    }
}
