/*
 * 文  件   名: ContentAttributeController.java
 * 版         本 : (Anttribe).cas-console-web All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.console.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.anttribe.cas.base.application.IContentAttributeApplication;
import org.anttribe.cas.base.core.entity.ContentAttribute;
import org.anttribe.vigor.infra.common.constants.Keys;
import org.anttribe.vigor.infra.common.entity.Result;
import org.anttribe.vigor.infra.persist.entity.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhaoyong
 * @version 2015年11月6日
 */
@Controller
@RequestMapping("/contentAttribute")
public class ContentAttributeController
{
    @Autowired
    private IContentAttributeApplication contentAttributeApplication;
    
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, ModelAndView mv, ContentAttribute contentAttribute,
        Pagination pagination)
    {
        return this.list(request, mv, contentAttribute, pagination);
    }
    
    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, ModelAndView mv, ContentAttribute contentAttribute,
        Pagination pagination)
    {
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("contentType", contentAttribute.getContentType());
        pagination = contentAttributeApplication.listEntities(criteria, pagination);
        
        mv.setViewName("/contentAttribute/list");
        mv.addObject(Keys.KEY_PARAM, contentAttribute);
        mv.addObject(Keys.KEY_PAGE, pagination);
        if (null != pagination)
        {
            mv.addObject(Keys.KEY_PAGE_DATA, pagination.getDatas());
        }
        return mv;
    }
    
    @RequestMapping("/list/exec")
    @ResponseBody
    public List<ContentAttribute> doList(HttpServletRequest request, ContentAttribute contentAttribute)
    {
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("contentType", contentAttribute.getContentType());
        return contentAttributeApplication.listEntities(criteria);
    }
    
    @RequestMapping("/add")
    public String goAddContentAttribute()
    {
        return "/contentAttribute/edit";
    }
    
    @RequestMapping("/edit")
    public String goEditContentAttribute(HttpServletRequest request, ContentAttribute contentAttribute)
    {
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("id", contentAttribute.getId());
        contentAttribute = contentAttributeApplication.findEntity(criteria);
        if (null != contentAttribute)
        {
            request.setAttribute("contentAttribute", contentAttribute);
            return "/contentAttribute/edit";
        }
        return "redirect:/contentAttribute/index";
    }
    
    @ResponseBody
    @RequestMapping("/edit/exec")
    public Result<?> doEditContentAttribute(HttpServletRequest request, ContentAttribute contentAttribute)
    {
        Result<?> result = new Result<Object>();
        if (null != contentAttribute)
        {
            contentAttributeApplication.persistentEntity(contentAttribute);
            result.setResultCode(org.anttribe.cas.base.infra.constants.Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    @ResponseBody
    @RequestMapping("/delete/exec")
    public Result<?> doDeleteContentAttribute(HttpServletRequest request, ContentAttribute contentAttribute)
    {
        Result<?> result = new Result<Object>();
        if (null != contentAttribute)
        {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("id", contentAttribute.getId());
            contentAttributeApplication.removeEntity(criteria);
            result.setResultCode(org.anttribe.cas.base.infra.constants.Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
}