/*
 * 文  件   名: Theme.java
 * 版         本: cas-base-core(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月22日
 */
package org.anttribe.cas.base.core.entity;

import org.anttribe.opengadget.core.domain.MybatisAbstractEntity;

/**
 * @author zhaoyong
 * @version 2015年7月22日
 */
public class Theme extends MybatisAbstractEntity
{
    /**
     * 主题id
     */
    private String themeId;
    
    /**
     * 主题名称
     */
    private String themeName;
    
    /**
     * 优先级
     */
    private String priority;
    
    /**
     * 是否可用
     */
    private boolean available;
    
    public String getThemeId()
    {
        return themeId;
    }
    
    public void setThemeId(String themeId)
    {
        this.themeId = themeId;
    }
    
    public String getThemeName()
    {
        return themeName;
    }
    
    public void setThemeName(String themeName)
    {
        this.themeName = themeName;
    }
    
    public String getPriority()
    {
        return priority;
    }
    
    public void setPriority(String priority)
    {
        this.priority = priority;
    }
    
    public boolean isAvailable()
    {
        return available;
    }
    
    public void setAvailable(boolean available)
    {
        this.available = available;
    }
}