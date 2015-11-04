/*
 * 文  件   名: WebsiteDTO.java
 * 版         本 : cas-console-facade.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月31日
 */
package org.anttribe.cas.console.facade.dto;

import java.util.Date;

/**
 * @author zhaoyong
 * @version 2015年10月31日
 */
public class WebsiteDTO
{
    /**
     * id
     */
    private String id;
    
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
    private CategoryDTO category;
    
    /**
     * 数据创建时间
     */
    private Date createTime;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
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
    
    public CategoryDTO getCategory()
    {
        return category;
    }
    
    public void setCategory(CategoryDTO category)
    {
        this.category = category;
    }
    
    public Date getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
}