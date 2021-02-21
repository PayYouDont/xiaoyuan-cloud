package com.gospell.xiaoyuan.cloud.common.data.jpa.base;

import cn.hutool.core.util.IdUtil;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/**
 * @ClassName SnowflakeIdGenerator
 * @Description 自定义主键生成策略，采用雪花id
 * @Author pay
 * @DATE 2021/2/4 17:23
 **/
public class SnowflakeIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return IdUtil.getSnowflake (1,1).nextId ();
    }
}
