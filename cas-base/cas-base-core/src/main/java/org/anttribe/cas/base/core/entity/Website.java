/*
 * 文  件   名: Website.java
 * 版         本: cas-base-core(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月22日
 */
package org.anttribe.cas.base.core.entity;

import org.anttribe.opengadget.core.domain.MybatisAbstractEntity;

/**
 * @author zhaoyong
 * @version 2015年7月22日
 */
public class Website extends MybatisAbstractEntity
{
    /**
     * siteId
     */
    private String siteId;
    
    /**
     * 网站名
     */
    private String siteName;
    
    /**
     * 网站域名
     */
    private String domain;
    
    /**
     * 网站logo
     */
    private String logo;
    
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
    private ContentType contentType;
    
    /**
     * 站点所属分类
     */
    private WebsiteCategory category;
    
    public String getSiteId()
    {
        return siteId;
    }
    
    public void setSiteId(String siteId)
    {
        this.siteId = siteId;
    }
    
    public String getSiteName()
    {
        return siteName;
    }
    
    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }
    
    public String getDomain()
    {
        return domain;
    }
    
    public void setDomain(String domain)
    {
        this.domain = domain;
    }
    
    public String getLogo()
    {
        return logo;
    }
    
    public void setLogo(String logo)
    {
        this.logo = logo;
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
    
    public ContentType getContentType()
    {
        return contentType;
    }
    
    public void setContentType(ContentType contentType)
    {
        this.contentType = contentType;
    }
    
    public WebsiteCategory getCategory()
    {
        return category;
    }
    
    public void setCategory(WebsiteCategory category)
    {
        this.category = category;
    }
}