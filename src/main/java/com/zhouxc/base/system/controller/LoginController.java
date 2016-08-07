package com.zhouxc.base.system.controller;

import com.zhouxc.base.system.service.UserService;
import com.zhouxc.base.system.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2015/3/17.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelMap modelMap) {
        LoginVo loginVo = new LoginVo();
        modelMap.addAttribute("loginVo", loginVo);
        return new ModelAndView("system.login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView checkLogin(@ModelAttribute("loginVo") LoginVo loginVo, ModelMap modelMap) {
        boolean isSuccess = userService.checkUser(loginVo);
        if(isSuccess) {
            return new ModelAndView("redirect:/home/index");
        }
        modelMap.addAttribute("loginVo", loginVo);
        return new ModelAndView("system.login");
    }
}
