package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class IndexController
 *
 * @author lirong
 */
@RestController
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "首页";
    }
}
