DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`
(
    client_id               CHARACTER VARYING(256) NOT NULL COMMENT '客户端ID',
    resource_ids            CHARACTER VARYING(256) COMMENT '资源ID集合,多个资源时用逗号(,)分隔',
    client_secret           CHARACTER VARYING(256) COMMENT '客户端密匙',
    scope                   CHARACTER VARYING(256) COMMENT '客户端申请的权限范围',
    authorized_grant_types  CHARACTER VARYING(256) COMMENT '客户端支持的grant_type',
    web_server_redirect_uri CHARACTER VARYING(256) COMMENT '重定向URI',
    authorities             CHARACTER VARYING(256) COMMENT '客户端所拥有的Spring Security的权限值，多个用逗号(,)分隔',
    access_token_validity   INTEGER COMMENT '访问令牌有效时间值(单位:秒)',
    refresh_token_validity  INTEGER COMMENT '更新令牌有效时间值(单位:秒)',
    additional_information  CHARACTER VARYING(4096) COMMENT '预留字段',
    autoapprove             CHARACTER VARYING(256) COMMENT '用户是否自动Approval操作',
    CONSTRAINT pk_oauth_client_details_client_id PRIMARY KEY (client_id)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'OAuth客户端表';

DROP TABLE IF EXISTS oauth_refresh_token;
CREATE TABLE oauth_refresh_token
(
    token_id       CHARACTER VARYING(256) COMMENT 'MD5加密过的refresh_token的值',
    token          BLOB COMMENT 'OAuth2RefreshToken.java对象序列化后的二进制数据',
    authentication BLOB COMMENT 'OAuth2Authentication.java对象序列化后的二进制数据'
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '更新令牌表';
