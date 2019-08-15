package com.baidu.service;

import com.baidu.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product product) throws Exception;
}
