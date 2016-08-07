package com.zhouxc.base.core.service;

import com.zhouxc.base.core.filter.BaseFilter;
import com.zhouxc.util.Pager;

import java.util.List;

/**
 * Created by Administrator on 2015/4/7.
 */
public interface BaseService<T> {
    void save(T obj);
    void update(T obj);
    void delete(T obj);
    void delete(Integer id);
    List<T> findAll();
    List<T> find(BaseFilter baseFilter);
    List<T> find(BaseFilter baseFilter, Pager pager);
    T find(Integer id);
    Long getCount();
}
