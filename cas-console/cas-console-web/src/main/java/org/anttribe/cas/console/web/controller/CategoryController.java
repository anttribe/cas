/*
 * 文  件   名: CategoryController.java
 * 版         本 : (Anttribe).cas-console-web All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月19日
 */
package org.anttribe.cas.console.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.anttribe.cas.base.application.ICategoryApplication;
import org.anttribe.cas.base.core.entity.Category;
import org.anttribe.vigor.infra.common.constants.Constants;
import org.anttribe.vigor.infra.common.constants.Keys;
import org.anttribe.vigor.infra.common.entity.Result;
import org.anttribe.vigor.infra.common.errorno.SystemErrorNo;
import org.anttribe.vigor.infra.common.exception.ServiceException;
import org.anttribe.vigor.infra.common.exception.UnifyException;
import org.anttribe.vigor.infra.common.web.controller.AbstractController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhaoyong
 * @version 2015年10月19日
 */
@Controller
@RequestMapping("/category")
public class CategoryController extends AbstractController
{
    
    @Autowired
    private ICategoryApplication categoryApplication;
    
    @RequestMapping({"", "/", "/index"})
    public ModelAndView index(HttpServletRequest request, ModelAndView mv, Category category)
    {
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("parent", category.getParent());
        List<Category> categorys = this.categoryApplication.listEntities(criteria);
        
        mv.setViewName(Views.INDEX_VIEW);
        mv.addObject(Keys.KEY_PAGE_DATA, categorys);
        return mv;
    }
    
    @RequestMapping("/list/exec")
    @ResponseBody
    public Result<?> doList(HttpServletRequest request, Category category)
    {
        Result<List<Category>> result = new Result<List<Category>>();
        try
        {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("name", category.getName());
            criteria.put("parent", category.getParent());
            List<Category> resources = categoryApplication.listEntities(criteria);
            result.setData(resources);
            
            result.setResultCode(Constants.Common.DEFAULT_RESULT_CODE);
        }
        catch (ServiceException e)
        {
            result.setResultCode(e.getErrorNo());
        }
        return result;
    }
    
    @RequestMapping("/tool/selector")
    public String select(HttpServletRequest request, Category Category)
    {
        return Views.SELECTOR_VIEW;
    }
    
    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest request, ModelAndView mv, Category category)
    {
        mv.setViewName(Views.ADD_VIEW);
        
        if (null != category.getParent() && null != category.getParent().getId())
        {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("id", category.getParent().getId());
            Category parent = categoryApplication.findEntity(criteria);
            category.setParent(parent);
        }
        mv.addObject(Keys.KEY_PARAM, category);
        
        return mv;
    }
    
    @RequestMapping("/edit")
    public ModelAndView edit(HttpServletRequest request, ModelAndView mv, Category category)
    {
        if (null == category || null == category.getId())
        {
            throw new UnifyException(SystemErrorNo.DATA_NOT_EXIST_ERROR);
        }
        
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("id", category.getId());
        category = this.categoryApplication.findEntity(criteria);
        if (null == category || null == category.getId())
        {
            throw new UnifyException(SystemErrorNo.DATA_NOT_EXIST_ERROR);
        }
        
        mv.setViewName(Views.EDIT_VIEW);
        mv.addObject(Keys.KEY_PARAM, category);
        return mv;
    }
    
    @ResponseBody
    @RequestMapping("/edit/exec")
    public Result<?> doEdit(HttpServletRequest request, Category category)
    {
        Result<?> result = new Result<String>();
        try
        {
            // TODO： 数据校验
            categoryApplication.persistentEntity(category);
            result.setResultCode(Constants.Common.DEFAULT_RESULT_CODE);
        }
        catch (ServiceException e)
        {
            result.setResultCode(e.getErrorNo());
        }
        return result;
    }
    
    @ResponseBody
    @RequestMapping("/delete/exec")
    public Result<?> doDeleteCategory(HttpServletRequest request, Category category)
    {
        Result<?> result = new Result<String>();
        try
        {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("id", category.getId());
            categoryApplication.removeEntity(criteria);
            result.setResultCode(Constants.Common.DEFAULT_RESULT_CODE);
        }
        catch (ServiceException e)
        {
            result.setResultCode(e.getErrorNo());
        }
        return result;
    }
    
    @ResponseBody
    @RequestMapping("/validate/nameUnique")
    public boolean validateNameUnique(HttpServletRequest request, Category category)
    {
        if (null != category && !StringUtils.isEmpty(category.getName()))
        {
            return this.categoryApplication.validateNameUnique(category);
        }
        return false;
    }
    
    class Views
    {
        
        public static final String INDEX_VIEW = "/category/list";
        
        public static final String LIST_VIEW = "/category/list";
        
        public static final String ADD_VIEW = "/category/edit";
        
        public static final String EDIT_VIEW = "/category/edit";
        
        /**
         * 选择器视图
         */
        public static final String SELECTOR_VIEW = "/category/tool.selector";
        
    }
}