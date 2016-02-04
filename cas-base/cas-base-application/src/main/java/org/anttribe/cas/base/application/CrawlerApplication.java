/*
 * 文  件   名: CrawlerApplication.java
 * 版       本: Copyright (c) (Anttribe)cas v1.0. All rights reserved.
 * 描       述: <描述>
 * 修   改  人: zhaoyong(anshenglimin@163.com)
 * 修 改 时 间: 2016-02-04
 */
package org.anttribe.cas.base.application;

import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.core.entity.Crawler;
import org.anttribe.cas.base.infra.entity.Pagination;

/**
 * Crawler逻辑层处理接口
 * 
 * @author zhaoyong
 * @version 1.0
 */
public interface CrawlerApplication
{

    /**
     * 列表数据
     * 
     * @param criteria Map<String, Object>
     * @return List<Crawler>
     */
    List<Crawler> listCrawlers(Map<String, Object> criteria);
    
    /**
     * 根据分类参数列表数据
     * 
     * @param criteria Map<String, Object>
     * @return Pagination
     */
    Pagination listCrawlers(Map<String, Object> criteria, Pagination pagination);
    
    /**
     * 根据条件获取单条数据
     * 
     * @param criteria Map<String, Object>
     * @return Crawler
     */
    Crawler findCrawler(Map<String, Object> criteria);
    
    /**
     * 持久化数据
     * 
     * @param crawler Crawler
     */
    void persistentCrawler(Crawler crawler);
    
    /**
     * 删除数据
     * 
     * @param crawler Crawler
     */
    void deleteCrawler(Crawler crawler);

}