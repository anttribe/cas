/*
 * 文  件   名: WebsiteController.java
 * 版         本 : (Anttribe).cas-console-web All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月31日
 */
package org.anttribe.cas.console.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.anttribe.cas.base.application.ICategoryApplication;
import org.anttribe.cas.base.application.IWebsiteApplication;
import org.anttribe.cas.base.core.entity.Category;
import org.anttribe.cas.base.core.entity.Website;
import org.anttribe.cas.base.infra.errorno.WebsiteErrorNo;
import org.anttribe.vigor.infra.common.constants.Keys;
import org.anttribe.vigor.infra.common.entity.Result;
import org.anttribe.vigor.infra.common.errorno.SystemErrorNo;
import org.anttribe.vigor.infra.common.exception.UnifyException;
import org.anttribe.vigor.infra.common.web.controller.AbstractController;
import org.anttribe.vigor.infra.persist.entity.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author zhaoyong
 * @version 2015年10月31日
 */
@Controller
@RequestMapping("/website")
public class WebsiteController extends AbstractController
{
    @Autowired
    private IWebsiteApplication websiteApplication;
    
    @Autowired
    private ICategoryApplication categoryApplication;
    
    @RequestMapping({"", "/", "/index"})
    public ModelAndView index(HttpServletRequest request, ModelAndView mv, Website website, Pagination pagination)
    {
        return this.list(request, mv, website, pagination);
    }
    
    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, ModelAndView mv, Website website, Pagination pagination)
    {
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("category", website.getCategory());
        criteria.put("siteName", website.getSiteName());
        pagination = websiteApplication.listEntities(criteria, pagination);
        
        mv.setViewName(Views.LIST_VIEW);
        mv.addObject(Keys.KEY_PARAM, website);
        mv.addObject(Keys.KEY_PAGE, pagination);
        if (null != pagination)
        {
            mv.addObject(Keys.KEY_PAGE_DATA, pagination.getDatas());
        }
        
        // 获取一级分类
        List<Category> categorys = this.categoryApplication.listEntities(new HashMap<String, Object>());
        mv.addObject("categorys", categorys);
        return mv;
    }
    
    @RequestMapping("/add")
    public String add()
    {
        return Views.ADD_VIEW;
    }
    
    @RequestMapping("/edit")
    public ModelAndView edit(HttpServletRequest request, ModelAndView mv, Website website)
    {
        if (null == website || null == website.getId())
        {
            throw new UnifyException(SystemErrorNo.DATA_NOT_EXIST_ERROR);
        }
        
        Map<String, Object> criteria = new HashMap<String, Object>();
        website = this.websiteApplication.findEntity(criteria);
        if (null == website)
        {
            throw new UnifyException(SystemErrorNo.DATA_NOT_EXIST_ERROR);
        }
        
        mv.setViewName(Views.EDIT_VIEW);
        mv.addObject(Keys.KEY_PARAM, website);
        return mv;
    }
    
    @ResponseBody
    @RequestMapping("/edit/exec")
    public Result<?> doEdit(HttpServletRequest request, Website website)
    {
        Result<?> result = new Result<Object>();
        if (null != website)
        {
            boolean validateResult = this.validateNameUnique(request, website);
            if (!validateResult)
            {
                result.setResultCode(WebsiteErrorNo.WEBSITE_NAME_UNIQUE);
                return result;
            }
            this.websiteApplication.persistentEntity(website);
            result.setResultCode(org.anttribe.cas.base.infra.constants.Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    @ResponseBody
    @RequestMapping("/delete/exec")
    public Result<?> doDelete(HttpServletRequest request, Website website)
    {
        Result<?> result = new Result<Object>();
        if (null != website && null != website.getId())
        {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("id", website.getId());
            this.websiteApplication.removeEntity(criteria);
            result.setResultCode(org.anttribe.cas.base.infra.constants.Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    @ResponseBody
    @RequestMapping("/validate/nameUnique")
    public boolean validateNameUnique(HttpServletRequest request, Website website)
    {
        if (null != website && !StringUtils.isEmpty(website.getSiteName()))
        {
            return this.websiteApplication.validateNameUnique(website);
        }
        return false;
    }
    
    class Views
    {
        public static final String INDEX_VIEW = "/website/list";
        
        public static final String LIST_VIEW = "/website/list";
        
        public static final String ADD_VIEW = "/website/edit";
        
        public static final String EDIT_VIEW = "/website/edit";
        
    }
}