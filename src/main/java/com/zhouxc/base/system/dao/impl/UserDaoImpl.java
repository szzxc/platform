package com.zhouxc.base.system.dao.impl;

import com.zhouxc.base.core.dao.impl.BaseDaoImpl;
import com.zhouxc.base.core.filter.BaseFilter;
import com.zhouxc.base.system.dao.UserDao;
import com.zhouxc.base.system.model.User;
import com.zhouxc.util.Pager;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/3/12.
 */
@Repository("UserDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User findUserByAccount(String account) {
        List<User> users = (List<User>) this.hibernateTemplate.find(
                "from User where account = ?", account);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }


    @Override
    public List<User> find(BaseFilter baseFilter) {
        return null;
    }

    @Override
    public List<User> find(BaseFilter baseFilter, Pager pager) {
        return null;
    }
}
