package com.gxlirong.auth.authentication.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.gxlirong.auth.authentication.entity.User;

/**
 * class UserService
 *
 * @author lirong
 */
@Service
public interface UserService {

    @Cacheable(value = "#id")
    User getByUsername(String username);
}
