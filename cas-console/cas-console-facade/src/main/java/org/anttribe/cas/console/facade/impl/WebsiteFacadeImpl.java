/*
 * 文  件   名: WebsiteFacadeImpl.java
 * 版         本 : cas-console-facade.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月31日
 */
package org.anttribe.cas.console.facade.impl;

import java.util.List;

import org.anttribe.cas.base.application.WebsiteApplication;
import org.anttribe.cas.base.core.entity.Website;
import org.anttribe.cas.console.facade.WebsiteFacade;
import org.anttribe.cas.console.facade.assembler.WebsiteAssembler;
import org.anttribe.cas.console.facade.dto.WebsiteDTO;
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
        List<Website> websites = websiteApplication.listWebsites();
        return WebsiteAssembler.toDTO(websites);
    }
    
    @Override
    public void editWebsite(WebsiteDTO websiteDTO)
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