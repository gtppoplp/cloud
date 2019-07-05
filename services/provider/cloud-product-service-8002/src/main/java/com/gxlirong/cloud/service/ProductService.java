package com.gxlirong.cloud.service;

import com.gxlirong.cloud.entities.Product;

import java.util.List;

/**
 * class ProductService
 *
 * @author lirong
 */
public interface ProductService {
    boolean add(Product product);

    Product get(Long id);

    List<Product> list();
}
