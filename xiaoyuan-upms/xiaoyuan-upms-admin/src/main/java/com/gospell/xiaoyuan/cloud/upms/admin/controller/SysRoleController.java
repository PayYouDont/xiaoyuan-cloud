package com.gospell.xiaoyuan.cloud.upms.admin.controller;

import cn.hutool.core.util.StrUtil;
import com.gospell.xiaoyuan.cloud.common.core.constant.CommonConstants;
import com.gospell.xiaoyuan.cloud.common.core.util.R;
import com.gospell.xiaoyuan.cloud.upms.admin.service.SysRoleService;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysRole;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysRoleMenu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * description: SysRoleController <br>
 * date: 2021/1/8 08:58 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping("/role")
@Api(value = "role", tags = "角色管理模块")
public class SysRoleController {
    @Resource
    private SysRoleService roleService;

    @ApiOperation(value = "通过ID查询角色信息")
    @GetMapping("/{id}")
    @PreAuthorize("@ato.hasAuthority('sys:role:get')")
    public R getById(@PathVariable Long id) {
        return R.ok (roleService.findById (id));
    }

    @ApiOperation(value = "添加角色")
    @PutMapping
    @PreAuthorize("@ato.hasAuthority('sys:role:add')")
    public R save(@Valid @RequestBody SysRole sysRole) {
        roleService.add (sysRole);
        return R.ok ();
    }

    @ApiOperation(value = "修改角色")
    @PutMapping("update")
    @PreAuthorize("@ato.hasAuthority('sys:role:edit')")
    public R update(@Valid @RequestBody SysRole sysRole) {
        if (this.isAdmin (sysRole.getId ())) {
            return R.failed ("管理员角色不能操作");
        }
        roleService.update (sysRole);
        return R.ok ();
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/{id}")
    @PreAuthorize("@ato.hasAuthority('sys:role:del')")
    public R removeById(@PathVariable Long id) {
        if (isAdmin (id)) {
            return R.failed ("管理员角色不能操作");
        }
        roleService.deleteById (id);
        return R.ok ();
    }

    @ApiOperation(value = "获取角色列表")
    @GetMapping("/list")
    public R list() {
        return R.ok (roleService.findAll ());
    }

    boolean isAdmin(Long roleId) {
        SysRole sysRole = roleService.findById (roleId);
        if (CommonConstants.ROLE_CODE_ADMIN.equals (sysRole.getRoleCode ())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @ApiOperation(value = "分页查询角色信息")
    @GetMapping("/page")
    //@PreAuthorize("@ato.hasAuthority('sys:role:index')")
    public R getRolePage(Integer pageIndex, Integer pageSize) {
        return R.ok (roleService.page (pageIndex, pageSize));
    }

    @ApiOperation(value = "更新角色菜单")
    @PutMapping("/menu")
    @PreAuthorize("@ato.hasAuthority('sys:role:perm','sys:tenant:edit')")
    public R saveRoleMenus(SysRoleMenu sysRoleMenu,String menuIds) {
        Long roleId = sysRoleMenu.getRoleId ();
        if (roleId == null || StrUtil.isBlank(menuIds)) {
            return R.ok ();
        }
        if (roleService.getAdmin ().getId ().equals (roleId)) {
            return R.failed ("管理员角色不能操作");
        }
        SysRole sysRole = roleService.findById (roleId);
        roleService.saveRoleMenus (sysRole.getRoleCode (), roleId, menuIds);
        return R.ok ();
    }
}
