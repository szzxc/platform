package com.zhouxc.base.system.service;

import com.zhouxc.base.core.service.BaseService;
import com.zhouxc.base.system.model.User;
import com.zhouxc.base.system.vo.LoginVo;

/**
 * Created by Administrator on 2015/3/12.
 */
public interface UserService extends BaseService<User> {

    boolean checkUser(LoginVo loginVo);
}
