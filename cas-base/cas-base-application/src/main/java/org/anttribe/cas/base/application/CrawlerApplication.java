/*
 * 文  件   名: CrawlerApplication.java
 * 版         本 : (Anttribe).cas-base-application All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.base.application;

import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.core.entity.Crawler;

/**
 * @author zhaoyong
 * @version 2015年11月6日
 */
public interface CrawlerApplication
{
    /**
     * 根据条件查询爬虫
     * 
     * @param criteria Map<String, Object>
     * @return List<Crawler>
     */
    List<Crawler> listCrawlers(Map<String, Object> criteria);
}