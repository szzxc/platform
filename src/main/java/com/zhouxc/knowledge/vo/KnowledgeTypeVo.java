package com.zhouxc.knowledge.vo;

import com.zhouxc.knowledge.model.KnowledgeType;
import com.zhouxc.util.DateUtil;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by Administrator on 2015/3/17.
 */
public class KnowledgeTypeVo {
    private Integer id;
    private String name;
    private String remark;
    private Set<KnowledgeVo> knowledgeVos = new HashSet<KnowledgeVo>();
    private String createTime;
    private String updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<KnowledgeVo> getKnowledgeVos() {
        return knowledgeVos;
    }

    public void setKnowledgeVos(Set<KnowledgeVo> knowledgeVos) {
        this.knowledgeVos = knowledgeVos;
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

    public KnowledgeTypeVo(){}

    public KnowledgeTypeVo(KnowledgeType knowledgeType) {
        this.id = knowledgeType.getId();
        this.name = knowledgeType.getName();
        this.remark = knowledgeType.getRemark();
        // TODO
//        this.knowledgeVos = knowledgeType.getKnowledges();
        this.createTime = DateUtil.dateToString(knowledgeType.getCreateTime());
        this.updateTime = DateUtil.dateToString(knowledgeType.getUpdateTime());
    }

    public KnowledgeType toKnowledgeType() {
        KnowledgeType knowledgeType = new KnowledgeType();
        knowledgeType.setId(this.id);
        knowledgeType.setName(this.name);
        knowledgeType.setRemark(this.remark);
        if(StringUtils.isEmpty(this.createTime)) {
            knowledgeType.setCreateTime(new Date());
        } else {
            knowledgeType.setCreateTime(DateUtil.stringToDate(this.createTime));
        }
        knowledgeType.setUpdateTime(new Date());
        // TODO
//        knowledgeType.setKnowledges(this.knowledgeVos.toKnowledges());

        return knowledgeType;
    }

    public static List<KnowledgeTypeVo> fromKnowledgeTypeList(List<KnowledgeType> knowledgeTypeList) {
        List<KnowledgeTypeVo> knowledgeTypeVoList = new ArrayList<KnowledgeTypeVo>();
        for(KnowledgeType knowledgeType : knowledgeTypeList){
            knowledgeTypeVoList.add(new KnowledgeTypeVo(knowledgeType));
        }
        return knowledgeTypeVoList;
    }
}
