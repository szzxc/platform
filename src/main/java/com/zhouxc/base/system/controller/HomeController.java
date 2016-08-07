package com.zhouxc.base.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2015/3/17.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(value = "/index")
    public ModelAndView index(ModelMap modelMap) {

        return new ModelAndView("system.home.index");
    }

}
