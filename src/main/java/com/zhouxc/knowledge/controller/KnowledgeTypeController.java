package com.zhouxc.knowledge.controller;

import com.zhouxc.knowledge.service.KnowledgeTypeService;
import com.zhouxc.knowledge.vo.KnowledgeTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2015/3/17.
 */
@Controller
@RequestMapping("/knowledgeType")
public class KnowledgeTypeController {

    @Autowired
    private KnowledgeTypeService knowledgeTypeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(ModelMap modelMap) {
        List<KnowledgeTypeVo> knowledgeTypeVoList = KnowledgeTypeVo.fromKnowledgeTypeList(this.knowledgeTypeService.findAll());
        modelMap.addAttribute("knowledgeTypeVoList", knowledgeTypeVoList);
        return new ModelAndView("knowledge.knowledgeType.list");
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView initCreate(ModelMap modelMap) {
        KnowledgeTypeVo knowledgeTypeVo = new KnowledgeTypeVo();
        modelMap.addAttribute("knowledgeTypeVo", knowledgeTypeVo);
        return new ModelAndView("knowledge.knowledgeType.create");
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("knowledgeTypeVo") KnowledgeTypeVo knowledgeTypeVo) {
        this.knowledgeTypeService.save(knowledgeTypeVo.toKnowledgeType());
        return new ModelAndView("redirect:/knowledgeType/list");
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView initEdit(@PathVariable("id") Integer id, ModelMap modelMap) {
        KnowledgeTypeVo knowledgeTypeVo = new KnowledgeTypeVo(this.knowledgeTypeService.find(id));
        modelMap.addAttribute("knowledgeTypeVo", knowledgeTypeVo);
        return new ModelAndView("knowledge.knowledgeType.edit");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("knowledgeTypeVo") KnowledgeTypeVo knowledgeTypeVo) {
        this.knowledgeTypeService.update(knowledgeTypeVo.toKnowledgeType());
        return new ModelAndView("redirect:/knowledgeType/list");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") Integer id) {
        this.knowledgeTypeService.delete(id);
        return new ModelAndView("redirect:/knowledgeType/list");
    }
}
