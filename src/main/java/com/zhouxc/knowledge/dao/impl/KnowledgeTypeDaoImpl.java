package com.zhouxc.knowledge.dao.impl;

import com.zhouxc.base.core.dao.impl.BaseDaoImpl;
import com.zhouxc.base.core.filter.BaseFilter;
import com.zhouxc.knowledge.dao.KnowledgeTypeDao;
import com.zhouxc.knowledge.model.KnowledgeType;
import com.zhouxc.util.Pager;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/3/17.
 */
@Repository("KnowledgeTypeDao")
public class KnowledgeTypeDaoImpl extends BaseDaoImpl<KnowledgeType> implements KnowledgeTypeDao{

    @Override
    public List<KnowledgeType> find(BaseFilter baseFilter) {
        return null;
    }

    @Override
    public List<KnowledgeType> find(BaseFilter baseFilter, Pager pager) {
        return null;
    }
}
