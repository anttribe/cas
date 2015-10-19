/*
 * 文  件   名: WebsiteCategory.java
 * 版         本 : cas-base-core.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年8月27日
 */
package org.anttribe.cas.base.core.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anttribe.opengadget.core.domain.MybatisAbstractEntity;

/**
 * 分类信息
 * 
 * @author zhaoyong
 * @version 2015年8月27日
 */
public class Category extends MybatisAbstractEntity
{
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
    private Category parent;
    
    /**
     * 数据创建时间
     */
    private Date createTime;
    
    /**
     * 数据更新时间
     */
    private Date updateTime;
    
    /**
     * <构造器>
     */
    public Category()
    {
    }
    
    /**
     * <构造器>
     */
    public Category(String id)
    {
        this.id = id;
    }
    
    /**
     * 根据父分类获取自分类信息
     * 
     * @param parent 父分类id
     * @return List<Category>
     */
    public static List<Category> listCategoriesByParent(String parent)
    {
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("parent", new Category(parent));
        return Category.getSqlSessionTemplate().selectList(Category.class.getCanonicalName() + ".queryByCriteria",
            criteria);
    }
    
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
    
    public Category getParent()
    {
        return parent;
    }
    
    public void setParent(Category parent)
    {
        this.parent = parent;
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