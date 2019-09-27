package com.gxlirong.services.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * class CloudProductConsumerApplication
 *
 * @author lirong
 */
@EnableFeignClients(basePackages = {"com.gxlirong.services.consumer.service"})
@EnableEurekaClient
@SpringBootApplication
public class CloudProductConsumerApplication_80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProductConsumerApplication_80.class, args);
    }
}
