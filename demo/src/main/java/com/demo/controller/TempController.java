package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class TempController
 *
 * @author lirong
 */
@RestController
public class TempController {
    @GetMapping("/test")
    public String test() {
        return "欢迎登录";
    }
}
