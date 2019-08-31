package com.lirongblog;

import com.lirongblog.config.annotation.EnableAuthJWTTokenStore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAuthJWTTokenStore    // 使用 JWT 存储令牌
public class AuthenticationServerApplication_9017 {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationServerApplication_9017.class, args);
    }
}
