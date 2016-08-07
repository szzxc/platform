package com.zhouxc.knowledge.vo;

import com.zhouxc.knowledge.model.Knowledge;
import com.zhouxc.util.DateUtil;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/3/19.
 */
public class KnowledgeVo {
    private Integer id;
    private String title;
    private String content;
    private KnowledgeTypeVo knowledgeTypeVo;
    private String createTime;
    private String updateTime;

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

    public KnowledgeTypeVo getKnowledgeTypeVo() {
        return knowledgeTypeVo;
    }

    public void setKnowledgeTypeVo(KnowledgeTypeVo knowledgeTypeVo) {
        this.knowledgeTypeVo = knowledgeTypeVo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public KnowledgeVo(){}

    public KnowledgeVo(Knowledge knowledge){
        this.id = knowledge.getId();
        this.title = knowledge.getTitle();
        this.content = knowledge.getContent();
        this.knowledgeTypeVo = new KnowledgeTypeVo(knowledge.getKnowledgeType());
        this.createTime = DateUtil.dateToString(knowledge.getCreateTime());
        this.updateTime = DateUtil.dateToString(knowledge.getUpdateTime());
    }

    public Knowledge toKnowledge() {
        Knowledge knowledge = new Knowledge();
        knowledge.setId(this.id);
        knowledge.setTitle(this.title);
        knowledge.setContent(this.content);
        knowledge.setKnowledgeType(this.knowledgeTypeVo == null ? null : this.knowledgeTypeVo.toKnowledgeType());
        if(StringUtils.isEmpty(this.createTime)) {
            knowledge.setCreateTime(new Date());
        } else {
            knowledge.setCreateTime(DateUtil.stringToDate(this.createTime));
        }
        knowledge.setUpdateTime(new Date());
        return knowledge;
    }

    public static List<KnowledgeVo> fromKnowledgeList(List<Knowledge> knowledgeList) {
        List<KnowledgeVo> knowledgeVoList = new ArrayList<KnowledgeVo>();
        for(Knowledge knowledge : knowledgeList){
            knowledgeVoList.add(new KnowledgeVo(knowledge));
        }
        return knowledgeVoList;
    }
}
