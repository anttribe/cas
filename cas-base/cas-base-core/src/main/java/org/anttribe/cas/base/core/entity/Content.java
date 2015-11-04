/*
 * 文  件   名: Content.java
 * 版         本: cas-base-core(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月22日
 */
package org.anttribe.cas.base.core.entity;

import java.util.Date;
import java.util.List;

import org.anttribe.opengadget.core.domain.MybatisAbstractEntity;

/**
 * @author zhaoyong
 * @version 2015年7月22日
 */
public class Content extends MybatisAbstractEntity
{
    /**
     * 内容id
     */
    private String id;
    
    /**
     * 内容类型
     */
    private ContentType contentType;
    
    /**
     * 属性值
     */
    private List<ContentAttrValue> attrValues;
    
    /**
     * 原链接
     */
    private String link;
    
    /**
     * 所属站点
     */
    private Website website;
    
    /**
     * 创建时间
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
    
    public ContentType getContentType()
    {
        return contentType;
    }
    
    public void setContentType(ContentType contentType)
    {
        this.contentType = contentType;
    }
    
    public List<ContentAttrValue> getAttrValues()
    {
        return attrValues;
    }
    
    public void setAttrValues(List<ContentAttrValue> attrValues)
    {
        this.attrValues = attrValues;
    }
    
    public String getLink()
    {
        return link;
    }
    
    public void setLink(String link)
    {
        this.link = link;
    }
    
    public Website getWebsite()
    {
        return website;
    }
    
    public void setWebsite(Website website)
    {
        this.website = website;
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