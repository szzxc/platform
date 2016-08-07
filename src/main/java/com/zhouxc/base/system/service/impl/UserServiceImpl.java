package com.zhouxc.base.system.service.impl;

import com.zhouxc.base.core.dao.BaseDao;
import com.zhouxc.base.core.service.impl.BaseServiceImpl;
import com.zhouxc.base.system.dao.UserDao;
import com.zhouxc.base.system.model.User;
import com.zhouxc.base.system.service.UserService;
import com.zhouxc.base.system.vo.LoginVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2015/3/12.
 */
@Service("UserService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Resource(name = "UserDao")
    private UserDao userDao;

    @Override
    protected BaseDao<User> getDao() {
        return userDao;
    }

    @Override
    public boolean checkUser(LoginVo loginVo) {
        User user = userDao.findUserByAccount(loginVo.getAccount());
        if(user != null) {
            return loginVo.getPassword().equals(user.getPassword());
        } else {
            return false;
        }
    }


}
