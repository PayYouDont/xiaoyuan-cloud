package com.gospell.xiaoyuan.cloud.common.data.jpa.base;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * description: BaseService <br>
 * date: 2020/12/31 15:39 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
public interface BaseService<T> {

    void add(T entity);

    void update(T entity);

    T findById(Long id);

    List<T> findAll();

    void deleteById(Long id);

    Page<T> page(Integer pageIndex, Integer pageSize);

    /**
     * description: 根据实体类非空字段属性值分页查找 <br>
     * version: 1.0 <br>
     * date: 2021/1/18 17:10 <br>
     * author: pay <br>
     *
     * @param pageIndex
     * @param pageSize
     * @param entity
     * @return org.springframework.data.domain.Page<T>
     */
    Page<T> queryPage(Integer pageIndex, Integer pageSize,T entity);

    /**
     * 功能描述: <br>
     * 〈〉
     * @Param:  指定排序方式
     * @Return:
     * @Author: jiangsx
     * @Date: 2021/1/27 18:43
     */
    Page<T> queryPage(Integer pageIndex, Integer pageSize, Sort.Direction direction, T entity);

    /**
     * description: 根据实体类非空字段属性值查找所有数据 <br>
     * version: 1.0 <br>
     * date: 2021/1/18 17:14 <br>
     * author: pay <br>
     *
     * @param entity
     * @return java.util.List<T>
     */
    List<T> queryAll(T entity);

    /**
     * description: 自定义多条件分页查询 <br>
     * version: 1.0 <br>
     * date: 2021/1/19 11:29 <br>
     * author: pay <br>
     *
     * @param pageIndex
     * @param pageSize
     * @param criteria
     * @return org.springframework.data.domain.Page<T>
     */
    Page<T> queryPage(Integer pageIndex, Integer pageSize, BaseQueryCriteria criteria);
    /**
     * description: 自定义条件查询所有 <br>
     * version: 1.0 <br>
     * date: 2021/1/19 11:31 <br>
     * author: pay <br>
     *
     * @param criteria
     * @return java.util.List<T>
     */
    List<T> queryAll(BaseQueryCriteria criteria);
}
