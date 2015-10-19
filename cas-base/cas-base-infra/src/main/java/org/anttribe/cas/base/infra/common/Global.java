/*
 * 文  件   名: Global.java
 * 版         本 : (Anttribe) cas-base-infra All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月11日
 */
package org.anttribe.cas.base.infra.common;

import org.apache.commons.configuration.Configuration;

/**
 * @author zhaoyong
 * @version 2015年10月11日
 */
public class Global
{
    /**
     * 配置参数
     */
    private Configuration configuration;
    
    /**
     * 当前对象
     */
    private static Global me;
    
    /**
     * 获取当前对象
     * 
     * @return Global
     */
    public static Global me()
    {
        if (null == me)
        {
            me = new Global();
        }
        return me;
    }
    
    /**
     * <默认构造器>
     */
    private Global()
    {
    }
    
    public boolean containsKey(String key)
    {
        return configuration.containsKey(key);
    }
    
    public Object getProperty(String key)
    {
        return configuration.getProperty(key);
    }
    
    public String getString(String key)
    {
        return configuration.getString(key);
    }
    
    public Long getLong(String key, Long defaultValue)
    {
        return configuration.getLong(key, defaultValue);
    }
    
    public Integer getInt(String key, int defaultValue)
    {
        return configuration.getInt(key, defaultValue);
    }
    
    public void setConfiguration(Configuration configuration)
    {
        this.configuration = configuration;
    }
}