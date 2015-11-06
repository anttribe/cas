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

import org.anttribe.cas.console.facade.ContentAttributeFacade;
import org.anttribe.cas.console.facade.dto.ContentAttributeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String index(HttpServletRequest request)
    {
        return "/content_attribute/list";
    }
    
    @RequestMapping("/list")
    @ResponseBody
    public List<ContentAttributeDTO> listCategories(HttpServletRequest request, ContentAttributeDTO contentAttributeDTO)
    {
        return contentAttributeFacade.listContentAttributes(contentAttributeDTO);
    }
    
    @RequestMapping("/goAdd")
    public String goAddContentAttribute()
    {
        return "/content_attribute/edit";
    }
    
    @RequestMapping("/goEdit")
    public String goEditContentAttribute()
    {
        return "/content_attribute/edit";
    }
    
    @RequestMapping("/edit")
    public String doEditContentAttribute(HttpServletRequest request, ContentAttributeDTO contentAttributeDTO)
    {
        if (null != contentAttributeDTO)
        {
            contentAttributeFacade.editContentAttribute(contentAttributeDTO);
        }
        return "redirect:/contentAttribute/index";
    }
    
    @RequestMapping("/delete")
    public String doDeleteContentAttribute(HttpServletRequest request, ContentAttributeDTO contentAttributeDTO)
    {
        if (null != contentAttributeDTO)
        {
            contentAttributeFacade.deleteContentAttribute(contentAttributeDTO);
        }
        return "redirect:/contentAttribute/index";
    }
}