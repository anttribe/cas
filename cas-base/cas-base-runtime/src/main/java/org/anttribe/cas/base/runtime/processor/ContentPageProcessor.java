/*
 * 文  件   名: ContentPageProcessor.java
 * 版         本 : cas-base-runtime © 2016 Anttribe. All rights reserved.
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2016年3月18日
 */
package org.anttribe.cas.base.runtime.processor;

import java.util.List;

import org.anttribe.cas.base.core.entity.ContentAttribute;
import org.anttribe.cas.base.core.entity.Crawler;
import org.anttribe.cas.base.core.entity.CrawlerConstantRegular;
import org.anttribe.cas.base.core.entity.CrawlerRegular;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;
import us.codecraft.webmagic.utils.UrlUtils;

/**
 * @author zhaoyong
 * @version 2016年3月18日
 */
public class ContentPageProcessor implements PageProcessor
{
    
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ContentPageProcessor.class);
    
    private Crawler crawler;
    
    public ContentPageProcessor(Crawler crawler)
    {
        if (null == crawler || StringUtils.isEmpty(crawler.getCrawlerUrl()))
        {
            logger.error("Creating new ContentPageProcessor, crawler is null or the crawlerUrl is empty.");
            // 初始化异常
            throw new ExceptionInInitializerError(
                "Creating new ContentPageProcessor, crawler is null or the crawlerUrl is empty.");
        }
        this.crawler = crawler;
    }
    
    @Override
    public Site getSite()
    {
        return Site.me()
            .setDomain(UrlUtils.getDomain(this.crawler.getCrawlerUrl()))
            .setUserAgent(this.crawler.getUserAgent())
            .setRetryTimes(this.crawler.getRetryTimes())
            .setCharset(this.crawler.getCharset())
            .setSleepTime(this.crawler.getIntervalTime())
            .setTimeOut(this.crawler.getTimeout());
    }
    
    @Override
    public void process(Page page)
    {
        List<CrawlerRegular> regulars = this.crawler.getRegulars();
        if (!CollectionUtils.isEmpty(regulars))
        {
            Selectable selector = this.buildContentLinkSelectable(this.crawler, page);
            page.addTargetRequests(selector.all());
            
            String link = page.getUrl().toString();
            // 内容属性值
            for (CrawlerRegular regular : regulars)
            {
                ContentAttribute attribute = regular.getContentAttr();
                String attrRegular = regular.getAttrRegular();
                if (null == attribute || StringUtils.isEmpty(attrRegular))
                {
                    continue;
                }
                page.putField(String.valueOf(attribute.getId()), page.getHtml().xpath(attrRegular).toString());
            }
            page.putField("link", link);
            page.putField("website", this.crawler.getWebsite());
            
            logger.debug("Processing page with page url: {}, result: {}", page.getResultItems());
        }
    }
    
    /**
     * 构造处理内容链接选择器
     * 
     * @param crawler
     * @return
     */
    private Selectable buildContentLinkSelectable(Crawler crawler, Page page)
    {
        CrawlerConstantRegular constantRegular = crawler.getConstantRegular();
        
        Selectable selector = page.getHtml();
        if (null != constantRegular && !StringUtils.isEmpty(constantRegular.getContentsRegular()))
        {
            selector = selector.xpath(constantRegular.getContentsRegular());
        }
        selector = selector.links();
        if (null != constantRegular && !StringUtils.isEmpty(constantRegular.getContentLinkRegex()))
        {
            selector.regex(constantRegular.getContentLinkRegex());
        }
        return selector;
    }
    
}