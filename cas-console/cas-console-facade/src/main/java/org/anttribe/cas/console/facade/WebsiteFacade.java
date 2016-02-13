/*
 * 文  件   名: WebsiteFacade.java
 * 版         本 : cas-console-facade.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月31日
 */
package org.anttribe.cas.console.facade;

import java.util.List;

import org.anttribe.cas.base.infra.entity.Pagination;
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
     * 分页列表站点数据
     * 
     * @param websiteDTO
     * @param pagination
     * @return
     */
    Pagination listWebsites(WebsiteDTO websiteDTO, Pagination pagination);
    
    /**
     * 加载站点数据
     * 
     * @param websiteDTO WebsiteDTO
     * @return WebsiteDTO
     */
    WebsiteDTO loadWebsite(WebsiteDTO websiteDTO);
    
    /**
     * 校验站点名称唯一
     * 
     * @param websiteDTO
     * @return
     */
    boolean validateNameUnique(WebsiteDTO websiteDTO);
    
    /**
     * 保存或修改 站点信息
     * 
     * @param websiteDTO WebsiteDTO
     */
    void saveOrUpdateWebsite(WebsiteDTO websiteDTO);
    
    /**
     * 删除站点信息
     * 
     * @param websiteDTO WebsiteDTO
     */
    void deleteWebsite(WebsiteDTO websiteDTO);
}