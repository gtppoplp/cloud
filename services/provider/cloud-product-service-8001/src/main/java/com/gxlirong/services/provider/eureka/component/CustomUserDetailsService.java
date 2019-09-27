package com.gxlirong.services.provider.eureka.component;

import com.gxlirong.services.provider.cloud.po.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //模拟两个用户
        if ("user".equals(username)) {
            return new SecurityUser("user", "123456", "user-role");
        } else if ("admin".equals(username)) {
            return new SecurityUser("admin", "123456", "admin-role");
        } else {
            return null;
        }
    }
}
