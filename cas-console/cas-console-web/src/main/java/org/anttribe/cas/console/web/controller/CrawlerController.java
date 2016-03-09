/*
 * 文  件   名: CrawlerController.java
 * 版         本 : (Anttribe).cas-console-web All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.console.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.anttribe.cas.base.application.ICrawlerApplication;
import org.anttribe.cas.base.core.entity.Crawler;
import org.anttribe.cas.base.infra.errorno.CrawlerErrorNo;
import org.anttribe.vigor.infra.common.constants.Keys;
import org.anttribe.vigor.infra.common.entity.Result;
import org.anttribe.vigor.infra.persist.entity.Pagination;
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
    private ICrawlerApplication crawlerApplication;
    
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, ModelAndView mv, Crawler crawler, Pagination pagination)
    {
        return this.listCrawlers(request, mv, crawler, pagination);
    }
    
    @RequestMapping("/list")
    public ModelAndView listCrawlers(HttpServletRequest request, ModelAndView mv, Crawler crawler,
        Pagination pagination)
    {
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("contentType", crawler.getContentType());
        pagination = crawlerApplication.listEntities(criteria, pagination);
        
        mv.setViewName("/crawler/list");
        mv.addObject(Keys.KEY_PARAM, crawler);
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
    public Result<?> doEditCrawler(HttpServletRequest request, Crawler crawler)
    {
        Result<?> result = new Result<Object>();
        if (null != crawler)
        {
            boolean validateResult = this.validateTitleUnique(request, crawler);
            if (!validateResult)
            {
                result.setResultCode(CrawlerErrorNo.CRAWLER_TITLE_UNIQUE);
                return result;
            }
            crawlerApplication.persistentEntity(crawler);
            result.setResultCode(org.anttribe.cas.base.infra.constants.Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    @RequestMapping("/delete/exec")
    @ResponseBody
    public Result<?> doDeleteCrawler(HttpServletRequest request, Crawler crawler)
    {
        Result<?> result = new Result<Object>();
        if (null != crawler)
        {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("id", crawler.getId());
            crawlerApplication.removeEntity(criteria);
            result.setResultCode(org.anttribe.cas.base.infra.constants.Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    @RequestMapping("/validate/titleUnique")
    @ResponseBody
    public boolean validateTitleUnique(HttpServletRequest request, Crawler crawler)
    {
        if (null != crawler && !StringUtils.isEmpty(crawler.getTitle()))
        {
            return crawlerApplication.validateTitleUnique(crawler);
        }
        return false;
    }
}