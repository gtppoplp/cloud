package com.gxlirong.services.provider.cloud.mapper;

import com.gxlirong.common.api.entities.Product;

import java.util.List;

/**
 * @author : lirong
 */
public interface ProductMapper {
    Product findById(Long pid);

    List<Product> findAll();

    boolean addProduct(Product product);
}
