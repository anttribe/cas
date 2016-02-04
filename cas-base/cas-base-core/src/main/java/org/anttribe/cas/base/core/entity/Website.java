/*
 * 文  件   名: Website.java
 * 版         本: cas-base-core(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月22日
 */
package org.anttribe.cas.base.core.entity;

import java.util.Date;

import org.anttribe.cas.base.infra.entity.MybatisAbstractEntity;

/**
 * @author zhaoyong
 * @version 2015年7月22日
 */
public class Website extends MybatisAbstractEntity
{
    
    /**
     * 编号
     */
    private Long id;
    
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
     * 创建时间
     */
    private Date createTime;
    
    /**
     * <默认构造器>
     */
    public Website()
    {
    }
    
    @Override
    public String toString()
    {
        StringBuilder strB = new StringBuilder();
        strB.append("Website")
            .append("{")
            .append("id=")
            .append(this.getId())
            .append(',')
            .append("siteName=")
            .append(this.getSiteName())
            .append(',')
            .append("domain=")
            .append(this.getDomain())
            .append(',')
            .append("logo=")
            .append(this.getLogo())
            .append(',')
            .append("charset=")
            .append(this.getCharset())
            .append(',')
            .append("userAgent=")
            .append(this.getUserAgent())
            .append(',')
            .append("categoryId=")
            .append(this.getCategory())
            .append(',')
            .append("createTime=")
            .append(this.getCreateTime())
            .append("}");
        return strB.toString();
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
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
    
    public Category getCategory()
    {
        return category;
    }
    
    public void setCategory(Category category)
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