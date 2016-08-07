package com.zhouxc.knowledge.filter;

import com.zhouxc.base.core.filter.BaseFilter;
import com.zhouxc.util.Pager;

import java.util.Date;

/**
 * Created by Administrator on 2015/3/19.
 */
public class KnowledgeFilter extends BaseFilter {
    private Integer id;
    private String title;
    private String content;
    private KnowledgeTypeFilter knowledgeTypeFilter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public KnowledgeTypeFilter getKnowledgeTypeFilter() {
        return knowledgeTypeFilter;
    }

    public void setKnowledgeTypeFilter(KnowledgeTypeFilter knowledgeTypeFilter) {
        this.knowledgeTypeFilter = knowledgeTypeFilter;
    }
}
