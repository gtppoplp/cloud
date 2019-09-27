package com.gxlirong.center.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * class EurekaApplication
 *
 * @author lirong
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication_6001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication_6001.class, args);
    }
}
