package com.gxlirong.auth.authentication.mapper;

import com.gxlirong.cloud.entities.po.OaUser;

/**
 * class OaUserMapper
 *
 * @author lirong
 */
public interface OaUserMapper {
    OaUser getByUsername(String username);
}
