/*
 * 文  件   名: ContentCrawlJob.java
 * 版         本: cas-cis-runtime(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月22日
 */
package org.anttribe.cas.cis.runtime.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
     * 执行任务
     */
    public void execute()
    {
        logger.debug("Start executing ContentCrawlJob to crawling content.");
    }
}