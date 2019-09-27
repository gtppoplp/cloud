package com.gxlirong.center.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * class CloudConfig_5001
 *
 * @author lirong
 */
@EnableConfigServer //开启配置中心功能
@SpringBootApplication
public class CloudConfig_5001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfig_5001.class, args);
    }
}
