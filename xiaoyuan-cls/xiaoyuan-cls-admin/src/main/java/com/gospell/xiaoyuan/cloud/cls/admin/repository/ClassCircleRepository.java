package com.gospell.xiaoyuan.cloud.cls.admin.repository;

import com.gospell.xiaoyuan.cloud.cls.common.entity.ClassCircle;
import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseRepository;

/**
 * @ClassName ClassCircleRepository
 * @Description TODO
 * @Author pay
 * @DATE 2021/2/5 15:23
 **/
public interface ClassCircleRepository extends BaseRepository<ClassCircle> {
    ClassCircle findClassCircleByClassId(Long classId);
}
