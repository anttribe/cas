/*
 * 文  件   名: ContentAttrbute.java
 * 版         本 : (Anttribe).cas-base-core All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月4日
 */
package org.anttribe.cas.base.core.entity;

import org.anttribe.cas.base.infra.entity.MybatisAbstractEntity;

/**
 * @author zhaoyong
 * @version 2015年11月4日
 */
public class ContentAttribute extends MybatisAbstractEntity
{
    
    /**
     * id编号
     */
    private Long id;
    
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
    
    /**
     * @param id
     */
    public ContentAttribute(Long id)
    {
        this.id = id;
    }
    
    @Override
    public String toString()
    {
        StringBuilder strB = new StringBuilder();
        strB.append("ContentAttr")
            .append("{")
            .append("id=")
            .append(this.getId())
            .append(',')
            .append("name=")
            .append(this.getName())
            .append(',')
            .append("attrValueType=")
            .append(this.getAttrValueType())
            .append(',')
            .append("contentType=")
            .append(this.getContentType())
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