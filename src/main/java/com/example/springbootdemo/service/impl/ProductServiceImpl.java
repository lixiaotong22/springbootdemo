package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.dao.ProductMapper;
import com.example.springbootdemo.domain.Product;
import com.example.springbootdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper mapper;

    @Override
    public Product select(int id) {
        return mapper.select(id);
    }

    @Override
    public int update(Product product) {
        return mapper.update(product);
    }

    @Override
    public int delete(int id) {
        return mapper.delete(id);
    }

    @Override
    public int insert(Product product) {
        return mapper.insert(product);
    }
}
