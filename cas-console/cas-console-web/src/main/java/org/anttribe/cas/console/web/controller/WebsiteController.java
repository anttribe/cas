/*
 * 文  件   名: WebsiteController.java
 * 版         本 : (Anttribe).cas-console-web All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月31日
 */
package org.anttribe.cas.console.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.anttribe.cas.base.infra.common.Result;
import org.anttribe.cas.base.infra.constants.Keys;
import org.anttribe.cas.base.infra.entity.Pagination;
import org.anttribe.cas.base.infra.errorno.WebsiteErrorNo;
import org.anttribe.cas.console.facade.WebsiteFacade;
import org.anttribe.cas.console.facade.dto.WebsiteDTO;
import org.apache.commons.lang.StringUtils;
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
public class WebsiteController
{
    
    @Autowired
    private WebsiteFacade websiteFacade;
    
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, ModelAndView mv, WebsiteDTO websiteDTO, Pagination pagination)
    {
        return this.list(request, mv, websiteDTO, pagination);
    }
    
    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, ModelAndView mv, WebsiteDTO websiteDTO, Pagination pagination)
    {
        pagination = websiteFacade.listWebsites(websiteDTO, pagination);
        
        mv.setViewName("/website/list");
        mv.addObject(Keys.KEY_PARAM, websiteDTO);
        mv.addObject(Keys.KEY_PAGE, pagination);
        if (null != pagination)
        {
            mv.addObject(Keys.KEY_PAGE_DATA, pagination.getDatas());
        }
        return mv;
    }
    
    @ResponseBody
    @RequestMapping("/list/exec")
    public List<WebsiteDTO> doList(HttpServletRequest request, WebsiteDTO websiteDTO)
    {
        return this.websiteFacade.listWebsites(websiteDTO);
    }
    
    @RequestMapping("/load")
    @ResponseBody
    public WebsiteDTO loadWebsite(HttpServletRequest request, WebsiteDTO websiteDTO)
    {
        return websiteFacade.loadWebsite(websiteDTO);
    }
    
    @RequestMapping("/add")
    public String goAddWebsite()
    {
        return "/website/edit";
    }
    
    @RequestMapping("/edit")
    public String goEditWebsite(HttpServletRequest request, WebsiteDTO websiteDTO)
    {
        websiteDTO = websiteFacade.loadWebsite(websiteDTO);
        if (null != websiteDTO)
        {
            request.setAttribute("website", websiteDTO);
            return "/website/edit";
        }
        return "redirect:/category/index";
    }
    
    @ResponseBody
    @RequestMapping("/edit/exec")
    public Result<?> doEditWebsite(HttpServletRequest request, WebsiteDTO websiteDTO)
    {
        Result<?> result = new Result<Object>();
        if (null != websiteDTO)
        {
            boolean validateResult = this.validateNameUnique(request, websiteDTO);
            if (!validateResult)
            {
                result.setResultCode(WebsiteErrorNo.WEBSITE_NAME_UNIQUE);
                return result;
            }
            websiteFacade.saveOrUpdateWebsite(websiteDTO);
            result.setResultCode(org.anttribe.cas.base.infra.constants.Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    @ResponseBody
    @RequestMapping("/delete/exec")
    public Result<?> doDeleteWebsite(HttpServletRequest request, WebsiteDTO websiteDTO)
    {
        Result<?> result = new Result<Object>();
        if (null != websiteDTO)
        {
            websiteFacade.deleteWebsite(websiteDTO);
            result.setResultCode(org.anttribe.cas.base.infra.constants.Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    @ResponseBody
    @RequestMapping("/validate/nameUnique")
    public boolean validateNameUnique(HttpServletRequest request, WebsiteDTO websiteDTO)
    {
        if (null != websiteDTO && !StringUtils.isEmpty(websiteDTO.getSiteName()))
        {
            return this.websiteFacade.validateNameUnique(websiteDTO);
        }
        return false;
    }
}