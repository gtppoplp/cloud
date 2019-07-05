package com.gxlirong.cloud.service.impl;

import com.gxlirong.cloud.entities.Product;
import com.gxlirong.cloud.mapper.ProductMapper;
import com.gxlirong.cloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * class ProductServiceImpl
 *
 * @author lirong
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public boolean add(Product product) {
        return productMapper.addProduct(product);
    }

    @Override
    public Product get(Long id) {
        return productMapper.findById(id);
    }

    @Override
    public List<Product> list() {
        return productMapper.findAll();
    }
}
