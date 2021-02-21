package com.gospell.xiaoyuan.cloud.upms.admin.service;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseService;
import com.gospell.xiaoyuan.cloud.upms.common.dto.UserDTO;
import com.gospell.xiaoyuan.cloud.upms.common.dto.UserInfo;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysUser;
import com.gospell.xiaoyuan.cloud.upms.common.vo.UserVO;
import org.springframework.data.domain.Page;

/**
 * description: SysUserService <br>
 * date: 2020/12/31 15:54 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */

public interface SysUserService extends BaseService<SysUser> {
    SysUser findByUsername(String username);

    UserInfo findUserInfo(SysUser sysUser);

    Page<UserVO> getUsersWithRolePage(Integer pageIndex, Integer pageSize,UserDTO userDTO);

    void updateUser(UserDTO userDto) throws Exception;

    void saveUser(UserDTO userDto);
}
