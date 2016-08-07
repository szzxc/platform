package com.zhouxc.knowledge.controller;

import com.zhouxc.knowledge.filter.KnowledgeFilter;
import com.zhouxc.knowledge.service.KnowledgeService;
import com.zhouxc.knowledge.service.KnowledgeTypeService;
import com.zhouxc.knowledge.vo.KnowledgeTypeVo;
import com.zhouxc.knowledge.vo.KnowledgeVo;
import com.zhouxc.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2015/3/19.
 */
@Controller
@RequestMapping("/knowledge")
public class KnowledgeController {

    @Autowired
    private KnowledgeService knowledgeService;
    @Autowired
    private KnowledgeTypeService knowledgeTypeService;

    @RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView list(@ModelAttribute("knowledgeFilter") KnowledgeFilter knowledgeFilter,
                             ModelMap modelMap, HttpServletRequest request) {

        Pager pager = new Pager(request, this.knowledgeService.getCount());

        List<KnowledgeVo> knowledgeVoList = KnowledgeVo.fromKnowledgeList(this.knowledgeService.find(knowledgeFilter, pager));
        modelMap.addAttribute("knowledgeVoList", knowledgeVoList);

        List<KnowledgeTypeVo> knowledgeTypeVoList =
                KnowledgeTypeVo.fromKnowledgeTypeList(this.knowledgeTypeService.findAll());
        modelMap.addAttribute("knowledgeTypeVoList", knowledgeTypeVoList);

        modelMap.addAttribute("knowledgeFilter", knowledgeFilter);
        modelMap.addAttribute("pager", pager);

        return new ModelAndView("knowledge.knowledge.list");
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public ModelAndView view(@PathVariable("id") Integer id, ModelMap modelMap) {
        KnowledgeVo knowledgeVo = new KnowledgeVo(this.knowledgeService.find(id));
        modelMap.addAttribute("knowledgeVo", knowledgeVo);
        return new ModelAndView("knowledge.knowledge.view");
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView initCreate(ModelMap modelMap) {

        modelMap.addAttribute("knowledgeVo", new KnowledgeVo());

        List<KnowledgeTypeVo> knowledgeTypeVoList =
                KnowledgeTypeVo.fromKnowledgeTypeList(this.knowledgeTypeService.findAll());
        modelMap.addAttribute("knowledgeTypeVoList", knowledgeTypeVoList);

        return new ModelAndView("knowledge.knowledge.create");
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("knowledgeVo") KnowledgeVo knowledgeVo) {
        this.knowledgeService.save(knowledgeVo.toKnowledge());
        return new ModelAndView("redirect:/knowledge/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView initEdit(@PathVariable("id") Integer id, ModelMap modelMap) {
        KnowledgeVo knowledgeVo = new KnowledgeVo(this.knowledgeService.find(id));
        modelMap.addAttribute("knowledgeVo", knowledgeVo);
        List<KnowledgeTypeVo> knowledgeTypeVoList =
                KnowledgeTypeVo.fromKnowledgeTypeList(this.knowledgeTypeService.findAll());
        modelMap.addAttribute("knowledgeTypeVoList", knowledgeTypeVoList);
        return new ModelAndView("knowledge.knowledge.edit");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("knowledgeVo") KnowledgeVo knowledgeVo) {
        this.knowledgeService.update(knowledgeVo.toKnowledge());
        return new ModelAndView("redirect:/knowledge/list");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") Integer id) {
        this.knowledgeService.delete(id);
        return new ModelAndView("redirect:/knowledge/list");
    }
}
