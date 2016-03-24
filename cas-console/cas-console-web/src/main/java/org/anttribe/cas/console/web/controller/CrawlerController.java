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
import org.anttribe.cas.base.core.type.CrawlerState;
import org.anttribe.cas.base.infra.errorno.CrawlerErrorNo;
import org.anttribe.cas.base.runtime.SpiderManager;
import org.anttribe.vigor.infra.common.constants.Constants;
import org.anttribe.vigor.infra.common.constants.Keys;
import org.anttribe.vigor.infra.common.entity.Result;
import org.anttribe.vigor.infra.common.errorno.SystemErrorNo;
import org.anttribe.vigor.infra.common.exception.UnifyException;
import org.anttribe.vigor.infra.common.web.controller.AbstractController;
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
public class CrawlerController extends AbstractController
{
    @Autowired
    private ICrawlerApplication crawlerApplication;
    
    @Autowired
    private SpiderManager spiderManager;
    
    @RequestMapping({"", "/", "/index"})
    public ModelAndView index(HttpServletRequest request, ModelAndView mv, Crawler crawler, Pagination pagination)
    {
        return this.list(request, mv, crawler, pagination);
    }
    
    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, ModelAndView mv, Crawler crawler, Pagination pagination)
    {
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("contentType", crawler.getContentType());
        pagination = crawlerApplication.listEntities(criteria, pagination);
        
        mv.setViewName(Views.LIST_VIEW);
        mv.addObject(Keys.KEY_PARAM, crawler);
        mv.addObject(Keys.KEY_PAGE, pagination);
        if (null != pagination)
        {
            mv.addObject(Keys.KEY_PAGE_DATA, pagination.getDatas());
        }
        return mv;
    }
    
    @RequestMapping("/add")
    public String add()
    {
        return Views.ADD_VIEW;
    }
    
    @RequestMapping("/edit")
    public ModelAndView edit(HttpServletRequest request, ModelAndView mv, Crawler crawler)
    {
        if (null == crawler || null == crawler.getId())
        {
            throw new UnifyException(SystemErrorNo.DATA_NOT_EXIST_ERROR);
        }
        
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("id", crawler.getId());
        crawler = this.crawlerApplication.findEntity(criteria);
        if (null == crawler || null == crawler.getId())
        {
            throw new UnifyException(SystemErrorNo.DATA_NOT_EXIST_ERROR);
        }
        
        mv.setViewName(Views.EDIT_VIEW);
        mv.addObject(Keys.KEY_PARAM, crawler);
        
        return mv;
    }
    
    @RequestMapping("/edit/exec")
    @ResponseBody
    public Result<?> doEdit(HttpServletRequest request, Crawler crawler)
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
            // 添加爬虫
            spiderManager.addSpider(crawler);
            
            result.setResultCode(Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    @RequestMapping("/delete/exec")
    @ResponseBody
    public Result<?> doDelete(HttpServletRequest request, Crawler crawler)
    {
        Result<?> result = new Result<Object>();
        if (null != crawler)
        {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("id", crawler.getId());
            crawlerApplication.removeEntity(criteria);
            // 移除爬虫
            spiderManager.removeSprider(crawler);
            
            result.setResultCode(Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    @RequestMapping("/startup/exec")
    @ResponseBody
    public Result<?> doStartup(HttpServletRequest request, Crawler crawler)
    {
        Result<?> result = new Result<Object>();
        if (null != crawler)
        {
            // 启动爬虫
            boolean r = spiderManager.startSprider(crawler);
            if (r)
            {
                // 启动成功之后，更改爬虫状态
                crawler.setState(CrawlerState.RUNNING);
                crawlerApplication.persistentEntity(crawler);
                
                result.setResultCode(Constants.Common.DEFAULT_RESULT_CODE);
                return result;
            }
            result.setResultCode(CrawlerErrorNo.CRAWLER_STARTUP_ERROR);
        }
        return result;
    }
    
    @RequestMapping("/stop/exec")
    @ResponseBody
    public Result<?> doStop(HttpServletRequest request, Crawler crawler)
    {
        Result<?> result = new Result<Object>();
        if (null != crawler)
        {
            // 停止爬虫
            boolean r = spiderManager.stopSprider(crawler);
            if (r)
            {
                // 停止成功之后，更改爬虫状态
                crawler.setState(CrawlerState.STOP);
                crawlerApplication.persistentEntity(crawler);
                
                result.setResultCode(Constants.Common.DEFAULT_RESULT_CODE);
                
                return result;
            }
            result.setResultCode(CrawlerErrorNo.CRAWLER_STOP_ERROR);
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
    
    class Views
    {
        
        public static final String INDEX_VIEW = "/crawler/list";
        
        public static final String LIST_VIEW = "/crawler/list";
        
        public static final String ADD_VIEW = "/crawler/edit";
        
        public static final String EDIT_VIEW = "/crawler/edit";
        
    }
}