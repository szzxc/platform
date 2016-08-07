package com.zhouxc.knowledge.service.impl;

import com.zhouxc.base.core.dao.BaseDao;
import com.zhouxc.base.core.service.impl.BaseServiceImpl;
import com.zhouxc.knowledge.dao.KnowledgeDao;
import com.zhouxc.knowledge.filter.KnowledgeFilter;
import com.zhouxc.knowledge.model.Knowledge;
import com.zhouxc.knowledge.service.KnowledgeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/3/17.
 */
@Service("KnowledgeService")
public class KnowledgeServiceImpl extends BaseServiceImpl<Knowledge> implements KnowledgeService {

    @Resource(name = "KnowledgeDao")
    private KnowledgeDao knowledgeDao;

    @Override
    protected BaseDao<Knowledge> getDao() {
        return knowledgeDao;
    }
}
