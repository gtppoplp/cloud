package com.gxlirong.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * class CloudProductServiceApplication
 *
 * @author lirong
 */
@EnableHystrix //开启 Hystrix 熔断机制的支持
@MapperScan(value = "com.gxlirong.cloud.mapper")
@EnableEurekaClient
@SpringBootApplication
public class CloudProductServiceApplication_8002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProductServiceApplication_8002.class, args);
    }
}
