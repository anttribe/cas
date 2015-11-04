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

import org.anttribe.cas.console.facade.ContentTypeFacade;
import org.anttribe.cas.console.facade.dto.ContentTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaoyong
 * @version 2015年11月4日
 */
@Controller
@RequestMapping("/content_type")
public class ContentTypeController
{
    @Autowired
    private ContentTypeFacade contentTypeFacade;
    
    @RequestMapping("/index")
    public String index(HttpServletRequest request, ContentTypeDTO contentTypeDTO)
    {
        return "/content_type/list";
    }
    
    @RequestMapping("/list")
    @ResponseBody
    public List<ContentTypeDTO> listContentTypes(HttpServletRequest request, ContentTypeDTO contentTypeDTO)
    {
        return contentTypeFacade.listContentTypes();
    }
    
    @RequestMapping("/goAdd")
    public String goAddContentType()
    {
        return "/content_type/edit";
    }
    
    @RequestMapping("/goEdit")
    public String goEditContentType()
    {
        return "/content_type/edit";
    }
    
    @RequestMapping("/edit")
    public String doEditContentType(HttpServletRequest request, ContentTypeDTO contentTypeDTO)
    {
        if (null != contentTypeDTO)
        {
            contentTypeFacade.editContentType(contentTypeDTO);
        }
        return "redirect:/content_type/index";
    }
    
    @RequestMapping("/delete")
    public String doDeleteContentType(HttpServletRequest request, ContentTypeDTO contentTypeDTO)
    {
        if (null != contentTypeDTO)
        {
            contentTypeFacade.deleteContentType(contentTypeDTO);
        }
        return "redirect:/content_type/index";
    }
}