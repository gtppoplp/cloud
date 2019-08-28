package com.gxlirong.cloud.controller;

import com.gxlirong.cloud.entities.Product;
import com.gxlirong.cloud.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * class ProductController
 *
 * @author lirong
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Product product) {
        return productService.add(product);
    }

    //当get方法出现异常时，则会调用hystrixGet方法处理
    @HystrixCommand(fallbackMethod = "getFallback")
    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id) {
        //登录信息
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            UserDetails user = (UserDetails) principal;
//            Collection<? extends GrantedAuthority> collection = user.getAuthorities();
//            for (GrantedAuthority c : collection) {
//                //打印当前登录用户的信息
//                ProductController.LOGGER.info("当前用户是{},角色是{}", user.getUsername(), c.getAuthority());
//            }
//        }
        Product product = productService.get(id);
        if (product == null) {
            throw new RuntimeException("ID=" + id + "无效");
        }
        return product;
    }

    //当get方法出现异常时，则会调用此方法. 注意此方法的返回值，参数列表与原方法一致
    public Product getFallback(@PathVariable("id") Long id) {
        return new Product(id,
                "ID=" + id + "无效--@HystrixCommand",
                "无有效数据库");
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public List<Product> list() {
        return productService.list();
    }
}
