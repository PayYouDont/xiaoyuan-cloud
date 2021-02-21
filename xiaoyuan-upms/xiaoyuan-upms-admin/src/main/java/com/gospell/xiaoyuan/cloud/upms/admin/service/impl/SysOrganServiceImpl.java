package com.gospell.xiaoyuan.cloud.upms.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.gospell.xiaoyuan.cloud.common.core.constant.CommonConstants;
import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseServiceImpl;
import com.gospell.xiaoyuan.cloud.upms.admin.repository.SysOrganRepository;
import com.gospell.xiaoyuan.cloud.upms.admin.service.SysOrganService;
import com.gospell.xiaoyuan.cloud.upms.common.dto.OrganTree;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysOrgan;
import com.gospell.xiaoyuan.cloud.upms.common.util.TreeUtil;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description: SysRoleServiceImpl <br>
 * date: 2021/1/6 19:15 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Service
public class SysOrganServiceImpl extends BaseServiceImpl<SysOrgan> implements SysOrganService {
    private final SysOrganRepository repository;
    public SysOrganServiceImpl(SysOrganRepository repository) {
        super (repository);
        this.repository = repository;
    }

    @Override
    public List<OrganTree> selectTree() {
        List<OrganTree> treeList = repository.findAll ().stream()
                .filter(entity -> !entity.getId().equals(entity.getParentId()))
                .sorted(Comparator.comparingInt(SysOrgan::getSort))
                .map(entity -> {
                    OrganTree node = new OrganTree();
                    BeanUtil.copyProperties(entity,node);
                    return node;
                }).collect(Collectors.toList());
        return TreeUtil.build(treeList, CommonConstants.PARENT_ID);
    }

}
