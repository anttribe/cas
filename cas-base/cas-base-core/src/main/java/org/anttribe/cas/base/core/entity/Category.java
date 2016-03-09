/*
 * 文  件   名: Category.java
 * 版         本 : cas-base-core.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年8月27日
 */
package org.anttribe.cas.base.core.entity;

import org.anttribe.vigor.infra.persist.entity.TreeEntity;

/**
 * 分类信息
 * 
 * @author zhaoyong
 * @version 2015年8月27日
 */
public class Category extends TreeEntity<Category>
{
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 分类名称
     */
    private String name;
    
    /**
     * 树节点标记
     */
    private String treeCode;
    
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
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getTreeCode()
    {
        return treeCode;
    }
    
    public void setTreeCode(String treeCode)
    {
        this.treeCode = treeCode;
    }
    
}