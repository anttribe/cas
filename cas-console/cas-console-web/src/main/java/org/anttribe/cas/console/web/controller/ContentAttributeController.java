/*
 * 文  件   名: ContentAttributeController.java
 * 版         本 : (Anttribe).cas-console-web All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.console.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.anttribe.cas.base.infra.common.Result;
import org.anttribe.cas.base.infra.constants.Keys;
import org.anttribe.cas.base.infra.entity.Pagination;
import org.anttribe.cas.console.facade.ContentAttributeFacade;
import org.anttribe.cas.console.facade.dto.ContentAttributeDTO;
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
    private ContentAttributeFacade contentAttributeFacade;
    
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, ModelAndView mv, ContentAttributeDTO contentAttributeDTO,
        Pagination pagination)
    {
        return this.list(request, mv, contentAttributeDTO, pagination);
    }
    
    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, ModelAndView mv, ContentAttributeDTO contentAttributeDTO,
        Pagination pagination)
    {
        pagination = contentAttributeFacade.listContentAttributes(contentAttributeDTO, pagination);
        
        mv.setViewName("/contentAttribute/list");
        mv.addObject(Keys.KEY_PARAM, contentAttributeDTO);
        mv.addObject(Keys.KEY_PAGE, pagination);
        if (null != pagination)
        {
            mv.addObject(Keys.KEY_PAGE_DATA, pagination.getDatas());
        }
        return mv;
    }
    
    @RequestMapping("/list/exec")
    @ResponseBody
    public List<ContentAttributeDTO> doList(HttpServletRequest request, ContentAttributeDTO contentAttributeDTO)
    {
        return  contentAttributeFacade.listContentAttributes(contentAttributeDTO);
    }
    
    @RequestMapping("/add")
    public String goAddContentAttribute()
    {
        return "/contentAttribute/edit";
    }
    
    @RequestMapping("/edit")
    public String goEditContentAttribute(HttpServletRequest request, ContentAttributeDTO contentAttributeDTO)
    {
        contentAttributeDTO = contentAttributeFacade.loadContentAttribute(contentAttributeDTO);
        if (null != contentAttributeDTO)
        {
            request.setAttribute("contentAttribute", contentAttributeDTO);
            return "/contentAttribute/edit";
        }
        return "redirect:/contentAttribute/index";
    }
    
    @ResponseBody
    @RequestMapping("/edit/exec")
    public Result<?> doEditContentAttribute(HttpServletRequest request, ContentAttributeDTO contentAttributeDTO)
    {
        Result<?> result = new Result<Object>();
        if (null != contentAttributeDTO)
        {
            contentAttributeFacade.editContentAttribute(contentAttributeDTO);
            result.setResultCode(org.anttribe.cas.base.infra.constants.Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    @ResponseBody
    @RequestMapping("/delete/exec")
    public Result<?> doDeleteContentAttribute(HttpServletRequest request, ContentAttributeDTO contentAttributeDTO)
    {
        Result<?> result = new Result<Object>();
        if (null != contentAttributeDTO)
        {
            contentAttributeFacade.deleteContentAttribute(contentAttributeDTO);
            result.setResultCode(org.anttribe.cas.base.infra.constants.Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
}