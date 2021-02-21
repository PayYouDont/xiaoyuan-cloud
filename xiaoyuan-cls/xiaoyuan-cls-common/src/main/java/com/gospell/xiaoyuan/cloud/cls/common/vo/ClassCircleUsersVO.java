package com.gospell.xiaoyuan.cloud.cls.common.vo;

import cn.hutool.core.collection.CollUtil;
import com.gospell.xiaoyuan.cloud.upms.common.entity.SysUser;
import lombok.Data;

import java.util.List;

/**
 * @ClassName ClassCircleUsersVO
 * @Description 班级圈成员
 * @Author pay
 * @DATE 2021/2/3 17:15
 **/
@Data
public class ClassCircleUsersVO {
    /**
     * 班级圈id
     **/
    private Long classCircleId;
    /**
     * 班级id
     **/
    private Long classId;
    /**
     * 班级名称
     **/
    private String className;
    /**
     * 班级圈管理员信息(一般是当前班级班主任)
     **/
    private SysUser admin;
    /**
     * 班级圈成员(该班的所有学生家长的id)
     **/
    private List<Long> memberIds;

    /**
     * 班级圈管理员(该班的所有老师的id)
     **/
    private List<Long> managerIds;

    /**
     * 活跃状态:0-不活跃 1-活跃
     **/
    private int activeStatus;

    /**
     * @return java.util.List<java.lang.Long>
     * @Author pay
     * @Description (获取当前班级圈的所有成员id)
     * @Date 17:45 2021/2/3
     * @Param []
     **/
    public List<Long> getAllMemberIds() {
        return (List<Long>) CollUtil.union (managerIds, memberIds);
    }
}
