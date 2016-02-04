/*
 * 文  件   名: ContentValue.java
 * 版         本 : (Anttribe).cas-base-core All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月4日
 */
package org.anttribe.cas.base.core.entity;

import org.anttribe.cas.base.infra.entity.MybatisAbstractEntity;

/**
 * 抽象内容属性值
 * 
 * @author zhaoyong
 * @version 2015年11月4日
 */
public class ContentAttrValue extends MybatisAbstractEntity
{
    
    /**
     * id编号
     */
    private Long id;
    
    /**
     * 内容属性
     */
    private ContentAttribute contentAttr;
    
    /**
     * 属性值
     */
    private String attrValue;
    
    /**
     * 所属内容
     */
    private Content content;
    
    /**
     * <默认构造器>
     */
    public ContentAttrValue()
    {
    }
    
    @Override
    public String toString()
    {
        StringBuilder strB = new StringBuilder();
        strB.append("ContentAttrValue")
            .append("{")
            .append("id=")
            .append(this.getId())
            .append(',')
            .append("content=")
            .append(this.getContent())
            .append(',')
            .append("attrValue=")
            .append(this.getAttrValue())
            .append(',')
            .append("contentAttr=")
            .append(this.getContentAttr())
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
    
    public ContentAttribute getContentAttr()
    {
        return contentAttr;
    }
    
    public void setContentAttr(ContentAttribute contentAttr)
    {
        this.contentAttr = contentAttr;
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