/*
 * 文  件   名: CrawlerDTO.java
 * 版         本 : (Anttribe).cas-console-facade All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.console.facade.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.anttribe.cas.base.core.type.CrawlerState;
import org.anttribe.cas.base.infra.constants.Constants;

/**
 * @author zhaoyong
 * @version 2015年11月6日
 */
public class CrawlerDTO implements Serializable
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 823093992375175461L;
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 名称，描述性文字
     */
    private String title;
    
    /**
     * 爬虫站点
     */
    private WebsiteDTO website;
    
    /**
     * 爬虫url地址
     */
    private String crawlerUrl;
    
    /**
     * 处理2个page之间的间隔时间
     */
    private Integer intervalTime = Constants.Crawler.DEFAULT_PAGE_INTERVALTIME;
    
    /**
     * 处理失败之后的重复次数
     */
    private Integer retryTimes = Constants.Crawler.DEFAULT_RETRYTIMES;
    
    /**
     * 超时时长
     */
    private Integer timeout = Constants.Crawler.DEFAULT_TIMEOUT;
    
    /**
     * 内容类型
     */
    private ContentTypeDTO contentType;
    
    /**
     * 内容规则
     */
    private List<CrawlerRegularDTO> regulars;
    
    /**
     * 是否可用
     */
    private boolean available;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 爬取数据时间
     */
    private Date crawlTime;
    
    /**
     * 爬虫状态
     */
    private CrawlerState state;
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public WebsiteDTO getWebsite()
    {
        return website;
    }
    
    public void setWebsite(WebsiteDTO website)
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
    
    public ContentTypeDTO getContentType()
    {
        return contentType;
    }
    
    public void setContentType(ContentTypeDTO contentType)
    {
        this.contentType = contentType;
    }
    
    public List<CrawlerRegularDTO> getRegulars()
    {
        return regulars;
    }
    
    public void setRegulars(List<CrawlerRegularDTO> regulars)
    {
        this.regulars = regulars;
    }
    
    public boolean isAvailable()
    {
        return available;
    }
    
    public void setAvailable(boolean available)
    {
        this.available = available;
    }
    
    public Date getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
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
}