/*
 * 文  件   名: CrawlerApplicationImpl.java
 * 版         本 : (Anttribe).cas-base-application All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.base.application.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.application.ICrawlerApplication;
import org.anttribe.cas.base.core.dao.ICrawlerDao;
import org.anttribe.cas.base.core.dao.ICrawlerRegularDao;
import org.anttribe.cas.base.core.entity.Crawler;
import org.anttribe.cas.base.core.entity.CrawlerRegular;
import org.anttribe.cas.base.core.type.CrawlerState;
import org.anttribe.cas.base.infra.constants.Constants;
import org.anttribe.vigor.infra.common.service.AbstractServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhaoyong
 * @version 2015年11月6日
 */
@Service
public class CrawlerApplicationImpl extends AbstractServiceImpl<ICrawlerDao, Crawler> implements ICrawlerApplication
{
    
    @Autowired
    private ICrawlerRegularDao crawlerRegularDao;
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void persistentEntity(Crawler crawler)
    {
        if (StringUtils.isEmpty(crawler.getCharset()))
        {
            crawler.setCharset(Constants.Crawler.DEFAULT_CHARSET);
        }
        // 处理默认属性值
        crawler.setIntervalTime(null != crawler.getIntervalTime() ? crawler.getIntervalTime()
            : Constants.Crawler.DEFAULT_PAGE_INTERVALTIME);
        crawler.setRetryTimes(
            null != crawler.getRetryTimes() ? crawler.getRetryTimes() : Constants.Crawler.DEFAULT_RETRYTIMES);
        crawler.setTimeout(null != crawler.getTimeout() ? crawler.getTimeout() : Constants.Crawler.DEFAULT_TIMEOUT);
        crawler.setCreateTime(new Date());
        if (null == crawler.getState())
        {
            // 设置默认初始状态
            crawler.setState(CrawlerState.INIT);
        }
        super.persistentEntity(crawler);
        
        // 持久化爬虫规则
        this.persistentCrawlerRagulars(crawler);
    }
    
    /**
     * 持久化爬虫规则
     * 
     * @param crawler
     */
    private void persistentCrawlerRagulars(Crawler crawler)
    {
        if (null != crawler && null != crawler.getId())
        {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("crawler", crawler);
            crawlerRegularDao.delete(criteria);
            
            List<CrawlerRegular> regulars = crawler.getRegulars();
            if (!CollectionUtils.isEmpty(regulars))
            {
                List<CrawlerRegular> tempRegulars = new ArrayList<CrawlerRegular>();
                for (CrawlerRegular regular : regulars)
                {
                    if (null == regular.getContentAttr())
                    {
                        continue;
                    }
                    regular.setCrawler(crawler);
                    tempRegulars.add(regular);
                }
                if (!CollectionUtils.isEmpty(tempRegulars))
                {
                    crawlerRegularDao.batchInsert(tempRegulars);
                }
            }
        }
    }
    
    @Override
    public boolean validateTitleUnique(Crawler crawler)
    {
        logger.debug("validate crawler's title unique, param: [{}]", crawler);
        
        if (null != crawler && !StringUtils.isEmpty(crawler.getTitle()))
        {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("notId", crawler.getId());
            criteria.put("uniqueTitle", crawler.getTitle());
            List<Crawler> crawlers = dao.find(criteria);
            if (CollectionUtils.isEmpty(crawlers))
            {
                return true;
            }
        }
        return false;
    }
    
}