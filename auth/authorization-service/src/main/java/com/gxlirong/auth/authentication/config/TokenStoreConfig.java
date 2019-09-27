package com.gxlirong.auth.authentication.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;


/**
 * Token令牌储存配置
 *
 * @author lirong
 */
@Configuration
@Slf4j
public class TokenStoreConfig {
    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    /**
     * token的持久化(redis)
     *
     * @return JwtTokenStore
     * @author lirong
     */
    @Bean
    @ConditionalOnProperty(prefix = "auth.security.oauth2", name = "tokenStore", havingValue = "redis", matchIfMissing = true)
    public TokenStore redisTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Configuration
    @ConditionalOnProperty(prefix = "auth.security.oauth2", name = "storeType", havingValue = "jwt", matchIfMissing = true)
    public static class JWTTokenConfig {

        /**
         * jwt 对称加密密钥
         */
        @Value("${security.oauth2.jwt.signingKey}")
        private String signingKey;

        @Bean
        @ConditionalOnProperty(prefix = "auth.security.oauth2", name = "tokenStore", havingValue = "jwt")
        public TokenStore jwtTokenStore() {
            return new JwtTokenStore(jwtAccessTokenConverter());
        }

        /**
         * jwt token的生成配置
         *
         * @return JwtAccessTokenConverter
         * @author lirong
         */
        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter() {
            JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
            //设置签名密钥
            converter.setSigningKey(signingKey);
            return converter;
        }
    }
}
