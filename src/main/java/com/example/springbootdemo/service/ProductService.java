package com.example.springbootdemo.service;

import com.example.springbootdemo.domain.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductService {
    Product select(@Param("id") int id);

    int update(Product product);

    int delete(int id);

    int insert(Product product);
}
