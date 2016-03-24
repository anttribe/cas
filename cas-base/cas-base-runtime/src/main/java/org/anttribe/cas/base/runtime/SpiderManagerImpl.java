/*
 * 文  件   名: SpiderManagerImpl.java
 * 版         本 : cas-base-runtime © 2016 Anttribe. All rights reserved.
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2016年3月19日
 */
package org.anttribe.cas.base.runtime;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.anttribe.cas.base.application.ICrawlerApplication;
import org.anttribe.cas.base.core.entity.Crawler;
import org.anttribe.cas.base.runtime.pipeline.ContentPipeline;
import org.anttribe.cas.base.runtime.processor.ContentPageProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.codecraft.webmagic.Spider;

/**
 * @author zhaoyong
 * @version 2016年3月19日
 */
@Service
public class SpiderManagerImpl implements SpiderManager
{
    private static Logger logger = LoggerFactory.getLogger(SpiderManager.class);
    
    private static ConcurrentHashMap<String, Spider> spiders = new ConcurrentHashMap<String, Spider>();
    
    /**
     * 默认线程数
     */
    public static final int DEFAULT_THREAD_NUM = 5;
    
    /**
     * 爬虫使用线程数
     */
    private int threadNum = DEFAULT_THREAD_NUM;
    
    @Autowired
    private ICrawlerApplication crawlerApplication;
    
    @Override
    public void addSpider(Crawler crawler)
    {
        logger.debug("Adding sprider with crawler {}", crawler);
        
        if (null != crawler && null != crawler.getId())
        {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("id", crawler.getId());
            crawler = crawlerApplication.findEntity(criteria);
            if (null != crawler)
            {
                Spider spider = Spider.create(new ContentPageProcessor(crawler))
                    .addUrl(crawler.getCrawlerUrl())
                    .addPipeline(new ContentPipeline())
                    .thread(this.getThreadNum());
                spiders.put(String.valueOf(crawler.getId()), spider);
            }
        }
    }
    
    @Override
    public void removeSprider(Crawler crawler)
    {
        logger.debug("Removing sprider with crawler {}", crawler);
        
        if (null != crawler && null != crawler.getId())
        {
            Spider spider = spiders.get(String.valueOf(crawler.getId()));
            if (null == spider)
            {
                logger.warn("Spider with crawler {} not exist", crawler);
                return;
            }
            spider.close();
        }
    }
    
    @Override
    public boolean startSprider(Crawler crawler)
    {
        logger.debug("Starting sprider with crawler {}", crawler);
        
        if (null != crawler && null != crawler.getId())
        {
            Spider spider = spiders.get(String.valueOf(crawler.getId()));
            if (null == spider)
            {
                logger.warn("Spider with crawler {} not exist", crawler);
                this.addSpider(crawler);
            }
            spider = spiders.get(String.valueOf(crawler.getId()));
            if (null != spider)
            {
                spider.start();
            }
            
            return true;
        }
        return false;
    }
    
    @Override
    public boolean stopSprider(Crawler crawler)
    {
        logger.debug("Removing sprider with crawler {}", crawler);
        
        if (null != crawler && null != crawler.getId())
        {
            Spider spider = spiders.get(String.valueOf(crawler.getId()));
            if (null == spider)
            {
                logger.warn("Spider with crawler {} not exist", crawler);
            }
            else
            {
                spider.stop();
                return true;
            }
            return false;
        }
        return false;
    }
    
    public int getThreadNum()
    {
        return threadNum;
    }
    
    public void setThreadNum(int threadNum)
    {
        this.threadNum = threadNum;
    }
}