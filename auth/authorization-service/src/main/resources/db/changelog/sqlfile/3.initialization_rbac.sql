DROP TABLE IF EXISTS oa_user;
CREATE TABLE oa_user
(
    id                      SERIAL PRIMARY KEY COMMENT '用户id',
    job_number              VARCHAR(128) NOT NULL DEFAULT '' COMMENT '工号',
    username                VARCHAR(128) NOT NULL DEFAULT '' COMMENT '用户名',
    password                VARCHAR(128) NOT NULL DEFAULT '' COMMENT '用户密码密文',
    name                    VARCHAR(256) NOT NULL DEFAULT '' COMMENT '用户姓名',
    mobile                  VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '用户手机',
    enabled                 BOOLEAN      NOT NULL DEFAULT FALSE COMMENT '是否有效用户',
    account_non_expired     BOOLEAN      NOT NULL DEFAULT FALSE COMMENT '账号是否未过期',
    credentials_non_expired BOOLEAN      NOT NULL DEFAULT FALSE COMMENT '密码是否未过期',
    account_non_locked      BOOLEAN      NOT NULL DEFAULT FALSE COMMENT '是否未锁定',
    created_id              INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建人id',
    created_time            INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建时间',
    created_by              VARCHAR(128) NOT NULL DEFAULT '' COMMENT '创建人',
    updated_id              INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '修改人id',
    updated_time            INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新时间',
    updated_by              VARCHAR(128) NOT NULL DEFAULT '' COMMENT '更新人'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '用户表';

DROP TABLE IF EXISTS oa_groups;
CREATE TABLE oa_groups
(
    id           SERIAL PRIMARY KEY COMMENT '用户组id',
    parent_id    INT          NOT NULL COMMENT '用户组父id',
    name         VARCHAR(256) NOT NULL DEFAULT '' COMMENT '用户组名称',
    description  VARCHAR(512) NOT NULL DEFAULT '' COMMENT '用户组简介',
    created_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建人id',
    created_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建时间',
    created_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '创建人',
    updated_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新人id',
    updated_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新时间',
    updated_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '更新人'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '用户组表';

DROP TABLE IF EXISTS oa_user_groups_relation;
CREATE TABLE oa_user_groups_relation
(
    id           SERIAL PRIMARY KEY COMMENT '关系id',
    user_id      INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '用户id',
    group_id     INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '用户组id',
    created_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建人id',
    created_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建时间',
    created_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '创建人',
    updated_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新人id',
    updated_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新时间',
    updated_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '更新人'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '用户和组关系表';

DROP TABLE IF EXISTS oa_positions;
CREATE TABLE oa_positions
(
    id           SERIAL PRIMARY KEY COMMENT '岗位id',
    name         VARCHAR(256) COMMENT '岗位名称',
    description  VARCHAR(512) COMMENT '岗位简介',
    created_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建人id',
    created_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建时间',
    created_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '创建人',
    updated_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新人id',
    updated_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新时间',
    updated_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '更新人'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '岗位表';

DROP TABLE IF EXISTS oa_user_positions_relation;
CREATE TABLE oa_user_positions_relation
(
    id           SERIAL PRIMARY KEY COMMENT '关系id',
    user_id      INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '用户id',
    position_id  INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '岗位id',
    created_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建人id',
    created_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建时间',
    created_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '创建人',
    updated_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新人id',
    updated_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新时间',
    updated_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '更新人'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '用户和岗位关系表';

DROP TABLE IF EXISTS oa_roles;
CREATE TABLE oa_roles
(
    id           SERIAL PRIMARY KEY COMMENT '角色id',
    code         VARCHAR(128) NOT NULL COMMENT '角色编码',
    name         VARCHAR(256) NOT NULL DEFAULT '' COMMENT '角色名称',
    description  VARCHAR(500) NOT NULL DEFAULT '' COMMENT '角色简介',
    created_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建人id',
    created_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建时间',
    created_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '创建人',
    updated_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新人id',
    updated_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新时间',
    updated_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '更新人'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '角色表';

DROP TABLE IF EXISTS oa_user_roles_relation;
CREATE TABLE oa_user_roles_relation
(
    id           SERIAL PRIMARY KEY COMMENT '关系id',
    user_id      INT          NOT NULL COMMENT '用户id',
    role_id      INT          NOT NULL COMMENT '角色id',
    created_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建人id',
    created_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建时间',
    created_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '创建人',
    updated_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新人id',
    updated_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新时间',
    updated_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '更新人'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '用户和角色关系表';

DROP TABLE IF EXISTS oa_menus;
CREATE TABLE oa_menus
(
    id           SERIAL PRIMARY KEY COMMENT '菜单id',
    parent_id    INT          NOT NULL COMMENT '父菜单id',
    type         VARCHAR(128) NOT NULL DEFAULT '' COMMENT '菜单名称',
    href         VARCHAR(256) NOT NULL DEFAULT '' COMMENT '菜单类型',
    icon         VARCHAR(256) NOT NULL DEFAULT '' COMMENT '菜单路径',
    name         VARCHAR(256) NOT NULL DEFAULT '' COMMENT '菜单图标',
    description  VARCHAR(512) NOT NULL DEFAULT '' COMMENT '菜单简介',
    order_num    INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '菜单号',
    created_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建人id',
    created_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建时间',
    created_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '创建人',
    updated_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新人id',
    updated_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新时间',
    updated_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '更新人'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '菜单表';

DROP TABLE IF EXISTS oa_roles_menus_relation;
CREATE TABLE oa_roles_menus_relation
(
    id           SERIAL PRIMARY KEY COMMENT '菜单关系id',
    menu_id      INT          NOT NULL COMMENT '角色id',
    role_id      INT          NOT NULL COMMENT '菜单id',
    created_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建人id',
    created_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建时间',
    created_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '创建人',
    updated_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新人id',
    updated_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新时间',
    updated_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '更新人'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '角色和菜单关系表';

DROP TABLE IF EXISTS oa_acl;
CREATE TABLE oa_acl
(
    id           SERIAL PRIMARY KEY COMMENT '权限id',
    code         VARCHAR(128) NOT NULL DEFAULT '' COMMENT '码',
    type         VARCHAR(128) NOT NULL DEFAULT '' COMMENT '类型',
    name         VARCHAR(256) NOT NULL DEFAULT '' COMMENT '资源名称',
    url          VARCHAR(256) NOT NULL DEFAULT '' COMMENT 'url',
    method       VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '方法',
    description  VARCHAR(512) NOT NULL DEFAULT '' COMMENT '资源简介',
    created_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建人id',
    created_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建时间',
    created_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '创建人',
    updated_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新人id',
    updated_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新时间',
    updated_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '更新人'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '访问控制列表';

DROP TABLE IF EXISTS oa_roles_acl_relation;
CREATE TABLE oa_roles_acl_relation
(
    id           SERIAL PRIMARY KEY COMMENT '关系id',
    resource_id  INT          NOT NULL COMMENT '角色id',
    role_id      INT          NOT NULL COMMENT '资源id',
    created_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建人id',
    created_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '创建时间',
    created_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '创建人',
    updated_id   INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新人id',
    updated_time INTEGER(11)  NOT NULL DEFAULT 0 COMMENT '更新时间',
    updated_by   VARCHAR(128) NOT NULL DEFAULT '' COMMENT '更新人'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '角色和权限关系表';