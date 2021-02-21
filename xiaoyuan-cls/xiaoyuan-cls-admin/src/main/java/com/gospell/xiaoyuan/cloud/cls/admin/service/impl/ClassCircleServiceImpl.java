package com.gospell.xiaoyuan.cloud.cls.admin.service.impl;

import com.gospell.xiaoyuan.cloud.cls.admin.repository.ClassCircleRepository;
import com.gospell.xiaoyuan.cloud.cls.admin.service.ClassCircleService;
import com.gospell.xiaoyuan.cloud.cls.common.entity.ClassCircle;
import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ClassCircleServiceImpl extends BaseServiceImpl<ClassCircle> implements ClassCircleService {
    private final ClassCircleRepository repository;

    public ClassCircleServiceImpl(ClassCircleRepository repository) {
        super (repository);
        this.repository = repository;
    }

    @Override
    public ClassCircle findByGuardianId(Long guardianId) {
        //feign远程调用学生管理模块获取班级信息
        return null;
    }

    @Override
    public ClassCircle findByClassId(Long classId) {
        return repository.findClassCircleByClassId(classId);
    }
}
