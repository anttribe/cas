/*
 * 文  件   名: CrawlerApplicationImpl.java
 * 版         本 : (Anttribe).cas-base-application All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.base.application.impl;

import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.core.constants.Constants;
import org.anttribe.cas.base.core.entity.Crawler;
import org.anttribe.cas.base.core.entity.CrawlerContentRegular;
import org.anttribe.cas.base.core.errorno.SystemErrorNo;
import org.anttribe.cas.base.core.exception.UnifyException;
import org.anttribe.component.lang.UUIDUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
        return Crawler.find(Crawler.class, criteria);
    }
    
    @Override
    public void persistentCrawler(Crawler crawler)
    {
        logger.debug("persistenting crawler to DB, param: [{}]", crawler);
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
        
        if (StringUtils.isEmpty(crawler.getId()))
        {
            crawler.setId(UUIDUtils.getRandomUUID());
            crawler.save();
            logger.debug("crawler id not there, then save new crawler to DB, crawler: {}", crawler.getId());
            
            this.persistentCrawlerContentRegulars(crawler);
            return;
        }
        
        Crawler tempCrawler = Crawler.load(Crawler.class, crawler.getId());
        if (null == tempCrawler)
        {
            crawler.save();
            logger.debug("crawler not exist in DB, then save new crawler to DB, crawler: {}", crawler.getId());
            
            this.persistentCrawlerContentRegulars(crawler);
            return;
        }
        crawler.update();
        logger.debug("crawler exist in DB, then update crawler info, crawler: {}", crawler.getId());
        
        this.persistentCrawlerContentRegulars(crawler);
    }
    
    /**
     * 持久化处理爬虫上的内容属性规则数据
     * 
     * @param crawler Crawler
     */
    private void persistentCrawlerContentRegulars(Crawler crawler)
    {
        // 删除数据库中保存的内容属性规则
        CrawlerContentRegular.removeByCrawler(crawler);
        // 保存内容属性
        List<CrawlerContentRegular> regulars = crawler.getRegulars();
        if (!CollectionUtils.isEmpty(regulars))
        {
            CrawlerContentRegular.batchSave(CrawlerContentRegular.class, regulars);
            logger.debug("save regulars to DB, regulars: {}", regulars);
        }
    }
    
    @Override
    public void deleteCrawler(Crawler crawler)
    {
        logger.debug("deleting crawler from DB, param: [{}]", crawler);
        
        if (null != crawler)
        {
            crawler.remove();
            
            // 删除内容属性规则
            CrawlerContentRegular.removeByCrawler(crawler);
        }
    }
    
}