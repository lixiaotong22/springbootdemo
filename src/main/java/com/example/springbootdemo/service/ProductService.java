package com.example.springbootdemo.service;

import com.example.springbootdemo.domain.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductService {
    Product select(@Param("id") int id);

    Product update(Product product);

    int delete(int id);

    Product insert(Product product);
}
