package com.gxlirong.auth.authentication;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * class Oauth2AuthorizationApplication_8091
 *
 * @author lirong
 */
@EnableHystrix //开启 Hystrix 熔断机制的支持
@EnableEurekaClient
@SpringBootApplication
@MapperScan(value = "com.gxlirong.auth.authentication.mapper")
public class Oauth2AuthorizationApplication_8091 {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2AuthorizationApplication_8091.class, args);
    }
}
