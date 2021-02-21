package com.gospell.xiaoyuan.cloud.common.data.jpa.base;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ReflectUtil;

import com.gospell.xiaoyuan.cloud.common.data.jpa.util.JpaQueryUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description: BaseService <br>
 * date: 2020/12/31 15:39 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@AllArgsConstructor
@Slf4j
public class BaseServiceImpl<T> implements BaseService<T> {

    private final BaseRepository<T> repository;

    @Override
    public void add(T entity) {
        repository.save (entity);
    }

    @Override
    public void update(T entity) {
        repository.save (entity);
    }

    @Override
    public T findById(Long id) {
        return repository.findById (id).orElse (null);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll ();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById (id);
    }

    @Override
    public Page<T> page(@NotNull(message = "当前分页数不能为空") Integer pageIndex,
                        @NotNull(message = "每页数量不能为空") Integer pageSize) {
        Pageable pageable = PageRequest.of (pageIndex, pageSize, Sort.by (Sort.Direction.ASC, "id"));
        return repository.findAll (pageable);
    }

    @Override
    public Page<T> queryPage(@NotNull(message = "当前分页数不能为空") Integer pageIndex,
                             @NotNull(message = "每页数量不能为空") Integer pageSize, T entity) {
        return queryPage (pageIndex,pageSize, Sort.Direction.ASC,entity);
    }

    @Override
    public Page<T> queryPage(@NotNull(message = "当前分页数不能为空") Integer pageIndex,
                             @NotNull(message = "每页数量不能为空") Integer pageSize, Sort.Direction direction, T entity) {
        Pageable pageable = PageRequest.of (pageIndex, pageSize, Sort.by (direction, "id"));
        return repository.findAll (createQuerySpec (entity), pageable);
    }

    @Override
    public List<T> queryAll(T entity) {
        return repository.findAll (createQuerySpec (entity));
    }

    /**
     * description: 根据实体类生成查询条件 <br>
     * version: 1.0 <br>
     * date: 2021/1/18 17:11 <br>
     * author: pay <br>
     *
     * @param entity
     * @return org.springframework.data.jpa.domain.Specification<T>
     */
    public Specification<T> createQuerySpec(T entity){
        List<Predicate> predicates = new ArrayList<> ();
        return (root, query, criteriaBuilder) -> {
            //获取不为空的属性
            Arrays.stream (ReflectUtil.getFields (entity.getClass ())).forEach (field -> {
                field.setAccessible (true);
                Object value = null;
                try {
                    value = field.get (entity);
                } catch (IllegalAccessException e) {
                    log.error (e.getMessage (), e);
                }
                if (value != null) {
                    predicates.add (criteriaBuilder.equal (root.get (field.getName ()), value));
                }
            });
            return criteriaBuilder.and (ArrayUtil.toArray (predicates, Predicate.class));
        };
    }

    @Override
    public Page<T> queryPage(Integer pageIndex, Integer pageSize, BaseQueryCriteria criteria) {
        return repository.findAll((root, criteriaQuery, cb) -> JpaQueryUtil.getPredicate(root, criteria, cb),PageRequest.of (pageIndex, pageSize));
    }

    @Override
    public List<T> queryAll(BaseQueryCriteria criteria) {
        return repository.findAll ((root, query, cb) -> JpaQueryUtil.getPredicate(root, criteria, cb));
    }
}
