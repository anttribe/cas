/*
 * 文  件   名: WebsiteFacade.java
 * 版         本 : cas-console-facade.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月31日
 */
package org.anttribe.cas.console.facade;

import java.util.List;

import org.anttribe.cas.console.facade.dto.WebsiteDTO;

/**
 * @author zhaoyong
 * @version 2015年10月31日
 */
public interface WebsiteFacade
{
    /**
     * 列表站点信息
     * 
     * @param websiteDTO
     * @return List<WebsiteDTO>
     */
    List<WebsiteDTO> listWebsites(WebsiteDTO websiteDTO);
    
    /**
     * 添加站点信息
     * 
     * @param websiteDTO WebsiteDTO
     */
    void editWebsite(WebsiteDTO websiteDTO);
    
    /**
     * 删除站点信息
     * 
     * @param websiteDTO WebsiteDTO
     */
    void deleteWebsite(WebsiteDTO websiteDTO);
}