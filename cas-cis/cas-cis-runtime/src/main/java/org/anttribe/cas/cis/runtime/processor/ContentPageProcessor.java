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

import org.anttribe.cas.base.application.ContentAttrXPathApplication;
import org.anttribe.cas.base.core.entity.CrawlerContentRegular;
import org.anttribe.cas.base.core.entity.Website;
import org.anttribe.cas.cis.runtime.constants.Constants;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.dayatang.domain.InstanceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

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
     * redisTemplate
     */
    @Autowired
    @SuppressWarnings("unchecked")
    private RedisTemplate<String, Object> redisTemplate = InstanceFactory.getInstance(RedisTemplate.class);;
    
    /**
     * contentAttrXPathApplication
     */
    @Autowired
    private ContentAttrXPathApplication contentAttrXPathApplication =
        InstanceFactory.getInstance(ContentAttrXPathApplication.class);
    
    /**
     * web网站实体对象
     */
    private Website website;
    
    /**
     * 内容属性xpath
     */
    private CrawlerContentRegular contentAttrXPath;
    
    /**
     * <默认构造器>
     * 
     * @param website Website
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
        this.contentAttrXPath = contentAttrXPathApplication.getContentAttrXPathByWebsite(website);
    }
    
    @Override
    public void process(Page page)
    {
//        if (null != contentAttrXPath && !StringUtils.isEmpty(contentAttrXPath.getContentsXpath()))
//        {
//            this.processTargetRequests(page);
//            
//            String link = page.getUrl().toString();
//            String title = page.getHtml().xpath(contentAttrXPath.getTitleXpath()).toString();
//            String redis_title = title + "_" + "";
//            // 如果标题不存在，或者在redis中已经存在相同的标题名，则不处理
//            if (StringUtils.isEmpty(title)
//                || redisTemplate.opsForSet().isMember(Constants.REDIS_KEY_CRAWL_CONTENT_TITLES, redis_title))
//            {
//                page.setSkip(true);
//                return;
//            }
//            
//            // 将内容title放入redis数据中
//            redisTemplate.opsForSet().add(Constants.REDIS_KEY_CRAWL_CONTENT_TITLES, redis_title);
//            
//            page.putField("title", title);
//            page.putField("content", page.getHtml().xpath(contentAttrXPath.getContentXpath()).toString());
//            page.putField("thumbnail", page.getHtml().xpath(contentAttrXPath.getThumbnailXpath()).toString());
//            page.putField("publishTime", page.getHtml().xpath(contentAttrXPath.getPublishTimeXpath()).toString());
//            page.putField("author", page.getHtml().xpath(contentAttrXPath.getAuthorXpath()).toString());
//            page.putField("link", link);
//            page.putField("website", this.website);
//        }
    }
    
    /**
     * 从当前页面中处理需要爬取的目标链接
     * 
     * @param page Page
     */
    private void processTargetRequests(Page page)
    {
//        List<String> acceptLinks = new ArrayList<String>();
//        // 页面上所有内容链接
//        List<String> links =
//            page.getHtml()
//                .xpath(this.contentAttrXPath.getContentsXpath())
//                .links()
//                .regex(this.contentAttrXPath.getLinkXpath())
//                .all();
//        if (!CollectionUtils.isEmpty(links))
//        {
//            SetOperations<String, Object> set = redisTemplate.opsForSet();
//            for (String link : links)
//            {
//                // 排除重复的链接
//                if (set.isMember(Constants.REDIS_KEY_CRAWL_TARGET_URLS, link))
//                {
//                    continue;
//                }
//                acceptLinks.add(link);
//                
//                set.add(Constants.REDIS_KEY_CRAWL_TARGET_URLS, link);
//            }
//        }
//        
//        logger.debug("Adding target request urls to fetch: " + acceptLinks);
//        if (!CollectionUtils.isEmpty(acceptLinks))
//        {
//            page.addTargetRequests(acceptLinks);
//        }
    }
    
    @Override
    public Site getSite()
    {
//        return Site.me()
//            .setDomain(UrlUtils.getDomain(this.website.getDomain()))
//            .setUserAgent(this.website.getUserAgent())
//            .setRetryTimes(this.website.getRetryTimes())
//            .setCharset(this.website.getCharset())
//            .setSleepTime(this.website.getIntervalTime())
//            .setTimeOut(this.website.getTimeout());
        
        return null;
    }
}