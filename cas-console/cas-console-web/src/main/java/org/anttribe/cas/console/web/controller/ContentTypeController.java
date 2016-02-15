/*
 * 文  件   名: ContentTypeController.java
 * 版         本 : cas-console-web.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月4日
 */
package org.anttribe.cas.console.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.anttribe.cas.base.infra.common.Result;
import org.anttribe.cas.base.infra.constants.Keys;
import org.anttribe.cas.base.infra.entity.Pagination;
import org.anttribe.cas.base.infra.errorno.ContentTypeErrorNo;
import org.anttribe.cas.console.facade.ContentTypeFacade;
import org.anttribe.cas.console.facade.dto.ContentTypeDTO;
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
    private ContentTypeFacade contentTypeFacade;
    
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, ModelAndView mv, ContentTypeDTO contentTypeDTO,
        Pagination pagination)
    {
        return this.list(request, mv, contentTypeDTO, pagination);
    }
    
    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, ModelAndView mv, ContentTypeDTO contentTypeDTO,
        Pagination pagination)
    {
        pagination = contentTypeFacade.listContentTypes(contentTypeDTO, pagination);
        
        mv.setViewName("/contentType/list");
        mv.addObject(Keys.KEY_PARAM, contentTypeDTO);
        mv.addObject(Keys.KEY_PAGE, pagination);
        if (null != pagination)
        {
            mv.addObject(Keys.KEY_PAGE_DATA, pagination.getDatas());
        }
        return mv;
    }
    
    @ResponseBody
    @RequestMapping("/list/exec")
    public List<ContentTypeDTO> list(HttpServletRequest request, ModelAndView mv, ContentTypeDTO contentTypeDTO)
    {
        return contentTypeFacade.listContentTypes(contentTypeDTO);
    }
    
    @RequestMapping("/add")
    public String goAddContentType()
    {
        return "/contentType/edit";
    }
    
    @RequestMapping("/edit")
    public String goEditContentType(HttpServletRequest request, ContentTypeDTO contentTypeDTO)
    {
        contentTypeDTO = contentTypeFacade.loadContentType(contentTypeDTO);
        if (null != contentTypeDTO)
        {
            request.setAttribute("contentType", contentTypeDTO);
            return "/contentType/edit";
        }
        return "redirect:/contentType/index";
    }
    
    @RequestMapping("/edit/exec")
    @ResponseBody
    public Result<?> doEditContentType(HttpServletRequest request, ContentTypeDTO contentTypeDTO)
    {
        Result<?> result = new Result<Object>();
        if (null != contentTypeDTO)
        {
            boolean validateResult = this.validateNameUnique(request, contentTypeDTO);
            if (!validateResult)
            {
                result.setResultCode(ContentTypeErrorNo.CONTENTTYPE_NAME_UNIQUE);
                return result;
            }
            validateResult = this.validateCodeUnique(request, contentTypeDTO);
            if (!validateResult)
            {
                result.setResultCode(ContentTypeErrorNo.CONTENTTYPE_CODE_UNIQUE);
                return result;
            }
            contentTypeFacade.saveOrUpdateWebsite(contentTypeDTO);
            result.setResultCode(org.anttribe.cas.base.infra.constants.Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    @RequestMapping("/delete/exec")
    @ResponseBody
    public Result<?> doDeleteContentType(HttpServletRequest request, ContentTypeDTO contentTypeDTO)
    {
        Result<?> result = new Result<Object>();
        if (null != contentTypeDTO)
        {
            contentTypeFacade.deleteContentType(contentTypeDTO);
            result.setResultCode(org.anttribe.cas.base.infra.constants.Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    @ResponseBody
    @RequestMapping("/validate/nameUnique")
    public boolean validateNameUnique(HttpServletRequest request, ContentTypeDTO contentTypeDTO)
    {
        if (null != contentTypeDTO && !StringUtils.isEmpty(contentTypeDTO.getName()))
        {
            return contentTypeFacade.validateNameUnique(contentTypeDTO);
        }
        return false;
    }
    
    @ResponseBody
    @RequestMapping("/validate/codeUnique")
    public boolean validateCodeUnique(HttpServletRequest request, ContentTypeDTO contentTypeDTO)
    {
        if (null != contentTypeDTO && !StringUtils.isEmpty(contentTypeDTO.getCode()))
        {
            return contentTypeFacade.validateCodeUnique(contentTypeDTO);
        }
        return false;
    }
}