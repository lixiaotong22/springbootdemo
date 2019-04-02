package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.dao.ProductMapper;
import com.example.springbootdemo.domain.Product;
import com.example.springbootdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@CacheConfig(cacheNames = "products")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper mapper;

    @Cacheable(key = "''+#id", unless = "#result == null")
    @Override
    public Product select(int id) {
        return mapper.select(id);
    }

    @CachePut(key = "''+#product.id", unless = "#result == null")
    @Override
    public Product update(Product product) {
        if (mapper.update(product) == 1)
            return product;
        else
            return null;
    }

    @CacheEvict(key = "''+#id", condition = "#result == 1")
    @Override
    public int delete(int id) {
        return mapper.delete(id);
    }

    @CachePut(key = "''+#product.id", unless = "#result == null")
    @Override
    public Product insert(Product product) {
        if (mapper.insert(product) == 1)
            return product;
        else
            return null;
    }
}
