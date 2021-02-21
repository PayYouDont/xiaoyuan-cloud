package com.gospell.xiaoyuan.cloud.common.data.jpa.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * description: BaseRespository <br>
 * date: 2020/12/30 17:40 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
public interface BaseRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T>{
}
