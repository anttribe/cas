/*
 * 文  件   名: CrawlerDTO.java
 * 版         本 : (Anttribe).cas-console-facade All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.console.facade.dto;

import java.util.Date;

import org.anttribe.cas.base.core.entity.CrawlerState;

/**
 * @author zhaoyong
 * @version 2015年11月6日
 */
public class CrawlerDTO
{
    /**
     * id
     */
    private String id;
    
    /**
     * 名称，描述性文字
     */
    private String title;
    
    /**
     * 爬虫站点
     */
    private WebsiteDTO website;
    
    /**
     * 处理2个page之间的间隔时间
     */
    private int intervalTime;
    
    /**
     * 处理失败之后的重复次数
     */
    private int retryTimes;
    
    /**
     * 超时时长
     */
    private int timeout;
    
    /**
     * 内容类型
     */
    private ContentTypeDTO contentType;
    
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
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
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
    
    public int getIntervalTime()
    {
        return intervalTime;
    }
    
    public void setIntervalTime(int intervalTime)
    {
        this.intervalTime = intervalTime;
    }
    
    public int getRetryTimes()
    {
        return retryTimes;
    }
    
    public void setRetryTimes(int retryTimes)
    {
        this.retryTimes = retryTimes;
    }
    
    public int getTimeout()
    {
        return timeout;
    }
    
    public void setTimeout(int timeout)
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