/*
 * 文  件   名: WebsiteCategory.java
 * 版         本 : cas-base-core.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年8月27日
 */
package org.anttribe.cas.base.core.entity;

/**
 * 站点所属分类
 * 
 * @author zhaoyong
 * @version 2015年8月27日
 */
public class WebsiteCategory
{
    /**
     * 分类id
     */
    private String categoryId;
    
    /**
     * 分类名称
     */
    private String categoryName;
    
    /**
     * 父分类
     */
    private WebsiteCategory parent;
    
    public String getCategoryId()
    {
        return categoryId;
    }
    
    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
    }
    
    public String getCategoryName()
    {
        return categoryName;
    }
    
    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }
    
    public WebsiteCategory getParent()
    {
        return parent;
    }
    
    public void setParent(WebsiteCategory parent)
    {
        this.parent = parent;
    }
}