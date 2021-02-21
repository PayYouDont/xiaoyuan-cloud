package com.gospell.xiaoyuan.cloud.upms.admin.controller;

import com.gospell.xiaoyuan.cloud.common.core.constant.CommonConstants;
import com.gospell.xiaoyuan.cloud.common.core.util.R;
import com.gospell.xiaoyuan.cloud.common.security.util.SecurityUtils;
import com.gospell.xiaoyuan.cloud.upms.admin.service.SysMenuService;
import com.gospell.xiaoyuan.cloud.upms.common.dto.MenuTree;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysMenu;
import com.gospell.xiaoyuan.cloud.upms.common.util.TreeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * description: SysMenuController <br>
 * date: 2021/1/7 17:21 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping("/menu")
@Api(value = "menu", tags = "菜单管理模块")
public class SysMenuController {
    @Resource
    private SysMenuService menuService;

    @ApiOperation(value = "返回当前用户的树形菜单集合")
    @GetMapping
    public R getUserMenu() {
        // 获取符合条件的菜单
        Set<SysMenu> all = new HashSet<> ();
        SecurityUtils.getRoles ().forEach (roleId -> all.addAll (menuService.findMenuByRoleId (roleId)));
        List<MenuTree> menuTreeList = all.stream ()
                .filter (menu -> CommonConstants.MENU.equals (menu.getType ()))
                .map (MenuTree::new)
                .sorted (Comparator.comparingInt (MenuTree::getSort))
                .collect (Collectors.toList ());
        return R.ok (TreeUtil.build (menuTreeList, CommonConstants.PARENT_ID));
    }

    @ApiOperation(value = "返回所有树形菜单集合")
    @GetMapping("all/tree")
    public R getAllTree() {
        return R.ok (TreeUtil.buildTree (menuService.findAll (), CommonConstants.PARENT_ID));
    }

    @ApiOperation(value = "返回角色的菜单集合")
    @GetMapping("/tree/{roleId}")
    public R getRoleTree(@PathVariable Long roleId) {
        return R.ok (menuService.findMenuByRoleId (roleId)
                .stream ()
                .map (SysMenu::getId)
                .collect (Collectors.toList ()));
    }

    @ApiOperation(value = "返回树形菜单集合")
    @GetMapping(value = "/tree")
    public R getTree() {
        Set<SysMenu> all = new HashSet<> ();
        SecurityUtils.getRoles ().forEach (roleId -> all.addAll (menuService.findMenuByRoleId (roleId)));
        List<MenuTree> menuTreeList = all.stream ()
                .map (MenuTree::new)
                .collect (Collectors.toList ());
        return R.ok (TreeUtil.build (menuTreeList, CommonConstants.PARENT_ID));
    }

    @ApiOperation(value = "通过ID查询菜单的详细信息")
    @GetMapping("/{id}")
    @PreAuthorize("@ato.hasAuthority('sys:menu:get')")
    public R getById(@PathVariable Long id) {
        return R.ok (menuService.findById (id));
    }


    @ApiOperation(value = "新增菜单")
    @PutMapping
    @PreAuthorize("@ato.hasAuthority('sys:menu:add')")
    public R save(@Valid @RequestBody SysMenu sysMenu) {
        menuService.add (sysMenu);
        return R.ok ();
    }

    @ApiOperation(value = "编辑菜单")
    @PostMapping("edit")
    @PreAuthorize("@ato.hasAuthority('sys:menu:edit')")
    public R edit(@Valid @RequestBody SysMenu sysMenu) {
        menuService.update (sysMenu);
        return R.ok ();
    }

    @ApiOperation(value = "删除菜单")
    @DeleteMapping("/{id}")
    @PreAuthorize("@ato.hasAuthority('sys:menu:del')")
    public R delete(@PathVariable Long id) {
        menuService.deleteById (id);
        return R.ok ();
    }

    @ApiOperation(value = "获取某个角色的全部菜单信息")
    @PostMapping("/findByRoleId")
    public R findMenuByRoleId(Long roleId) {
        return R.ok (menuService.findMenuByRoleId (roleId));
    }

}
