package com.gxlirong.auth.authorization.config.custom;

import com.google.common.collect.Maps;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.Map;

/**
 * class CustomTokenEnhancer
 *
 * 策略之前，通过提高存储访问令牌  {@link AuthorizationServerTokenServices}
 *
 * @author lirong
 *
 */
public class CustomTokenEnhancer implements TokenEnhancer {

    /**
     * 提供了一种用于访问令牌的定制（例如，通过它的附加信息映射）由客户端创建用于新的令牌的过程中的机会。
     *
     * @param accessToken 其到期和刷新令牌当前访问令牌
     * @param authentication 当前的认证包括客户端和用户的详细信息
     * @return 一个新的令牌加强与其他信息
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = Maps.newHashMap();
        // 自定义token内容，加入组织机构信息或其他信息
        additionalInfo.put("organization", "none");
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
