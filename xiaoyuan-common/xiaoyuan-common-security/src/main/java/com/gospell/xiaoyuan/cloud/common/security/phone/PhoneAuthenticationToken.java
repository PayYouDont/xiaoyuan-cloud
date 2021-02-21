package com.gospell.xiaoyuan.cloud.common.security.phone;

import lombok.SneakyThrows;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.util.Collection;

/**
 * description: 自定义登录令牌 <br>
 * date: 2021/1/4 15:19 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
public class PhoneAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final Object principal;

    public PhoneAuthenticationToken(String principal) {
        super (null);
        this.principal = principal;
        setAuthenticated (false);
    }

    public PhoneAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super (authorities);
        this.principal = principal;
        super.setAuthenticated (true);
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    @SneakyThrows
    public void setAuthenticated(boolean isAuthenticated) {
        if (isAuthenticated) {
            throw new IllegalArgumentException (
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }

        super.setAuthenticated (false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials ();
    }
}

