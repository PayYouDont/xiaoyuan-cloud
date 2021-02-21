package com.gospell.xiaoyuan.cloud.upms.common.vo;

import com.gospell.xiaoyuan.cloud.upms.common.entity.SysRole;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author
 */
@Data
public class UserVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String avatar;
    private String email;
    private Integer lockFlag;
    private Long organId;
    private String organName;
    private String wxOpenid;
    private List<SysRole> roleList;
    private List<Long> roleIds;
}
