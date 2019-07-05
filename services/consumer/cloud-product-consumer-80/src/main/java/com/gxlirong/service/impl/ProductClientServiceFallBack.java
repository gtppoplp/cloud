package com.gxlirong.service.impl;

import com.gxlirong.cloud.entities.Product;
import com.gxlirong.service.ProductClientService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * class ProductClientServiceFallBack
 *
 * @author lirong
 */
@Component
public class ProductClientServiceFallBack implements ProductClientService {
    @Override
    public Product get(Long id) {
        return new Product(id, "id="+ id + "无数据--feign&hystrix", "无有效数据库");
    }
    @Override
    public List<Product> list() {
        return null;
    }
    @Override
    public boolean add(Product product) {
        return false;
    }
}
