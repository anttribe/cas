/*
 * 文  件   名: WebsiteAssembler.java
 * 版         本 : cas-console-facade.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月1日
 */
package org.anttribe.cas.console.facade.assembler;

import java.util.ArrayList;
import java.util.List;

import org.anttribe.cas.base.core.entity.Website;
import org.anttribe.cas.console.facade.dto.WebsiteDTO;
import org.apache.commons.collections.CollectionUtils;

/**
 * @author zhaoyong
 * @version 2015年11月1日
 */
public class WebsiteAssembler
{
    public static List<WebsiteDTO> toDTO(List<Website> websites)
    {
        if (!CollectionUtils.isEmpty(websites))
        {
            List<WebsiteDTO> websiteDTOs = new ArrayList<WebsiteDTO>();
            for (Website website : websites)
            {
                websiteDTOs.add(WebsiteAssembler.toDTO(website));
            }
            return websiteDTOs;
        }
        return null;
    }
    
    public static WebsiteDTO toDTO(Website website)
    {
        if (null != website)
        {
            WebsiteDTO websiteDTO = new WebsiteDTO();
            websiteDTO.setId(website.getId());
            websiteDTO.setSiteName(website.getSiteName());
            websiteDTO.setCategory(CategoryAssembler.toDTO(website.getCategory()));
            websiteDTO.setContentType(website.getContentType());
            
            return websiteDTO;
        }
        return null;
    }
}