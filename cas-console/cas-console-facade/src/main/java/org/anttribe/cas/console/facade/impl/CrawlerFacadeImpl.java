/*
 * 文  件   名: CrawlerFacadeImpl.java
 * 版         本 : (Anttribe).cas-console-facade All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.console.facade.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.application.CrawlerApplication;
import org.anttribe.cas.base.core.entity.Crawler;
import org.anttribe.cas.console.facade.CrawlerFacade;
import org.anttribe.cas.console.facade.assembler.CrawlerAssembler;
import org.anttribe.cas.console.facade.dto.CrawlerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyong
 * @version 2015年11月6日
 */
@Service
public class CrawlerFacadeImpl implements CrawlerFacade
{
    
    @Autowired
    private CrawlerApplication crawlerApplication;
    
    @Override
    public List<CrawlerDTO> listCrawlers(CrawlerDTO crawlerDTO)
    {
        // 将对象转换成Map
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("id", crawlerDTO.getId());
        criteria.put("title", crawlerDTO.getTitle());
        criteria.put("website", crawlerDTO.getWebsite());
        criteria.put("contentType", crawlerDTO.getContentType());
        criteria.put("state", crawlerDTO.getState());
        
        List<Crawler> crawlers = crawlerApplication.listCrawlers(criteria);
        return CrawlerAssembler.toDTO(crawlers);
    }
    
    @Override
    public void editCrawler(CrawlerDTO crawlerDTO)
    {
        Crawler crawler = CrawlerAssembler.toEntity(crawlerDTO);
        if (null != crawler)
        {
        }
    }
    
    @Override
    public void deleteCrawler(CrawlerDTO crawlerDTO)
    {
        Crawler crawler = CrawlerAssembler.toEntity(crawlerDTO);
        if (null != crawler)
        {
        }
    }
}