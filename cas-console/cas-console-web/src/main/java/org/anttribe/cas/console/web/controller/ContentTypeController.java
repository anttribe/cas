/*
 * 文  件   名: ContentTypeController.java
 * 版         本 : cas-console-web.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月4日
 */
package org.anttribe.cas.console.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.anttribe.cas.base.application.IContentTypeApplication;
import org.anttribe.cas.base.core.entity.ContentType;
import org.anttribe.cas.base.infra.errorno.ContentTypeErrorNo;
import org.anttribe.vigor.infra.common.constants.Constants;
import org.anttribe.vigor.infra.common.constants.Keys;
import org.anttribe.vigor.infra.common.entity.Result;
import org.anttribe.vigor.infra.common.errorno.SystemErrorNo;
import org.anttribe.vigor.infra.common.exception.UnifyException;
import org.anttribe.vigor.infra.persist.entity.Pagination;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhaoyong
 * @version 2015年11月4日
 */
@Controller
@RequestMapping("/contentType")
public class ContentTypeController
{
    @Autowired
    private IContentTypeApplication contentTypeApplication;
    
    @RequestMapping({"", "/", "/index"})
    public ModelAndView index(HttpServletRequest request, ModelAndView mv, ContentType contentType,
        Pagination pagination)
    {
        return this.list(request, mv, contentType, pagination);
    }
    
    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, ModelAndView mv, ContentType contentType,
        Pagination pagination)
    {
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("name", contentType.getName());
        pagination = contentTypeApplication.listEntities(criteria, pagination);
        
        mv.setViewName(Views.LIST_VIEW);
        mv.addObject(Keys.KEY_PARAM, contentType);
        mv.addObject(Keys.KEY_PAGE, pagination);
        if (null != pagination)
        {
            mv.addObject(Keys.KEY_PAGE_DATA, pagination.getDatas());
        }
        return mv;
    }
    
    @ResponseBody
    @RequestMapping("/list/exec")
    public List<ContentType> doList(HttpServletRequest request, ModelAndView mv, ContentType contentType)
    {
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("name", contentType.getName());
        return contentTypeApplication.listEntities(criteria);
    }
    
    @RequestMapping("/add")
    public String add()
    {
        return Views.ADD_VIEW;
    }
    
    @RequestMapping("/edit")
    public ModelAndView edit(HttpServletRequest request, ModelAndView mv, ContentType contentType)
    {
        if (null == contentType || null == contentType.getId())
        {
            throw new UnifyException(SystemErrorNo.DATA_NOT_EXIST_ERROR);
        }
        
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("id", contentType.getId());
        contentType = contentTypeApplication.findEntity(criteria);
        if (null == contentType)
        {
            throw new UnifyException(SystemErrorNo.DATA_NOT_EXIST_ERROR);
        }
        
        mv.setViewName(Views.EDIT_VIEW);
        mv.addObject(Keys.KEY_PARAM, contentType);
        return mv;
    }
    
    @RequestMapping("/edit/exec")
    @ResponseBody
    public Result<?> doEdit(HttpServletRequest request, ContentType contentType)
    {
        Result<?> result = new Result<Object>();
        if (null != contentType)
        {
            boolean validateResult = this.validateNameUnique(request, contentType);
            if (!validateResult)
            {
                result.setResultCode(ContentTypeErrorNo.CONTENTTYPE_NAME_UNIQUE);
                return result;
            }
            validateResult = this.validateCodeUnique(request, contentType);
            if (!validateResult)
            {
                result.setResultCode(ContentTypeErrorNo.CONTENTTYPE_CODE_UNIQUE);
                return result;
            }
            
            contentTypeApplication.persistentEntity(contentType);
            result.setResultCode(Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    @RequestMapping("/delete/exec")
    @ResponseBody
    public Result<?> doDelete(HttpServletRequest request, ContentType contentType)
    {
        Result<?> result = new Result<Object>();
        if (null != contentType && null != contentType.getId())
        {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("id", contentType.getId());
            contentTypeApplication.removeEntity(criteria);
            result.setResultCode(Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    @ResponseBody
    @RequestMapping("/validate/nameUnique")
    public boolean validateNameUnique(HttpServletRequest request, ContentType contentType)
    {
        if (null != contentType && !StringUtils.isEmpty(contentType.getName()))
        {
            return contentTypeApplication.validateNameUnique(contentType);
        }
        return false;
    }
    
    @ResponseBody
    @RequestMapping("/validate/codeUnique")
    public boolean validateCodeUnique(HttpServletRequest request, ContentType contentType)
    {
        if (null != contentType && !StringUtils.isEmpty(contentType.getCode()))
        {
            return contentTypeApplication.validateCodeUnique(contentType);
        }
        return false;
    }
    
    class Views
    {
        
        public static final String INDEX_VIEW = "/contentType/list";
        
        public static final String LIST_VIEW = "/contentType/list";
        
        public static final String ADD_VIEW = "/contentType/edit";
        
        public static final String EDIT_VIEW = "/contentType/edit";
        
    }
    
}