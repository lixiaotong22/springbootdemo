package com.example.springbootdemo.controller;

import com.example.springbootdemo.domain.Product;
import com.example.springbootdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getProductInfo(@PathVariable("id") int productId) {
        return productService.select(productId);
    }

    @PutMapping("/{id}")
    public Product updateProductInfo(@PathVariable("id") int productId, @RequestBody Product newProduct) {
        Product product = productService.select(productId);
        if (product != null) {
            product.setName(newProduct.getName());
            product.setPrice(newProduct.getPrice());
            return productService.update(product);
        } else {
            return null;
        }
    }

    @PostMapping()
    public Product AddProductInfo(@RequestBody Product newProduct) {
        return productService.insert(newProduct);
    }

    @DeleteMapping("/{id}")
    public int DeleteProductInfo(@PathVariable("id") int productId) {
        return productService.delete(productId);
    }

}
