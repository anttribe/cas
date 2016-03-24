/*
 * 文  件   名: SpiderManager.java
 * 版         本 : cas-base-runtime © 2016 Anttribe. All rights reserved.
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2016年3月19日
 */
package org.anttribe.cas.base.runtime;

import org.anttribe.cas.base.core.entity.Crawler;

/**
 * @author zhaoyong
 * @version 2016年3月19日
 */
public interface SpiderManager
{
    
    /**
     * 添加爬虫的处理
     * 
     * @param crawler
     */
    public void addSpider(Crawler crawler);
    
    /**
     * 删除爬虫
     * 
     * @param crawler
     */
    public void removeSprider(Crawler crawler);
    
    /**
     * 启动爬虫任务
     * 
     * @param crawler
     * @return
     */
    public boolean startSprider(Crawler crawler);
    
    /**
     * 停止爬虫任务
     * 
     * @param crawler
     * @return
     */
    public boolean stopSprider(Crawler crawler);
    
}