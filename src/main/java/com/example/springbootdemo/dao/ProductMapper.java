package com.example.springbootdemo.dao;


import com.example.springbootdemo.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductMapper {
    Product select(@Param("id") int id);

    int update(Product product);

    int delete(int id);

    int insert(Product product);
}
