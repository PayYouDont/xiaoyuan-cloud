package com.gospell.xiaoyuan.cloud.upms.admin.controller;

import com.gospell.xiaoyuan.cloud.common.core.util.R;
import com.gospell.xiaoyuan.cloud.common.security.annotation.Inside;
import com.gospell.xiaoyuan.cloud.common.security.util.SecurityUtils;
import com.gospell.xiaoyuan.cloud.upms.admin.service.SysUserService;
import com.gospell.xiaoyuan.cloud.upms.common.dto.UserDTO;
import com.gospell.xiaoyuan.cloud.upms.common.dto.UserInfo;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * description: SysUserController <br>
 * date: 2021/1/4 15:19 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping("user")
@Api(value = "user", tags = "用户管理模块")
@Slf4j
public class SysUserController {
    @Resource
    private SysUserService userService;

    @ApiOperation(value = "获取当前用户全部信息")
    @GetMapping("info")
    public R info() {
        String username = SecurityUtils.getUser ().getUsername ();
        SysUser user = userService.findByUsername (username);
        if (user == null) {
            return R.failed (null, "获取当前用户信息失败");
        }
        return R.ok (userService.findUserInfo (user));
    }

    @ApiOperation(value = "获取指定用户全部信息")
    @Inside
    @GetMapping("/info/{username}")
    public R info(@PathVariable String username) {
        SysUser sysUser = userService.findByUsername (username);
        if (sysUser == null) {
            return R.failed (null, String.format ("用户信息为空 %s", username));
        }
        UserInfo userInfo = userService.findUserInfo (sysUser);
        return R.ok (userInfo);
    }

    @ApiOperation(value = "根据wxOpenId获取指定用户全部信息")
    @Inside
    @PostMapping("/info")
    public R getInfoByWxOpenId(@NonNull @RequestParam("wxOpenId") String wxOpenId) {
        SysUser sysUser = new SysUser ();
        sysUser.setWxOpenid (wxOpenId);
        List<SysUser> sysUserList = userService.queryAll (sysUser);
        if (sysUserList.size () == 0) {
            return R.failed (null, "微信用户不存在");
        }
        sysUser = sysUserList.get (0);
        UserInfo userInfo = userService.findUserInfo (sysUser);
        return R.ok (userInfo);
    }

    @ApiOperation(value = "通过ID查询用户信息")
    @GetMapping("/{id}")
    @PreAuthorize("@ato.hasAuthority('sys:user:get')")
    public R user(@PathVariable Long id) {
        SysUser sysUser = userService.findById (id);
        if (sysUser == null) {
            return R.failed (null, String.format ("用户信息为空 %s", id));
        }
        UserInfo userInfo = userService.findUserInfo (sysUser);
        return R.ok (userInfo);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("@ato.hasAuthority('sys:user:del')")
    @ApiOperation(value = "删除用户", notes = "根据ID删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int", paramType = "path")
    public R userDel(@PathVariable Long id) {
        try {
            userService.deleteById (id);
            return R.ok ();
        } catch (Exception e) {
            log.error (e.getMessage (), e);
            return R.failed (e.getMessage ());
        }
    }

    @ApiOperation(value = "更新用户信息")
    @PutMapping("update")
    @PreAuthorize("@ato.hasAuthority('sys:user:edit')")
    public R updateUser(@Valid @RequestBody UserDTO userDto) {
        try {
            userService.updateUser (userDto);
        } catch (Exception e) {
            log.error (e.getMessage (), e);
        }
        return R.ok ();
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    //@PreAuthorize("@ato.hasAuthority('sys:user:index')")
    public R getUserPage(Integer pageIndex, Integer pageSize, UserDTO userDTO) {
        return R.ok (userService.getUsersWithRolePage (pageIndex, pageSize, userDTO));
    }

    @ApiOperation(value = "根据用户名查询用户信息")
    @GetMapping("/detail/{username}")
    public R userByUsername(@PathVariable String username) {
        return R.ok (userService.findByUsername (username));
    }

    @ApiOperation(value = "数量查询")
    @GetMapping("/count")
    //@PreAuthorize("@ato.hasAuthority('sys:user:index')")
    public R getCount(SysUser sysUser) {
        return R.ok (userService.queryAll (sysUser).size ());
    }

    @ApiOperation(value = "添加用户")
    @PutMapping
    @PreAuthorize("@ato.hasAuthority('sys:user:add')")
    public R user(@RequestBody UserDTO userDto) {
        try {
            userService.saveUser (userDto);
            return R.ok ();
        } catch (DuplicateKeyException e) {
            if (Objects.requireNonNull (e.getMessage ()).contains ("uk_username")) {
                return R.failed ("用户名已被占用");
            } else if (e.getMessage ().contains ("uk_email")) {
                return R.failed ("邮箱已被占用");
            } else {
                return R.failed (e.getMessage ());
            }
        }
    }
}
