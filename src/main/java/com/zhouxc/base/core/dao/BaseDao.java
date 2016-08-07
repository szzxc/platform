package com.zhouxc.base.core.dao;

import com.zhouxc.base.core.filter.BaseFilter;
import com.zhouxc.util.Pager;

import java.util.List;

/**
 * Created by Administrator on 2015/4/7.
 */
public interface BaseDao<T> {
    void save(T obj);
    void update(T obj);
    void delete(T obj);
    List<T> findAll();
    T find(Integer id);
    List<T> executeHQL(String hql, Pager pager);

    List<T> find(BaseFilter baseFilter);
    List<T> find(BaseFilter baseFilter, Pager pager);

    Long getCount();
}
