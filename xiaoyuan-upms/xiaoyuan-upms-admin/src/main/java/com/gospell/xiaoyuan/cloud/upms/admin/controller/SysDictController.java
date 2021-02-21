package com.gospell.xiaoyuan.cloud.upms.admin.controller;

import com.gospell.xiaoyuan.cloud.common.core.constant.CacheConstants;
import com.gospell.xiaoyuan.cloud.common.core.util.R;
import com.gospell.xiaoyuan.cloud.upms.admin.service.SysDictService;
import com.gospell.xiaoyuan.cloud.upms.admin.service.SysDictValueService;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysDict;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysDictValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * description: SysDictController <br>
 * date: 2021/1/18 10:32 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping("/dict")
@Api(value = "dict", tags = "字典管理模块")
public class SysDictController {
    @Resource
    private SysDictService dictService;
    @Resource
    private SysDictValueService dictValueService;

    @ApiOperation(value = "通过ID查询字典信息")
    @GetMapping("/{id}")
    @PreAuthorize("@ato.hasAuthority('sys:dict:get')")
    public R getById(@PathVariable Long id) {
        return R.ok (dictService.findById (id));
    }

    @ApiOperation(value = "通过字典类型查找")
    @GetMapping("/type/{type}")
    @Cacheable(value = CacheConstants.DICT_CACHE, key = "#type", unless = "#result == null")
    public R getDictByType(@PathVariable String type) {
        return R.ok (dictValueService.findByType (type));
    }

    @ApiOperation(value = "添加字典")
    @PutMapping
    @PreAuthorize("@ato.hasAuthority('sys:dict:add')")
    public R save(@Valid @RequestBody SysDict sysDict) {
        dictService.add (sysDict);
        return R.ok ();
    }

    @ApiOperation(value = "删除字典，并且清除字典缓存")
    @DeleteMapping("/{id}")
    @PreAuthorize("@ato.hasAuthority('sys:dict:del')")
    public R removeById(@PathVariable Long id) {
        dictService.deleteById (id);
        return R.ok ();
    }

    @ApiOperation(value = "修改字典")
    @PutMapping("update")
    @PreAuthorize("@ato.hasAuthority('sys:dict:edit')")
    public R updateById(@Valid @RequestBody SysDict sysDict) {
        dictService.update (sysDict);
        return R.ok ();
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public R getRolePage(Integer pageIndex, Integer pageSize) {
        return R.ok (dictService.page (pageIndex, pageSize));
    }


    @ApiOperation(value = "分页查询")
    @GetMapping("/item/page")
    public R getSysDictItemPage(Integer pageIndex, Integer pageSize, SysDictValue sysDictValue) {
        return R.ok (dictValueService.queryPage (pageIndex, pageSize, sysDictValue));
    }

    @ApiOperation(value = "通过id查询字典项")
    @GetMapping("/item/{id}")
    public R getDictItemById(@PathVariable("id") Long id) {
        return R.ok (dictValueService.findById (id));
    }

    @ApiOperation(value = "新增字典项")
    @PutMapping("/item")
    @CacheEvict(value = CacheConstants.DICT_CACHE, allEntries = true)
    public R save(@RequestBody SysDictValue sysDictValue) {
        dictValueService.add (sysDictValue);
        return R.ok ();
    }

    @ApiOperation(value = "修改字典项")
    @PutMapping("/item/update")
    public R updateById(@RequestBody SysDictValue sysDictValue) {
        dictValueService.update (sysDictValue);
        return R.ok ();
    }

    @ApiOperation(value = "通过id删除字典项")
    @DeleteMapping("/item/{id}")
    public R deleteDictItemById(@PathVariable Long id) {
        dictValueService.deleteById (id);
        return R.ok ();
    }
}
