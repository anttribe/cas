/*
 * 文  件   名: WebsiteFacadeImpl.java
 * 版         本 : cas-console-facade.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月31日
 */
package org.anttribe.cas.console.facade.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.application.WebsiteApplication;
import org.anttribe.cas.base.core.entity.Website;
import org.anttribe.cas.base.infra.entity.Pagination;
import org.anttribe.cas.console.facade.WebsiteFacade;
import org.anttribe.cas.console.facade.assembler.CategoryAssembler;
import org.anttribe.cas.console.facade.assembler.WebsiteAssembler;
import org.anttribe.cas.console.facade.dto.WebsiteDTO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyong
 * @version 2015年10月31日
 */
@Service
public class WebsiteFacadeImpl implements WebsiteFacade
{
    
    @Autowired
    private WebsiteApplication websiteApplication;
    
    @Override
    public List<WebsiteDTO> listWebsites(WebsiteDTO websiteDTO)
    {
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("id", websiteDTO.getId());
        criteria.put("siteName", websiteDTO.getSiteName());
        criteria.put("category", CategoryAssembler.toEntity(websiteDTO.getCategory()));
        List<Website> websites = websiteApplication.listWebsites(criteria);
        
        return WebsiteAssembler.toDTO(websites);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public Pagination listWebsites(WebsiteDTO websiteDTO, Pagination pagination)
    {
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("id", websiteDTO.getId());
        criteria.put("siteName", websiteDTO.getSiteName());
        criteria.put("category", CategoryAssembler.toEntity(websiteDTO.getCategory()));
        pagination = websiteApplication.listWebsites(criteria, pagination);
        if (null != pagination)
        {
            pagination.setDatas(WebsiteAssembler.toDTO((List<Website>)pagination.getDatas()));
        }
        return pagination;
    }
    
    @Override
    public WebsiteDTO loadWebsite(WebsiteDTO websiteDTO)
    {
        if (null != websiteDTO && null != websiteDTO.getId())
        {
            // 将对象转换成Map
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("id", websiteDTO.getId());
            List<Website> websites = websiteApplication.listWebsites(criteria);
            if (!CollectionUtils.isEmpty(websites))
            {
                return WebsiteAssembler.toDTO(websites.get(0));
            }
        }
        return null;
    }
    
    @Override
    public boolean validateNameUnique(WebsiteDTO websiteDTO)
    {
        if (null != websiteDTO && !StringUtils.isEmpty(websiteDTO.getSiteName()))
        {
            // 将对象转换成Map
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("notId", websiteDTO.getId());
            criteria.put("uniqueName", websiteDTO.getSiteName());
            List<Website> websites = this.websiteApplication.listWebsites(criteria);
            if (CollectionUtils.isEmpty(websites))
            {
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public void saveOrUpdateWebsite(WebsiteDTO websiteDTO)
    {
        Website website = WebsiteAssembler.toEntity(websiteDTO);
        if (null != website)
        {
            websiteApplication.persistentWebsite(website);
        }
    }
    
    @Override
    public void deleteWebsite(WebsiteDTO websiteDTO)
    {
        Website website = WebsiteAssembler.toEntity(websiteDTO);
        if (null != website)
        {
            websiteApplication.deleteWebsite(website);
        }
    }
    
}