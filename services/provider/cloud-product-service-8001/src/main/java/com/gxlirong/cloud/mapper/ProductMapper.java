package com.gxlirong.cloud.mapper;

import com.gxlirong.cloud.entities.Product;

import java.util.List;

/**
 * @author : lirong
 */
public interface ProductMapper {
    Product findById(Long pid);

    List<Product> findAll();

    boolean addProduct(Product product);
}
