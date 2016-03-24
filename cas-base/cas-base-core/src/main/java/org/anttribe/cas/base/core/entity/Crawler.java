/*
 * 文  件   名: Crawler.java
 * 版         本 : cas-base-core.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月3日
 */
package org.anttribe.cas.base.core.entity;

import java.util.Date;
import java.util.List;

import org.anttribe.cas.base.core.type.CrawlerState;
import org.anttribe.vigor.infra.persist.entity.Entity;

/**
 * @author zhaoyong
 * @version 2015年11月3日
 */
public class Crawler extends Entity
{
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 名称，描述性文字
     */
    private String title;
    
    /**
     * 爬虫站点
     */
    private Website website;
    
    /**
     * 爬虫url地址
     */
    private String crawlerUrl;
    
    /**
     * 字符集
     */
    private String charset;
    
    /**
     * 用户代理
     */
    private String userAgent;
    
    /**
     * 处理2个page之间的间隔时间
     */
    private Integer intervalTime;
    
    /**
     * 处理失败之后的重复次数
     */
    private Integer retryTimes;
    
    /**
     * 超时时长
     */
    private Integer timeout;
    
    /**
     * 内容类型
     */
    private ContentType contentType;
    
    /**
     * 内容规则
     */
    private List<CrawlerRegular> regulars;
    
    /**
     * 固定规则
     */
    private CrawlerConstantRegular constantRegular;
    
    /**
     * 爬取数据时间
     */
    private Date crawlTime;
    
    /**
     * 爬虫状态
     */
    private CrawlerState state;
    
    /**
     * 是否可用
     */
    private boolean available;
    
    /**
     * <构造器>
     */
    public Crawler()
    {
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public Website getWebsite()
    {
        return website;
    }
    
    public void setWebsite(Website website)
    {
        this.website = website;
    }
    
    public String getCrawlerUrl()
    {
        return crawlerUrl;
    }
    
    public void setCrawlerUrl(String crawlerUrl)
    {
        this.crawlerUrl = crawlerUrl;
    }
    
    public String getCharset()
    {
        return charset;
    }
    
    public void setCharset(String charset)
    {
        this.charset = charset;
    }
    
    public String getUserAgent()
    {
        return userAgent;
    }
    
    public void setUserAgent(String userAgent)
    {
        this.userAgent = userAgent;
    }
    
    public Integer getIntervalTime()
    {
        return intervalTime;
    }
    
    public void setIntervalTime(Integer intervalTime)
    {
        this.intervalTime = intervalTime;
    }
    
    public Integer getRetryTimes()
    {
        return retryTimes;
    }
    
    public void setRetryTimes(Integer retryTimes)
    {
        this.retryTimes = retryTimes;
    }
    
    public Integer getTimeout()
    {
        return timeout;
    }
    
    public void setTimeout(Integer timeout)
    {
        this.timeout = timeout;
    }
    
    public ContentType getContentType()
    {
        return contentType;
    }
    
    public void setContentType(ContentType contentType)
    {
        this.contentType = contentType;
    }
    
    public List<CrawlerRegular> getRegulars()
    {
        return regulars;
    }
    
    public void setRegulars(List<CrawlerRegular> regulars)
    {
        this.regulars = regulars;
    }
    
    public CrawlerConstantRegular getConstantRegular()
    {
        return constantRegular;
    }
    
    public void setConstantRegular(CrawlerConstantRegular constantRegular)
    {
        this.constantRegular = constantRegular;
    }
    
    public Date getCrawlTime()
    {
        return crawlTime;
    }
    
    public void setCrawlTime(Date crawlTime)
    {
        this.crawlTime = crawlTime;
    }
    
    public CrawlerState getState()
    {
        return state;
    }
    
    public void setState(CrawlerState state)
    {
        this.state = state;
    }
    
    public boolean isAvailable()
    {
        return available;
    }
    
    public void setAvailable(boolean available)
    {
        this.available = available;
    }
    
}