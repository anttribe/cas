/*
 * 文  件   名: Category.java
 * 版         本 : cas-base-core.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年8月27日
 */
package org.anttribe.cas.base.core.entity;

import java.util.Date;
import java.util.List;

import org.anttribe.cas.base.infra.entity.MybatisAbstractEntity;

/**
 * 分类信息
 * 
 * @author zhaoyong
 * @version 2015年8月27日
 */
public class Category extends MybatisAbstractEntity
{
    
    /**
     * 编号
     */
    private Long id;
    
    /**
     * 分类名称
     */
    private String name;
    
    /**
     * 顺序
     */
    private Integer ordinal;
    
    /**
     * 父分类
     */
    private Category parent;
    
    /**
     * 子分类
     */
    private List<Category> children;
    
    /**
     * 树节点标记
     */
    private String treeCode;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * <构造器>
     */
    public Category()
    {
    }
    
    /**
     * <构造器>
     */
    public Category(Long id)
    {
        this.id = id;
    }
    
    @Override
    public String toString()
    {
        StringBuilder strB = new StringBuilder();
        strB.append("Category")
            .append("{")
            .append("id=")
            .append(this.getId())
            .append(',')
            .append("name=")
            .append(this.getName())
            .append(',')
            .append("parent=")
            .append(this.getParent())
            .append(',')
            .append("treeCode=")
            .append(this.getTreeCode())
            .append(',')
            .append("createTime=")
            .append(this.getCreateTime())
            .append(',')
            .append("ordinal=")
            .append(this.getOrdinal())
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
    
    public Integer getOrdinal()
    {
        return ordinal;
    }
    
    public void setOrdinal(Integer ordinal)
    {
        this.ordinal = ordinal;
    }
    
    public Category getParent()
    {
        return parent;
    }
    
    public void setParent(Category parent)
    {
        this.parent = parent;
    }
    
    public List<Category> getChildren()
    {
        return children;
    }
    
    public void setChildren(List<Category> children)
    {
        this.children = children;
    }
    
    public String getTreeCode()
    {
        return treeCode;
    }
    
    public void setTreeCode(String treeCode)
    {
        this.treeCode = treeCode;
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