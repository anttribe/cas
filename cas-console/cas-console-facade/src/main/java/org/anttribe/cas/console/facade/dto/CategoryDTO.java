/*
 * 文  件   名: CategoryDTO.java
 * 版         本 : (Anttribe).cas-console-facade All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月19日
 */
package org.anttribe.cas.console.facade.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author zhaoyong
 * @version 2015年10月19日
 */
public class CategoryDTO implements Serializable
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -7551423704386897744L;
    
    /**
     * 分类id
     */
    private String id;
    
    /**
     * 分类名称
     */
    private String name;
    
    /**
     * 顺序
     */
    private int ordinal;
    
    /**
     * 父分类
     */
    private String parent;
    
    /**
     * 子分类
     */
    private List<CategoryDTO> children;
    
    /**
     * 数据创建时间
     */
    private Date createTime;
    
    /**
     * 数据更新时间
     */
    private Date updateTime;
    
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
    
    public int getOrdinal()
    {
        return ordinal;
    }
    
    public void setOrdinal(int ordinal)
    {
        this.ordinal = ordinal;
    }
    
    public String getParent()
    {
        return parent;
    }
    
    public void setParent(String parent)
    {
        this.parent = parent;
    }
    
    public List<CategoryDTO> getChildren()
    {
        return children;
    }
    
    public void setChildren(List<CategoryDTO> children)
    {
        this.children = children;
    }
    
    public Date getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    
    public Date getUpdateTime()
    {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }
}