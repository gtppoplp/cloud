package com.gxlirong.auth.authentication.service;

import com.gxlirong.cloud.entities.po.OaUser;

/**
 * class UserService
 *
 * @author lirong
 */
public interface OaUserService {

    OaUser getByUsername(String username);
}
