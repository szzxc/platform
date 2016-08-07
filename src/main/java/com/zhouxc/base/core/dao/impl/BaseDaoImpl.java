package com.zhouxc.base.core.dao.impl;


import com.zhouxc.base.core.dao.BaseDao;
import com.zhouxc.base.core.filter.BaseFilter;
import com.zhouxc.util.Pager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Administrator on 2015/4/7.
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    private Class<T> clazz;

    public BaseDaoImpl() {
        clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Resource(name = "hibernateTemplate")
    protected HibernateTemplate hibernateTemplate;

    @Override
    public void save(T obj) {
        this.hibernateTemplate.save(obj);
    }

    @Override
    public void update(T obj) {
        this.hibernateTemplate.update(obj);
    }

    @Override
    public void delete(T obj) {
        this.hibernateTemplate.delete(obj);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) this.hibernateTemplate.find("from " + clazz.getSimpleName() + " order by updateTime desc");
    }

    @Override
    public T find(Integer id) {
        return this.hibernateTemplate.get(clazz, id);
    }

    @Override
    public List<T> executeHQL(final String hql, final Pager pager) {
        return hibernateTemplate.execute(new HibernateCallback<List<T>>() {
            @Override
            public List<T> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hql);
                query.setFirstResult(pager.getStartRow());
                query.setMaxResults(pager.getPageSize());
                return query.list();
            }
        });
    }

    @Override
    public Long getCount() {
        return (Long)this.hibernateTemplate.find("select count(id) from " + clazz.getSimpleName()).get(0);
    }
}
