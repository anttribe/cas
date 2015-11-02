/*
 * 文  件   名: WebsiteApplication.java
 * 版         本: cas-base-application(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月22日
 */
package org.anttribe.cas.base.application;

import java.util.List;

import org.anttribe.cas.base.core.entity.Website;

/**
 * @author zhaoyong
 * @version 2015年7月22日
 */
public interface WebsiteApplication
{
    /**
     * 列表所有可用的站点
     * 
     * @return
     */
    List<Website> listAvailableWebsites();
    
    /**
     * 持久化站点信息
     * 
     * @param website Website
     */
    void persistentWebsite(Website website);
    
    /**
     * 删除站点信息
     * 
     * @param website Website
     */
    void deleteWebsite(Website website);
}