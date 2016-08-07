package com.zhouxc.base.system.dao;

import com.zhouxc.base.core.dao.BaseDao;
import com.zhouxc.base.system.model.User;

/**
 * Created by Administrator on 2015/3/12.
 */
public interface UserDao extends BaseDao<User> {

    User findUserByAccount(String account);

}
