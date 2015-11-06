/*
 * 文  件   名: CrawlerFacade.java
 * 版         本 : (Anttribe).cas-console-facade All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.console.facade;

import java.util.List;

import org.anttribe.cas.console.facade.dto.CrawlerDTO;

/**
 * @author zhaoyong
 * @version 2015年11月6日
 */
public interface CrawlerFacade
{
    /**
     * 根据条件列表爬虫
     * 
     * @param crawlerDTO
     * @return List<CrawlerDTO>
     */
    List<CrawlerDTO> listCrawlers(CrawlerDTO crawlerDTO);
    
    /**
     * 编辑爬虫
     * 
     * @param crawlerDTO CrawlerDTO
     */
    void editCrawler(CrawlerDTO crawlerDTO);
    
    /**
     * 删除爬虫
     * 
     * @param crawlerDTO
     */
    void deleteCrawler(CrawlerDTO crawlerDTO);
}