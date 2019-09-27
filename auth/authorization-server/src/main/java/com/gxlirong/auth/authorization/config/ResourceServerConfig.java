package com.gxlirong.auth.authorization.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;

/**
 * 资源安全服务配置
 *
 * @author lirong
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    /**
     * 使用此配置访问规则的安全资源。 默认情况下，所有资源 <i>不</i> 在 "/oauth/**"
     * 保护（但没有关于作用域特定的规则给出，例如）。 您还可以得到一个{@link OAuth2WebSecurityExpressionHandler} 默认。
     *
     * @param http 当前的HTTP过滤器配置
     * @throws Exception 异常
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated();
    }
}