/*
 * 文  件   名: ContentAttributeDTO.java
 * 版         本 : (Anttribe).cas-console-facade All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.console.facade.dto;

/**
 * @author zhaoyong
 * @version 2015年11月6日
 */
public class ContentAttributeDTO
{
    /**
     * id编号
     */
    private String id;
    
    /**
     * 属性名
     */
    private String name;
    
    /**
     * 所属内容类型
     */
    private ContentTypeDTO contentType;
    
    /**
     * 属性值对应类型
     */
    private String attrValueType;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
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
    
    public ContentTypeDTO getContentType()
    {
        return contentType;
    }
    
    public void setContentType(ContentTypeDTO contentType)
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