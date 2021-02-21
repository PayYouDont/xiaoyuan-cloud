package com.gospell.xiaoyuan.cloud.common.security.service.impl;

import cn.hutool.core.util.ArrayUtil;
import com.gospell.xiaoyuan.cloud.common.core.constant.CacheConstants;
import com.gospell.xiaoyuan.cloud.common.core.constant.CommonConstants;
import com.gospell.xiaoyuan.cloud.common.core.constant.SecurityConstants;
import com.gospell.xiaoyuan.cloud.common.core.util.R;
import com.gospell.xiaoyuan.cloud.common.security.entity.BaseUser;
import com.gospell.xiaoyuan.cloud.common.security.service.AuthUserDetailsService;
import com.gospell.xiaoyuan.cloud.upms.common.dto.UserInfo;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysUser;
import com.gospell.xiaoyuan.cloud.upms.common.feign.FeignUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * description: AuthUserDetailsServiceImpl <br>
 * date: 2020/12/29 14:26 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Slf4j
@Service
@AllArgsConstructor
public class AuthUserDetailsServiceImpl implements AuthUserDetailsService {
    private final FeignUserService feignUserService;
    private final CacheManager cacheManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询缓存中是否有此用户信息，有则直接返回
        Cache cache = cacheManager.getCache (CacheConstants.USER_CACHE);
        if (cache != null && cache.get (username) != null) {
            return (BaseUser) Objects.requireNonNull (cache.get (username)).get ();
        }
        //缓存中无此用户信息，feign查询
        R<UserInfo> result = feignUserService.info (username, SecurityConstants.FROM_IN);
        UserDetails userDetails = getUserDetails (result);
        if (userDetails.isAccountNonLocked ()) {
            //合法用户，放入缓存
            assert cache != null;
            cache.put (username, userDetails);
        }
        return userDetails;
    }

    @Override
    public UserDetails loadUserByWxOpenId(String wxOpenId) throws UsernameNotFoundException {
        return getUserDetails (feignUserService.loadUserByWxOpenId (wxOpenId, SecurityConstants.FROM_IN));
    }

    private UserDetails getUserDetails(R<UserInfo> result) {
        if (result == null || result.getData () == null) {
            throw new UsernameNotFoundException ("用户不存在");
        }
        UserInfo info = result.getData ();
        Set<String> dbAuthsSet = new HashSet<> ();
        if (ArrayUtil.isNotEmpty (info.getRoles ())) {
            // 获取角色
            Arrays.stream (info.getRoles ()).forEach (roleId -> dbAuthsSet.add (SecurityConstants.ROLE + roleId));
            // 获取资源
            dbAuthsSet.addAll (Arrays.asList (info.getPermissions ()));
        }
        Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList (dbAuthsSet.toArray (new String[0]));
        SysUser user = info.getSysUser ();
        boolean enabled = CommonConstants.STATUS_NORMAL.equals (user.getLockFlag ());
        // 构造security用户
        return new BaseUser (user.getId (), user.getOrganId (), user.getUsername (), SecurityConstants.BCRYPT + user.getPassword (), enabled,
                true, true, enabled, authorities);
    }
}
