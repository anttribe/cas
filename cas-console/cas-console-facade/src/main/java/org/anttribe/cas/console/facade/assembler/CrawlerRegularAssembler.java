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
import org.anttribe.cas.base.core.entity.CrawlerRegular;
import org.anttribe.cas.console.facade.dto.CrawlerRegularDTO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author zhaoyong
 * @version 2015年11月6日
 */
public class CrawlerRegularAssembler
{
    public static CrawlerRegularDTO toDTO(CrawlerRegular crawlerRegular)
    {
        if (null != crawlerRegular)
        {
            CrawlerRegularDTO crawlerRegularDTO = new CrawlerRegularDTO();
            crawlerRegularDTO.setId(crawlerRegular.getId());
            // crawlerRegularDTO.setAttribute(null != crawlerRegular.getContentAttr() ? crawlerRegular.getContentAttr()
            // .getId()
            // : "");
            // crawlerRegularDTO.setCrawler(null != crawlerRegular.getCrawler() ? crawlerRegular.getCrawler()
            // .getId()
            // : "");
            // crawlerRegularDTO.setRegular(crawlerRegular.getRegular());
            
            return crawlerRegularDTO;
        }
        return null;
    }
    
    public static List<CrawlerRegularDTO> toDTO(List<CrawlerRegular> crawlerContentRegulars)
    {
        if (!CollectionUtils.isEmpty(crawlerContentRegulars))
        {
            List<CrawlerRegularDTO> crawlerContentRegularDTOs = new ArrayList<CrawlerRegularDTO>();
            for (CrawlerRegular crawlerContentRegular : crawlerContentRegulars)
            {
                CrawlerRegularDTO crawlerContentRegularDTO = CrawlerRegularAssembler.toDTO(crawlerContentRegular);
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
    
    public static CrawlerRegular toEntity(CrawlerRegularDTO crawlerRegularDTO)
    {
        if (null != crawlerRegularDTO)
        {
            CrawlerRegular crawlerRegular = new CrawlerRegular();
            crawlerRegular.setId(crawlerRegularDTO.getId());
            crawlerRegular.setContentAttr(!StringUtils.isEmpty(crawlerRegularDTO.getAttribute())
                ? new ContentAttribute(Long.parseLong(crawlerRegularDTO.getAttribute())) : null);
            crawlerRegular.setAttrRegular(crawlerRegularDTO.getRegular());
            
            return crawlerRegular;
        }
        return null;
    }
    
    public static List<CrawlerRegular> toEntity(List<CrawlerRegularDTO> crawlertRegularDTOs)
    {
        if (!CollectionUtils.isEmpty(crawlertRegularDTOs))
        {
            List<CrawlerRegular> regulars = new ArrayList<CrawlerRegular>();
            for (CrawlerRegularDTO crawlerRegularDTO : crawlertRegularDTOs)
            {
                CrawlerRegular regular = CrawlerRegularAssembler.toEntity(crawlerRegularDTO);
                if (null == regular)
                {
                    continue;
                }
                regulars.add(regular);
            }
            return regulars;
        }
        return null;
    }
}