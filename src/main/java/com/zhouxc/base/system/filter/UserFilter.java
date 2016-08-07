package com.zhouxc.base.system.filter;

import com.zhouxc.base.core.filter.BaseFilter;

import java.util.Date;

/**
 * Created by Administrator on 2015/3/12.
 */
public class UserFilter extends BaseFilter {

    private Integer id;
    private String name;
    private Integer sex;
    private String account;
    private String password;

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

}
