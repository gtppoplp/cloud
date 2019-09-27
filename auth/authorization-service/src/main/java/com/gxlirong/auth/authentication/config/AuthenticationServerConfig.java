package com.gxlirong.auth.authentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;

/**
 * 授权服务配置。
 *
 * @author lirong
 */
@Configuration
@EnableAuthorizationServer
public class AuthenticationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("userDetailsService")
    UserDetailsService userDetailsService;

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Autowired
    private TokenStore tokenStore;

    @Autowired(required = false)
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    /**
     * 配置授权服务器，这意味着在实际中的/的OAuth /令牌端点的安全性。
     * 在/的OAuth /授权端点也需要是安全的，但是这是一个正常的面向用户的终端和应该固定方式与UI的其余部分相同，
     * 所以这里不讨论。
     * 默认设置涵盖了最常见的要求，并从规范的OAuth2建议，所以你不需要在这里做任何事情来得到一个基本的服务器启动和运行。
     *
     * @param security a fluent configurer for security features 授权服务器安全配置
     * @author lirong
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("permitAll()");
    }

    /**
     * 配置{@link ClientDetailsService}，例如 申报个人客户和他们的财产。
     * 请注意，密码批未启用（即使有些客户被允许的话），除非{@link AuthenticationManager}提供给{@link #configure(AuthorizationServerEndpointsConfigurer)}。
     * 至少有一个客户端，或完全形成自{@link ClientDetailsService}必须声明或服务器将无法启动。
     *
     * @param clients the client details configurer 客户详细信息服务配置
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //配置客户端信息，从数据库中读取，对应oauth_client_details表
        clients.jdbc(dataSource);
    }

    /**
     * 配置认证服务器端点的非安全功能，如令牌存储装置，令牌定制，用户认证，并授予类型。
     * 你不应该需要在默认情况下做任何事情，除非你需要密码授权，在这种情况下，
     * 您需要提供{@link AuthenticationManager}.
     *
     * @param endpoints the endpoints configurer 授权服务器端点配置
     * @author lirong
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        //配置token的数据源、自定义的tokenServices等信息,配置身份认证器，配置认证方式，TokenStore，TokenGranter，OAuth2RequestFactory
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);

        if (jwtAccessTokenConverter != null) {
            endpoints.accessTokenConverter(jwtAccessTokenConverter);
        }
    }
}
