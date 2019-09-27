package com.gxlirong.auth.authorization.service;


import com.gxlirong.common.api.entities.po.OaUser;

/**
 * class UserService
 *
 * @author lirong
 */
public interface OaUserService {

    OaUser getByUsername(String username);
}
