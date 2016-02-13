/*
 * 文  件   名: CrawlerApplicationImpl.java
 * 版         本 : (Anttribe).cas-base-application All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.base.application.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.core.entity.Crawler;
import org.anttribe.cas.base.core.entity.CrawlerRegular;
import org.anttribe.cas.base.core.type.CrawlerState;
import org.anttribe.cas.base.infra.constants.Constants;
import org.anttribe.cas.base.infra.entity.Pagination;
import org.anttribe.cas.base.infra.errorno.SystemErrorNo;
import org.anttribe.cas.base.infra.exception.UnifyException;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyong
 * @version 2015年11月6日
 */
@Service
public class CrawlerApplicationImpl implements org.anttribe.cas.base.application.CrawlerApplication
{
    
    private static Logger logger = LoggerFactory.getLogger(CrawlerApplicationImpl.class);
    
    @Override
    public List<Crawler> listCrawlers(Map<String, Object> criteria)
    {
        logger.debug("listing crawlers refer to criteria, param: [{}]", criteria);
        if (null == criteria)
        {
            criteria = new HashMap<String, Object>();
        }
        return Crawler.find(Crawler.class, criteria);
    }
    
    @Override
    public Pagination listCrawlers(Map<String, Object> criteria, Pagination pagination)
    {
        logger.debug("listing Crawlers refer to criteria and pagination, param: criteria[{}], pagination[{}]",
            criteria,
            pagination);
            
        if (null == criteria)
        {
            criteria = new HashMap<String, Object>();
        }
        List<Crawler> tempCrawlers = Crawler.find(Crawler.class, criteria, pagination);
        int totalCount = Crawler.count(Crawler.class, criteria);
        if (null == pagination)
        {
            pagination = new Pagination();
        }
        pagination.setTotalRecords(totalCount);
        pagination.setDatas(tempCrawlers);
        
        return pagination;
    }
    
    @Override
    public Crawler findCrawler(Map<String, Object> criteria)
    {
        logger.debug("find Crawler refer to criteria, param: criteria[{}]", criteria);
        
        if (null == criteria)
        {
            // 参数错误
            return null;
        }
        
        List<Crawler> tempCrawlers = Crawler.find(Crawler.class, criteria);
        if (!CollectionUtils.isEmpty(tempCrawlers))
        {
            return tempCrawlers.get(0);
        }
        return null;
    }
    
    @Override
    public void persistentCrawler(Crawler crawler)
    {
        logger.debug("persistenting crawler to DB, param: [{}]", crawler);
        // 参数校验
        if (null == crawler)
        {
            logger.warn("persistenting crawler to DB, param crawler is null.");
            throw new UnifyException(SystemErrorNo.PARAMETER_IS_NULL);
        }
        if (null == crawler.getWebsite() || null == crawler.getContentType())
        {
            logger.warn("persistenting crawler to DB, param crawler's website or contentType is null.");
            throw new UnifyException(SystemErrorNo.PARAMETER_LOGIC_ERROR);
        }
        
        // 处理默认属性值
        crawler.setIntervalTime(null != crawler.getIntervalTime() ? crawler.getIntervalTime()
            : Constants.Crawler.DEFAULT_PAGE_INTERVALTIME);
        crawler.setRetryTimes(
            null != crawler.getRetryTimes() ? crawler.getRetryTimes() : Constants.Crawler.DEFAULT_RETRYTIMES);
        crawler.setTimeout(null != crawler.getTimeout() ? crawler.getTimeout() : Constants.Crawler.DEFAULT_TIMEOUT);
        
        if (null == crawler.getId())
        {
            crawler.setCreateTime(new Date());
            // 设置默认初始状态
            crawler.setState(CrawlerState.INIT);
            crawler.save();
            logger.debug("crawler id not there, then save new crawler to DB, crawler: {}", crawler.getId());
            this.persistentCrawlerRegulars(crawler);
            return;
        }
        
        Crawler tempCrawler = Crawler.load(Crawler.class, crawler.getId());
        if (null == tempCrawler)
        {
            crawler.setCreateTime(new Date());
            // 设置默认初始状态
            crawler.setState(CrawlerState.INIT);
            crawler.save();
            logger.debug("crawler not exist in DB, then save new crawler to DB, crawler: {}", crawler.getId());
            this.persistentCrawlerRegulars(crawler);
            return;
        }
        crawler.update();
        logger.debug("crawler exist in DB, then update crawler info, crawler: {}", crawler.getId());
        
        this.persistentCrawlerRegulars(crawler);
    }
    
    /**
     * 持久化处理爬虫上的内容属性规则数据
     * 
     * @param crawler Crawler
     */
    private void persistentCrawlerRegulars(Crawler crawler)
    {
        // 删除数据库中保存的内容属性规则
        CrawlerRegular deleteRegular = new CrawlerRegular();
        deleteRegular.setCrawler(crawler);
        deleteRegular.remove();
        // 保存爬虫内容属性规则
        List<CrawlerRegular> regulars = crawler.getRegulars();
        if (!CollectionUtils.isEmpty(regulars))
        {
            for (CrawlerRegular regular : regulars)
            {
                regular.setCrawler(crawler);
            }
            CrawlerRegular.batchSave(CrawlerRegular.class, regulars);
            
            logger.debug("save regulars to DB, regulars: {}", regulars);
        }
    }
    
    @Override
    public void deleteCrawler(Crawler crawler)
    {
        logger.debug("deleting crawler from DB, param: [{}]", crawler);
        
        if (null != crawler)
        {
            // 删除内容属性规则
            CrawlerRegular deleteRegular = new CrawlerRegular();
            deleteRegular.setCrawler(crawler);
            deleteRegular.remove();
            
            crawler.remove();
        }
    }
    
}