package com.gxlirong.services.provider.cloud.service;

import com.gxlirong.common.api.entities.Product;

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
