/*
 * 文  件   名: ContentType.java
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
public class ContentType extends Entity
{
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
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