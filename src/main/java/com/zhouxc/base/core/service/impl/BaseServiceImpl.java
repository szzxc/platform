package com.zhouxc.base.core.service.impl;


import com.zhouxc.base.core.dao.BaseDao;
import com.zhouxc.base.core.filter.BaseFilter;
import com.zhouxc.base.core.service.BaseService;
import com.zhouxc.util.Pager;

import java.util.List;

/**
 * Created by Administrator on 2015/4/7.
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected abstract BaseDao<T> getDao();

    @Override
    public void save(T obj) {
        getDao().save(obj);
    }

    @Override
    public void update(T obj) {
        getDao().update(obj);
    }

    @Override
    public void delete(T obj) {
        getDao().delete(obj);
    }

    @Override
    public void delete(Integer id) {
        T obj = find(id);
        delete(obj);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public List<T> find(BaseFilter baseFilter) {
        return getDao().find(baseFilter);
    }

    @Override
    public List<T> find(BaseFilter baseFilter, Pager pager) {
        return getDao().find(baseFilter, pager);
    }

    @Override
    public T find(Integer id) {
        return getDao().find(id);
    }

    @Override
    public Long getCount() {
        return getDao().getCount();
    }
}
