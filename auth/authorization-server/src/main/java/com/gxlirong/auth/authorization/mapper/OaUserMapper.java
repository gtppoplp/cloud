package com.gxlirong.auth.authorization.mapper;


import com.gxlirong.common.api.entities.po.OaUser;

/**
 * class OaUserMapper
 *
 * @author lirong
 */
public interface OaUserMapper {
    OaUser getByUsername(String username);
}
