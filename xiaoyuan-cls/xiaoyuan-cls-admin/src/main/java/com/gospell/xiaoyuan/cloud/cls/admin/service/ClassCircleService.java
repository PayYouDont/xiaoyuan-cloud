package com.gospell.xiaoyuan.cloud.cls.admin.service;

import com.gospell.xiaoyuan.cloud.cls.common.entity.ClassCircle;
import com.gospell.xiaoyuan.cloud.common.data.jpa.base.BaseService;

public interface ClassCircleService extends BaseService<ClassCircle> {
    /**
    * @Author peiyongdong
    * @Description ( 根据监护人id获取班级圈 )
    * @Date 16:21 2021/2/5
    * @Param [guardianId]
    * @return com.gospell.xiaoyuan.cloud.cls.entity.ClassCircle
    **/
    ClassCircle findByGuardianId(Long guardianId);

    /**
    * @Author peiyongdong
    * @Description ( 根据班级id获取班级圈 )
    * @Date 16:57 2021/2/5
    * @Param [classId]
    * @return com.gospell.xiaoyuan.cloud.cls.entity.ClassCircle
    **/
    ClassCircle findByClassId(Long classId);
}
