/*
 * 文  件   名: CrawlerContentRegularAssembler.java
 * 版         本 : (Anttribe).cas-console-facade All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.console.facade.assembler;

import java.util.ArrayList;
import java.util.List;

import org.anttribe.cas.base.core.entity.ContentAttribute;
import org.anttribe.cas.base.core.entity.Crawler;
import org.anttribe.cas.base.core.entity.CrawlerContentRegular;
import org.anttribe.cas.console.facade.dto.CrawlerContentRegularDTO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zhaoyong
 * @version 2015年11月6日
 */
public class CrawlerContentRegularAssembler
{
    public static CrawlerContentRegularDTO toDTO(CrawlerContentRegular crawlerContentRegular)
    {
        if (null != crawlerContentRegular)
        {
            CrawlerContentRegularDTO crawlerContentRegularDTO = new CrawlerContentRegularDTO();
            crawlerContentRegularDTO.setId(crawlerContentRegular.getId());
            crawlerContentRegularDTO.setAttribute(
                null != crawlerContentRegular.getAttribute() ? crawlerContentRegular.getAttribute().getId() : "");
            crawlerContentRegularDTO.setCrawler(
                null != crawlerContentRegular.getCrawler() ? crawlerContentRegular.getCrawler().getId() : "");
            crawlerContentRegularDTO.setRegular(crawlerContentRegular.getRegular());
            
            return crawlerContentRegularDTO;
        }
        return null;
    }
    
    public static List<CrawlerContentRegularDTO> toDTO(List<CrawlerContentRegular> crawlerContentRegulars)
    {
        if (!CollectionUtils.isEmpty(crawlerContentRegulars))
        {
            List<CrawlerContentRegularDTO> crawlerContentRegularDTOs = new ArrayList<CrawlerContentRegularDTO>();
            for (CrawlerContentRegular crawlerContentRegular : crawlerContentRegulars)
            {
                CrawlerContentRegularDTO crawlerContentRegularDTO =
                    CrawlerContentRegularAssembler.toDTO(crawlerContentRegular);
                if (null == crawlerContentRegularDTO)
                {
                    continue;
                }
                crawlerContentRegularDTOs.add(crawlerContentRegularDTO);
            }
            
            return crawlerContentRegularDTOs;
        }
        return null;
    }
    
    public static CrawlerContentRegular toEntity(CrawlerContentRegularDTO crawlerContentRegularDTO)
    {
        if (null != crawlerContentRegularDTO)
        {
            CrawlerContentRegular crawlerContentRegular = new CrawlerContentRegular();
            crawlerContentRegular.setId(crawlerContentRegularDTO.getId());
            crawlerContentRegular.setCrawler(StringUtils.isEmpty(crawlerContentRegularDTO.getId())
                ? new Crawler(crawlerContentRegularDTO.getId()) : null);
            crawlerContentRegular.setAttribute(StringUtils.isEmpty(crawlerContentRegularDTO.getAttribute())
                ? new ContentAttribute(crawlerContentRegularDTO.getAttribute()) : null);
            crawlerContentRegular.setRegular(crawlerContentRegularDTO.getCrawler());
            
            return crawlerContentRegular;
        }
        return null;
    }
}