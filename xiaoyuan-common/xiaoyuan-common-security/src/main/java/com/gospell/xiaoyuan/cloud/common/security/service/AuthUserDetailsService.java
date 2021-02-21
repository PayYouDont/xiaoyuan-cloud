package com.gospell.xiaoyuan.cloud.common.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * description: AuthUserDetailsService <br>
 * date: 2020/12/29 14:24 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
public interface AuthUserDetailsService extends UserDetailsService {

    UserDetails loadUserByWxOpenId(String wxOpenId) throws UsernameNotFoundException;

}
