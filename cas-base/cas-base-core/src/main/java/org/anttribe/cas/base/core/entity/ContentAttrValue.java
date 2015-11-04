/*
 * 文  件   名: ContentValue.java
 * 版         本 : (Anttribe).cas-base-core All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月4日
 */
package org.anttribe.cas.base.core.entity;

/**
 * 抽象内容属性值
 * 
 * @author zhaoyong
 * @version 2015年11月4日
 */
public class ContentAttrValue
{
    /**
     * id编号
     */
    private String id;
    
    /**
     * 所属属性
     */
    private ContentAttribute attribute;
    
    /**
     * 属性值
     */
    private String attrValue;
    
    /**
     * 所属内容
     */
    private Content content;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public ContentAttribute getAttribute()
    {
        return attribute;
    }
    
    public void setAttribute(ContentAttribute attribute)
    {
        this.attribute = attribute;
    }
    
    public String getAttrValue()
    {
        return attrValue;
    }
    
    public void setAttrValue(String attrValue)
    {
        this.attrValue = attrValue;
    }
    
    public Content getContent()
    {
        return content;
    }
    
    public void setContent(Content content)
    {
        this.content = content;
    }
}