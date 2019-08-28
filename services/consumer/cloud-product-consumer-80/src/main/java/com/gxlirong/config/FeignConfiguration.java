package com.gxlirong.config;

import feign.Contract;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    /**
     * 将契约改为feign原生的默认契约,可以使用feign自带的注解
     *
     * @see FeignClientsConfiguration for the defaults
     * @return Contract
     */
//    @Bean
//    public Contract feignContract() {
//        return new feign.Contract.Default();
//    }
}
