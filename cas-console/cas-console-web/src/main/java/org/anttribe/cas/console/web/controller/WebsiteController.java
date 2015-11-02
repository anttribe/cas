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

import org.anttribe.cas.console.facade.WebsiteFacade;
import org.anttribe.cas.console.facade.dto.WebsiteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String index(HttpServletRequest request, WebsiteDTO websiteDTO)
    {
        return "/website/list";
    }
    
    @RequestMapping("/list")
    @ResponseBody
    public List<WebsiteDTO> listWebsites(HttpServletRequest request, WebsiteDTO websiteDTO)
    {
        return websiteFacade.listWebsites(websiteDTO);
    }
    
    @RequestMapping("/goAdd")
    public String goAddWebsite()
    {
        return "/website/edit";
    }
    
    @RequestMapping("/goEdit")
    public String goEditWebsite()
    {
        return "/website/edit";
    }
    
    @RequestMapping("/edit")
    public String doEditWebsite(HttpServletRequest request, WebsiteDTO websiteDTO)
    {
        if (null != websiteDTO)
        {
            websiteFacade.editWebsite(websiteDTO);
        }
        return "redirect:/website/index";
    }
    
    @RequestMapping("/delete")
    public String doDeleteWebsite(HttpServletRequest request, WebsiteDTO websiteDTO)
    {
        if (null != websiteDTO)
        {
            websiteFacade.deleteWebsite(websiteDTO);
        }
        return "redirect:/website/index";
    }
}