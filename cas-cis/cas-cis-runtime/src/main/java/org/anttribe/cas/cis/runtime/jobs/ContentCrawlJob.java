/*
 * 文  件   名: ContentCrawlJob.java
 * 版         本: cas-cis-runtime(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月22日
 */
package org.anttribe.cas.cis.runtime.jobs;

import java.util.List;

import org.anttribe.cas.base.application.WebsiteApplication;
import org.anttribe.cas.base.core.entity.Website;
import org.anttribe.cas.cis.runtime.pipeline.ContentPersistentPipeline;
import org.anttribe.cas.cis.runtime.processor.ContentPageProcessor;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import us.codecraft.webmagic.Spider;

/**
 * 内容抓取任务
 * 
 * @author zhaoyong
 * @version 2015年7月22日
 */
public class ContentCrawlJob
{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ContentCrawlJob.class);
    
    /**
     * 默认线程数
     */
    public static final int DEFAULT_THREAD_NUM = 5;
    
    /**
     * websiteApplication
     */
    @Autowired
    private WebsiteApplication websiteApplication;
    
    /**
     * 爬虫使用线程数
     */
    private int threadNum = DEFAULT_THREAD_NUM;
    
    /**
     * 执行任务
     */
    public void execute()
    {
        logger.debug("Start executing ContentCrawlJob to crawling content.");
        
        List<Website> websites = websiteApplication.listAvailableWebsites();
        if (!CollectionUtils.isEmpty(websites))
        {
            for (Website website : websites)
            {
                Spider.create(new ContentPageProcessor(website))
                    .addUrl(website.getDomain())
                    .addPipeline(new ContentPersistentPipeline())
                    .thread(this.getThreadNum())
                    .run();
            }
        }
    }
    
    public int getThreadNum()
    {
        if (threadNum <= 0)
        {
            threadNum = DEFAULT_THREAD_NUM;
        }
        return threadNum;
    }
    
    public void setThreadNum(int threadNum)
    {
        this.threadNum = threadNum;
    }
}