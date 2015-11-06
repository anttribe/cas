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

import org.anttribe.cas.base.core.entity.Crawler;
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
    
}