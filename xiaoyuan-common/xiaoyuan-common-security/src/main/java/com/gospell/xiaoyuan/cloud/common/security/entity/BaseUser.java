package com.gospell.xiaoyuan.cloud.common.security.entity;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * description: BaseUser <br>
 * date: 2020/12/30 17:20 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Getter
public class BaseUser extends User {
    /**
     * 用户ID
     */
    private Long id;
    /**
     * 机构ID
     */
    private Long organId;

    public BaseUser(Long id, Long organId, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
        this.organId = organId;
    }
}
