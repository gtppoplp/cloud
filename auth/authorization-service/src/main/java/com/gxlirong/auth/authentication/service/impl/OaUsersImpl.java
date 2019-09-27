package com.gxlirong.auth.authentication.service.impl;

import com.gxlirong.auth.authentication.mapper.OaUserMapper;
import com.gxlirong.auth.authentication.service.OaUserService;
import com.gxlirong.cloud.entities.po.OaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * class UsersImpl
 *
 * @author lirong
 */
@Service
public class OaUsersImpl implements OaUserService {
    @Autowired
    private OaUserMapper usersMapper;

    @Override
    public OaUser getByUsername(String username) {
        return usersMapper.getByUsername(username);
    }
}
