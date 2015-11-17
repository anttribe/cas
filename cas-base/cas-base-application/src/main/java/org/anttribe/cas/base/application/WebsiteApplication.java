/*
 * 文  件   名: WebsiteApplication.java
 * 版         本: cas-base-application(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月22日
 */
package org.anttribe.cas.base.application;

import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.core.entity.Website;

/**
 * @author zhaoyong
 * @version 2015年7月22日
 */
public interface WebsiteApplication
{
    /**
     * 列表站点
     * 
     * @return
     */
    List<Website> listWebsites(Map<String, Object> criteria);
    
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