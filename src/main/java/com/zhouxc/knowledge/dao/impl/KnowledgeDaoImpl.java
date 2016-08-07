package com.zhouxc.knowledge.dao.impl;

import com.zhouxc.base.core.dao.impl.BaseDaoImpl;
import com.zhouxc.base.core.filter.BaseFilter;
import com.zhouxc.knowledge.dao.KnowledgeDao;
import com.zhouxc.knowledge.filter.KnowledgeFilter;
import com.zhouxc.knowledge.model.Knowledge;
import com.zhouxc.util.Pager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/3/17.
 */
@Repository("KnowledgeDao")
public class KnowledgeDaoImpl extends BaseDaoImpl<Knowledge> implements KnowledgeDao {

    @Override
    public List<Knowledge> find(BaseFilter baseFilter) {
        KnowledgeFilter knowledgeFilter = (KnowledgeFilter)baseFilter;
        String hql = "from Knowledge where 1=1 ";
        if (!StringUtils.isEmpty(knowledgeFilter.getTitle())) {
            String[] keywords = knowledgeFilter.getTitle().split(" ");
            hql += "and (";
            for (int i = 0; i < keywords.length; i++) {
                if (!StringUtils.isEmpty(keywords[i])) {
                    hql += "title like '%" + keywords[i] +
                            "%' or content like '%" + keywords[i] + "%' ";
                    if (i != keywords.length - 1) {
                        hql += "or ";
                    }
                }
            }
            hql += ") ";
        }
        if (knowledgeFilter.getKnowledgeTypeFilter() != null &&
                knowledgeFilter.getKnowledgeTypeFilter().getId() != null) {
            hql += "and knowledgeType.id = " + knowledgeFilter.getKnowledgeTypeFilter().getId();
        }
        hql += " order by updateTime desc";
        return (List<Knowledge>) this.hibernateTemplate.find(hql);
    }

    @Override
    public List<Knowledge> find(BaseFilter baseFilter, Pager pager) {
        KnowledgeFilter knowledgeFilter = (KnowledgeFilter)baseFilter;
        String hql = "from Knowledge where 1=1 ";
        if (!StringUtils.isEmpty(knowledgeFilter.getTitle())) {
            String[] keywords = knowledgeFilter.getTitle().split(" ");
            hql += "and (";
            for (int i = 0; i < keywords.length; i++) {
                if (!StringUtils.isEmpty(keywords[i])) {
                    hql += "title like '%" + keywords[i] +
                            "%' or content like '%" + keywords[i] + "%' ";
                    if (i != keywords.length - 1) {
                        hql += "or ";
                    }
                }
            }
            hql += ") ";
        }
        if (knowledgeFilter.getKnowledgeTypeFilter() != null &&
                knowledgeFilter.getKnowledgeTypeFilter().getId() != null) {
            hql += "and knowledgeType.id = " + knowledgeFilter.getKnowledgeTypeFilter().getId();
        }
        hql += " order by updateTime desc";
        return this.executeHQL(hql, pager);
    }
}
