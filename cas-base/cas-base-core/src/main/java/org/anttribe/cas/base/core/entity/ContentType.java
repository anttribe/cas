/*
 * 文  件   名: ContentType.java
 * 版         本: cas-base-core(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月22日
 */
package org.anttribe.cas.base.core.entity;

import org.anttribe.cas.base.infra.entity.MybatisAbstractEntity;

/**
 * @author zhaoyong
 * @version 2015年7月22日
 */
public class ContentType extends MybatisAbstractEntity
{
    
    /**
     * id编号
     */
    private Long id;
    
    /**
     * 名称
     */
    private String name;
    
    /**
     * 编码
     */
    private String code;
    
    /**
     * <默认构造器>
     */
    public ContentType()
    {
    }
    
    @Override
    public String toString()
    {
        StringBuilder strB = new StringBuilder();
        strB.append("ContentType")
            .append("{")
            .append("id=")
            .append(this.getId())
            .append(',')
            .append("name=")
            .append(this.getName())
            .append(',')
            .append("code=")
            .append(this.getCode())
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
    
    public String getCode()
    {
        return code;
    }
    
    public void setCode(String code)
    {
        this.code = code;
    }
}