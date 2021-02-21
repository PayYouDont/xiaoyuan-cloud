package com.gospell.xiaoyuan.cloud.upms.common.dto;

import com.gospell.xiaoyuan.cloud.upms.common.entity.SysMenu;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * description: MenuTree <br>
 * date: 2021/1/8 10:24 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class MenuTree extends TreeNode{
    private String icon;
    private String name;
    private boolean spread = false;
    private String path;
    private String component;
    private String authority;
    private String redirect;
    private String keepAlive;
    private String code;
    private String type;
    private String label;
    private Integer sort;
    private String permission;
    private Date createTime;
    private Date updateTime;

    public MenuTree(SysMenu menu) {
        this.id = menu.getId();
        this.parentId = menu.getParentId();
        this.icon = menu.getIcon();
        this.name = menu.getName();
        this.path = menu.getPath();
        this.component = menu.getComponent();
        this.type = menu.getType();
        this.label = menu.getName();
        this.sort = menu.getSort();
        this.keepAlive = menu.getKeepAlive();
        this.permission = menu.getPermission();
        this.createTime = menu.getCreateTime();
        this.updateTime = menu.getUpdateTime();
    }
}
