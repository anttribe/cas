/*
 * 文  件   名: CrawlerAssembler.java
 * 版         本 : (Anttribe).cas-console-facade All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.console.facade.assembler;

import java.util.ArrayList;
import java.util.List;

import org.anttribe.cas.base.core.entity.Crawler;
import org.anttribe.cas.console.facade.dto.CrawlerDTO;
import org.apache.commons.collections.CollectionUtils;

/**
 * @author zhaoyong
 * @version 2015年11月6日
 */
public class CrawlerAssembler
{
    
    public static CrawlerDTO toDTO(Crawler crawler)
    {
        if (null != crawler)
        {
            CrawlerDTO crawlerDTO = new CrawlerDTO();
            crawlerDTO.setId(crawler.getId());
            crawlerDTO.setTitle(crawler.getTitle());
            crawlerDTO.setCrawlerUrl(crawler.getCrawlerUrl());
            crawlerDTO.setWebsite(WebsiteAssembler.toDTO(crawler.getWebsite()));
            crawlerDTO.setContentType(ContentTypeAssembler.toDTO(crawler.getContentType()));
            crawlerDTO.setIntervalTime(crawler.getIntervalTime());
            crawlerDTO.setRetryTimes(crawler.getRetryTimes());
            crawlerDTO.setTimeout(crawler.getTimeout());
            crawlerDTO.setState(crawler.getState());
            crawlerDTO.setCrawlTime(crawler.getCrawlTime());
            crawlerDTO.setCreateTime(crawler.getCreateTime());
            crawlerDTO.setAvailable(crawler.isAvailable());
            
            return crawlerDTO;
        }
        return null;
    }
    
    public static List<CrawlerDTO> toDTO(List<Crawler> crawlers)
    {
        if (!CollectionUtils.isEmpty(crawlers))
        {
            List<CrawlerDTO> crawlerDTOs = new ArrayList<CrawlerDTO>();
            for (Crawler crawler : crawlers)
            {
                CrawlerDTO crawlerDTO = CrawlerAssembler.toDTO(crawler);
                if (null == crawlerDTO)
                {
                    continue;
                }
                crawlerDTOs.add(crawlerDTO);
            }
            
            return crawlerDTOs;
        }
        return null;
    }
    
    public static Crawler toEntity(CrawlerDTO crawlerDTO)
    {
        if (null != crawlerDTO)
        {
            Crawler crawler = new Crawler();
            crawler.setId(crawlerDTO.getId());
            crawler.setTitle(crawlerDTO.getTitle());
            crawler.setCrawlerUrl(crawlerDTO.getCrawlerUrl());
            crawler.setWebsite(WebsiteAssembler.toEntity(crawlerDTO.getWebsite()));
            crawler.setContentType(ContentTypeAssembler.toEntity(crawlerDTO.getContentType()));
            crawler.setIntervalTime(crawlerDTO.getIntervalTime());
            crawler.setRetryTimes(crawlerDTO.getRetryTimes());
            crawler.setTimeout(crawlerDTO.getTimeout());
            crawler.setState(crawlerDTO.getState());
            crawler.setCrawlTime(crawlerDTO.getCrawlTime());
            crawler.setCreateTime(crawlerDTO.getCreateTime());
            crawler.setAvailable(crawlerDTO.isAvailable());
            crawler.setRegulars(CrawlerRegularAssembler.toEntity(crawlerDTO.getRegulars()));
            
            return crawler;
        }
        return null;
    }
}