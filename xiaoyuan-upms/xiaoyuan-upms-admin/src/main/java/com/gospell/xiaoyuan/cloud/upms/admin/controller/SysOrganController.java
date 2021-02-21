package com.gospell.xiaoyuan.cloud.upms.admin.controller;

import com.gospell.xiaoyuan.cloud.common.core.constant.CommonConstants;
import com.gospell.xiaoyuan.cloud.common.core.util.R;
import com.gospell.xiaoyuan.cloud.upms.admin.service.SysOrganService;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysOrgan;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Objects;

/**
 * description: SysOrganController <br>
 * date: 2021/1/15 16:13 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping("/organ")
@Api(value = "organ", tags = "机构管理模块")
public class SysOrganController {
    @Resource
    private SysOrganService organService;

    @ApiOperation(value = "通过ID查询")
    @GetMapping("/{id}")
    @PreAuthorize("@ato.hasAuthority('sys:organ:get')")
    public R getById(@PathVariable Long id) {
        return R.ok (organService.findById (id));
    }

    @ApiOperation(value = "list查询")
    @GetMapping("/list")
    public R getList(SysOrgan sysOrgan) {
        return R.ok (organService.queryAll (sysOrgan));
    }

    @ApiOperation(value = "返回树形菜单集合")
    @GetMapping(value = "/tree")
    public R getTree() {
        return R.ok (organService.selectTree ());
    }

    @ApiOperation(value = "添加")
    @PutMapping
    @PreAuthorize("@ato.hasAuthority('sys:organ:add')")
    public R save(@Valid @RequestBody SysOrgan sysOrgan) {
        try {
            if (CommonConstants.PARENT_ID.equals (sysOrgan.getParentId ())) {
                throw new Exception ("父级节点不能为0");
            }
            organService.add (sysOrgan);
            return R.ok ();
        } catch (DuplicateKeyException e) {
            if (Objects.requireNonNull (e.getMessage ()).contains ("uk_tenant_id_code")) {
                return R.failed ("机构编码已存在");
            } else {
                return R.failed (e.getMessage ());
            }
        } catch (Exception e) {
            e.printStackTrace ();
            return R.failed (e.getMessage ());
        }
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    @PreAuthorize("@ato.hasAuthority('sys:organ:del')")
    public R removeById(@PathVariable Long id) {
        SysOrgan organ = organService.findById (id);
        if (CommonConstants.PARENT_ID.equals (organ.getParentId ())) {
            return R.failed ("总机构（租户机构）不能删除");
        }
        organService.deleteById (id);
        return R.ok ();
    }

    @ApiOperation(value = "编辑")
    @PutMapping("update")
    @PreAuthorize("@ato.hasAuthority('sys:organ:edit')")
    public R update(@Valid @RequestBody SysOrgan sysOrgan) {
        try {
            SysOrgan organ = organService.findById (sysOrgan.getId ());
            if (CommonConstants.PARENT_ID.equals (organ.getParentId ())) {
                sysOrgan.setParentId (CommonConstants.PARENT_ID);
            }
            organService.update (sysOrgan);
            return R.ok ();
        } catch (DuplicateKeyException e) {
            if (Objects.requireNonNull (e.getMessage ()).contains ("uk_tenant_id_code")) {
                return R.failed ("机构编码已存在");
            } else {
                return R.failed (e.getMessage ());
            }
        } catch (Exception e) {
            e.printStackTrace ();
            return R.failed (e.getMessage ());
        }
    }
}
