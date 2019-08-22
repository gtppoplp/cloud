package com.gxlirong.cloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * class SecurityConfig
 *
 * @author lirong
 */
@Configuration
public class SecurityConfig {
    @Value("${config.security.username}")
    private String username;
    @Value("${config.security.password}")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
