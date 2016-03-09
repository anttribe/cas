/*
 * 文  件   名: Website.java
 * 版         本: cas-base-core(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月22日
 */
package org.anttribe.cas.base.core.entity;

import org.anttribe.vigor.infra.persist.entity.Entity;

/**
 * @author zhaoyong
 * @version 2015年7月22日
 */
public class Website extends Entity
{
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
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
     * 站点所属分类
     */
    private Category category;
    
    /**
     * <默认构造器>
     */
    public Website()
    {
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
    
    public Category getCategory()
    {
        return category;
    }
    
    public void setCategory(Category category)
    {
        this.category = category;
    }
    
}