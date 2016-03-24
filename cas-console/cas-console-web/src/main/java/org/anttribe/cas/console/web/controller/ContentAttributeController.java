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
import org.anttribe.cas.base.application.IContentTypeApplication;
import org.anttribe.cas.base.core.entity.ContentAttribute;
import org.anttribe.cas.base.core.entity.ContentType;
import org.anttribe.vigor.infra.common.constants.Constants;
import org.anttribe.vigor.infra.common.constants.Keys;
import org.anttribe.vigor.infra.common.entity.Result;
import org.anttribe.vigor.infra.common.errorno.SystemErrorNo;
import org.anttribe.vigor.infra.common.exception.UnifyException;
import org.anttribe.vigor.infra.common.web.controller.AbstractController;
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
public class ContentAttributeController extends AbstractController
{
    @Autowired
    private IContentAttributeApplication contentAttributeApplication;
    
    @Autowired
    private IContentTypeApplication contentTypeApplication;
    
    @RequestMapping({"", "/", "/index"})
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
        
        mv.setViewName(Views.LIST_VIEW);
        mv.addObject(Keys.KEY_PARAM, contentAttribute);
        mv.addObject(Keys.KEY_PAGE, pagination);
        if (null != pagination)
        {
            mv.addObject(Keys.KEY_PAGE_DATA, pagination.getDatas());
        }
        
        criteria = new HashMap<String, Object>();
        List<ContentType> contentTypes = contentTypeApplication.listEntities(criteria);
        mv.addObject("contentTypes", contentTypes);
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
    public ModelAndView add(HttpServletRequest request, ModelAndView mv, ContentAttribute contentAttribute)
    {
        mv.setViewName(Views.ADD_VIEW);
        
        mv.addObject(Keys.KEY_PARAM, contentAttribute);
        return mv;
    }
    
    @RequestMapping("/edit")
    public ModelAndView edit(HttpServletRequest request, ModelAndView mv, ContentAttribute contentAttribute)
    {
        if (null == contentAttribute || null == contentAttribute.getId())
        {
            throw new UnifyException(SystemErrorNo.DATA_NOT_EXIST_ERROR);
        }
        
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("id", contentAttribute.getId());
        contentAttribute = contentAttributeApplication.findEntity(criteria);
        if (null == contentAttribute || null == contentAttribute.getId())
        {
            throw new UnifyException(SystemErrorNo.DATA_NOT_EXIST_ERROR);
        }
        mv.addObject(Keys.KEY_PARAM, contentAttribute);
        return mv;
    }
    
    @ResponseBody
    @RequestMapping("/edit/exec")
    public Result<?> doEdit(HttpServletRequest request, ContentAttribute contentAttribute)
    {
        Result<?> result = new Result<Object>();
        if (null != contentAttribute)
        {
            contentAttributeApplication.persistentEntity(contentAttribute);
            result.setResultCode(Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    @ResponseBody
    @RequestMapping("/delete/exec")
    public Result<?> doDelete(HttpServletRequest request, ContentAttribute contentAttribute)
    {
        Result<?> result = new Result<Object>();
        if (null != contentAttribute)
        {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("id", contentAttribute.getId());
            contentAttributeApplication.removeEntity(criteria);
            result.setResultCode(Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    class Views
    {
        
        public static final String INDEX_VIEW = "/contentAttribute/list";
        
        public static final String LIST_VIEW = "/contentAttribute/list";
        
        public static final String ADD_VIEW = "/contentAttribute/edit";
        
        public static final String EDIT_VIEW = "/contentAttribute/edit";
        
    }
    
}