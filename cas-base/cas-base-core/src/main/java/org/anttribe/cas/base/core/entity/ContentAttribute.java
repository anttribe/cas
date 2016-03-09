/*
 * 文  件   名: ContentAttrbute.java
 * 版         本 : (Anttribe).cas-base-core All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月4日
 */
package org.anttribe.cas.base.core.entity;

import org.anttribe.vigor.infra.persist.entity.Entity;

/**
 * @author zhaoyong
 * @version 2015年11月4日
 */
public class ContentAttribute extends Entity
{
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 属性名
     */
    private String name;
    
    /**
     * 所属内容类型
     */
    private ContentType contentType;
    
    /**
     * 属性值对应类型
     */
    private String attrValueType;
    
    /**
     * <构造器>
     */
    public ContentAttribute()
    {
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public ContentType getContentType()
    {
        return contentType;
    }
    
    public void setContentType(ContentType contentType)
    {
        this.contentType = contentType;
    }
    
    public String getAttrValueType()
    {
        return attrValueType;
    }
    
    public void setAttrValueType(String attrValueType)
    {
        this.attrValueType = attrValueType;
    }
    
}