package com.baidu.service.impl;

import com.baidu.domain.Product;
import com.baidu.mapper.ProductMapper;
import com.baidu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    @Override
    public void save(Product product) throws Exception{
        productMapper.save(product);
    }
}
