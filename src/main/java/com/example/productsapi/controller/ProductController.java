package com.example.productsapi.controller;

import com.example.productsapi.model.Product;
import com.example.productsapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        System.out.println("Product saved" + product);

        var id = UUID.randomUUID().toString();
        product.setId(id);

        productRepository.save(product);
        return product;
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable("id") String id) {

        return productRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable("id") String id) {
        productRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void updateProductById(@RequestBody Product product, @PathVariable("id") String id) {

        product.setId(id);
        productRepository.save(product);
    }

    @GetMapping
    public List<Product> getProductByName(@RequestParam("name") String name) {
        return productRepository.findByName(name);
    }
}
