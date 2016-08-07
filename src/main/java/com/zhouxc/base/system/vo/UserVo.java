package com.zhouxc.base.system.vo;

import com.zhouxc.base.system.model.User;

import java.util.Date;

/**
 * Created by Administrator on 2015/3/12.
 */
public class UserVo {

    private Integer id;
    private String name;
    private Integer sex;
    private String account;
    private String password;
    private Date createTime;
    private Date updateTime;

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public UserVo() {

    }

    public UserVo(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.account = user.getAccount();
        this.password = user.getPassword();
        this.sex = user.getSex();
        this.createTime = user.getCreateTime();
        this.updateTime = user.getUpdateTime();
    }
}
