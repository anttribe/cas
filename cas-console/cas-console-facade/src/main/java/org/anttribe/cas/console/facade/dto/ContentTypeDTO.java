/*
 * 文  件   名: ContentTypeDTO.java
 * 版         本 : cas-console-facade.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月4日
 */
package org.anttribe.cas.console.facade.dto;

import java.io.Serializable;

/**
 * @author zhaoyong
 * @version 2015年11月4日
 */
public class ContentTypeDTO implements Serializable
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 3797559320501549772L;
    
    /**
     * id
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