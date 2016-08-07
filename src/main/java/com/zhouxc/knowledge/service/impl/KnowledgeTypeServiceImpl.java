package com.zhouxc.knowledge.service.impl;

import com.zhouxc.base.core.dao.BaseDao;
import com.zhouxc.base.core.service.impl.BaseServiceImpl;
import com.zhouxc.knowledge.dao.KnowledgeTypeDao;
import com.zhouxc.knowledge.model.KnowledgeType;
import com.zhouxc.knowledge.service.KnowledgeTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/3/17.
 */
@Service("KnowledgeTypeService")
public class KnowledgeTypeServiceImpl extends BaseServiceImpl<KnowledgeType> implements KnowledgeTypeService {

    @Resource(name = "KnowledgeTypeDao")
    private KnowledgeTypeDao knowledgeTypeDao;

    @Override
    protected BaseDao<KnowledgeType> getDao() {
        return knowledgeTypeDao;
    }
}
