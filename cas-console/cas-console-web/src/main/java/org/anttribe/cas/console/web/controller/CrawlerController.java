/*
 * 文  件   名: CrawlerController.java
 * 版         本 : (Anttribe).cas-console-web All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.console.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.anttribe.cas.base.infra.common.Result;
import org.anttribe.cas.base.infra.constants.Keys;
import org.anttribe.cas.base.infra.entity.Pagination;
import org.anttribe.cas.base.infra.errorno.CrawlerErrorNo;
import org.anttribe.cas.console.facade.CrawlerFacade;
import org.anttribe.cas.console.facade.dto.CrawlerDTO;
import org.apache.commons.lang.StringUtils;
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
@RequestMapping("/crawler")
public class CrawlerController
{
    @Autowired
    private CrawlerFacade crawlerFacade;
    
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, ModelAndView mv, CrawlerDTO crawlerDTO, Pagination pagination)
    {
        return this.listCrawlers(request, mv, crawlerDTO, pagination);
    }
    
    @RequestMapping("/list")
    public ModelAndView listCrawlers(HttpServletRequest request, ModelAndView mv, CrawlerDTO crawlerDTO,
        Pagination pagination)
    {
        pagination = crawlerFacade.listCrawlers(crawlerDTO, pagination);
        
        mv.setViewName("/crawler/list");
        mv.addObject(Keys.KEY_PARAM, crawlerDTO);
        mv.addObject(Keys.KEY_PAGE, pagination);
        if (null != pagination)
        {
            mv.addObject(Keys.KEY_PAGE_DATA, pagination.getDatas());
        }
        return mv;
    }
    
    @RequestMapping("/add")
    public String goAddCrawler()
    {
        return "/crawler/edit";
    }
    
    @RequestMapping("/edit")
    public String goEditCrawler()
    {
        return "/crawler/edit";
    }
    
    @RequestMapping("/edit/exec")
    @ResponseBody
    public Result<?> doEditCrawler(HttpServletRequest request, CrawlerDTO crawlerDTO)
    {
        Result<?> result = new Result<Object>();
        if (null != crawlerDTO)
        {
            boolean validateResult = this.validateTitleUnique(request, crawlerDTO);
            if (!validateResult)
            {
                result.setResultCode(CrawlerErrorNo.CRAWLER_TITLE_UNIQUE);
                return result;
            }
            crawlerFacade.editCrawler(crawlerDTO);
            result.setResultCode(org.anttribe.cas.base.infra.constants.Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    @RequestMapping("/delete/exec")
    @ResponseBody
    public Result<?> doDeleteCrawler(HttpServletRequest request, CrawlerDTO crawlerDTO)
    {
        Result<?> result = new Result<Object>();
        if (null != crawlerDTO)
        {
            crawlerFacade.deleteCrawler(crawlerDTO);
            result.setResultCode(org.anttribe.cas.base.infra.constants.Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    @RequestMapping("/validate/titleUnique")
    @ResponseBody
    public boolean validateTitleUnique(HttpServletRequest request, CrawlerDTO crawlerDTO)
    {
        if (null != crawlerDTO && !StringUtils.isEmpty(crawlerDTO.getTitle()))
        {
            return crawlerFacade.validateTitleUnique(crawlerDTO);
        }
        return false;
    }
}