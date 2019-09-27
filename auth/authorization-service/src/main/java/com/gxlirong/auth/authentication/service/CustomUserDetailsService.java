package com.gxlirong.auth.authentication.service;

import com.gxlirong.cloud.entities.po.OaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * class CustomUserDetailsService
 *
 * @author lirong
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private OaUserService usersService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        OaUser user = usersService.getByUsername(username);
        return new User(
                user.getUsername(),
                user.getPassword(),
                user.getEnabled(),
                user.getAccountNonExpired(),
                user.getCredentialsNonExpired(),
                user.getAccountNonLocked(),
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }
}
