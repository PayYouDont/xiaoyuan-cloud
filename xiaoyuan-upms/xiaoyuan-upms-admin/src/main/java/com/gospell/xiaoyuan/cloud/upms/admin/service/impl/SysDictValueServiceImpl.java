package com.gospell.xiaoyuan.cloud.upms.admin.service.impl;

import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseServiceImpl;
import com.gospell.xiaoyuan.cloud.upms.admin.repository.SysDictValueRepository;
import com.gospell.xiaoyuan.cloud.upms.admin.service.SysDictValueService;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysDictValue;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: SysDictServiceImpl <br>
 * date: 2021/1/18 10:30 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Service
public class SysDictValueServiceImpl extends BaseServiceImpl<SysDictValue> implements SysDictValueService {
    private final SysDictValueRepository repository;

    public SysDictValueServiceImpl(SysDictValueRepository repository) {
        super (repository);
        this.repository = repository;
    }

    @Override
    public List<SysDictValue> findByType(String type) {
        return repository.findAllByType (type);
    }
}
