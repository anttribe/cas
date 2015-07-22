/*
 * 文  件   名: ContentPageProcessor.java
 * 版         本: cas-cis-runtime(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月22日
 */
package org.anttribe.cas.cis.runtime.processor;

import java.util.ArrayList;
import java.util.List;

import org.anttribe.cas.base.core.entity.ContentAttrXPath;
import org.anttribe.cas.base.core.entity.Website;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.UrlUtils;

/**
 * @author zhaoyong
 * @version 2015年7月22日
 */
public class ContentPageProcessor implements PageProcessor
{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ContentPageProcessor.class);
    
    /**
     * web网站实体对象
     */
    private Website website;
    
    /**
     * 内容属性xpath
     */
    private ContentAttrXPath contentAttrXPath;
    
    /**
     * <默认构造器>
     * 
     * @param website
     */
    public ContentPageProcessor(Website website)
    {
        if (null == website || StringUtils.isEmpty(website.getDomain()))
        {
            logger.error("Creating new ContentPageProcessor, website is null or the domain is empty.");
            // 初始化异常
            throw new ExceptionInInitializerError(
                "Creating new ContentPageProcessor, website is null or the domain is empty.");
        }
        this.website = website;
        this.contentAttrXPath = null;
    }
    
    @Override
    public void process(Page page)
    {
        if (null != contentAttrXPath && !StringUtils.isEmpty(contentAttrXPath.getContentsXpath()))
        {
            this.processTargetRequests(page);
            
            String link = page.getUrl().toString();
            String title = page.getHtml().xpath(contentAttrXPath.getTitleXpath()).toString();
            if (StringUtils.isEmpty(title))
            {
                page.setSkip(true);
                return;
            }
        }
    }
    
    /**
     * 从当前页面中处理需要爬取的目标链接
     * 
     * @param page Page
     */
    private void processTargetRequests(Page page)
    {
        List<String> acceptLinks = new ArrayList<String>();
        // 页面上所有链接
        List<String> links =
            page.getHtml()
                .xpath(this.contentAttrXPath.getContentsXpath())
                .links()
                .regex(this.contentAttrXPath.getLinkXpath())
                .all();
        if (!CollectionUtils.isEmpty(links))
        {
            for (String link : links)
            {
                acceptLinks.add(link);
            }
        }
        
        logger.debug("Target request urls: " + acceptLinks);
        
        if (!CollectionUtils.isEmpty(acceptLinks))
        {
            page.addTargetRequests(acceptLinks);
        }
    }
    
    @Override
    public Site getSite()
    {
        return Site.me()
            .setDomain(UrlUtils.getDomain(this.website.getDomain()))
            .setUserAgent(this.website.getUserAgent())
            .setRetryTimes(this.website.getRetryTimes())
            .setCharset(this.website.getCharset())
            .setSleepTime(this.website.getIntervalTime())
            .setTimeOut(this.website.getTimeout());
    }
}