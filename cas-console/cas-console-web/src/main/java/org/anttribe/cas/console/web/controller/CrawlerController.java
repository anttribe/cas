/*
 * 文  件   名: CrawlerController.java
 * 版         本 : (Anttribe).cas-console-web All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.console.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.anttribe.cas.console.facade.CrawlerFacade;
import org.anttribe.cas.console.facade.dto.CrawlerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaoyong
 * @version 2015年11月6日
 */
@Controller
@RequestMapping("/crawler")
public class CrawlerController
{
    @Autowired
    private CrawlerFacade crawlerFacade;
    
    @RequestMapping("/index")
    public String index(HttpServletRequest request)
    {
        return "/crawler/list";
    }
    
    @RequestMapping("/list")
    @ResponseBody
    public List<CrawlerDTO> listCrawlers(HttpServletRequest request, CrawlerDTO crawlerDTO)
    {
        return crawlerFacade.listCrawlers(crawlerDTO);
    }
    
    @RequestMapping("/goAdd")
    public String goAddCrawler()
    {
        return "/crawler/edit";
    }
    
    @RequestMapping("/goEdit")
    public String goEditCrawler()
    {
        return "/crawler/edit";
    }
    
    @RequestMapping("/edit")
    public String doEditCrawler(HttpServletRequest request, CrawlerDTO crawlerDTO)
    {
        if (null != crawlerDTO)
        {
            crawlerFacade.editCrawler(crawlerDTO);
        }
        return "redirect:/crawler/index";
    }
    
    @RequestMapping("/delete")
    public String doDeleteCrawler(HttpServletRequest request, CrawlerDTO crawlerDTO)
    {
        if (null != crawlerDTO)
        {
            crawlerFacade.deleteCrawler(crawlerDTO);
        }
        return "redirect:/crawler/index";
    }
}