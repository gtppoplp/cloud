package com.gxlirong.auth.authentication.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class OaUserController
 *
 * @author lirong
 */
@RestController
@Slf4j
public class OaUserController {
    @GetMapping(value = "/auth/getCurrentUser")
    public UserDetails getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        log.info("{}",userDetails);
        return userDetails;
    }
}
