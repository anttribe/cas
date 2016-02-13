/*
 * 文  件   名: ContentTypeFacade.java
 * 版         本 : cas-console-facade.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月4日
 */
package org.anttribe.cas.console.facade;

import java.util.List;

import org.anttribe.cas.base.infra.entity.Pagination;
import org.anttribe.cas.console.facade.dto.ContentTypeDTO;

/**
 * @author zhaoyong
 * @version 2015年11月4日
 */
public interface ContentTypeFacade
{
    /**
     * 列表所有的内容类型
     * 
     * @param contentTypeDTO
     * @return List<ContentTypeDTO>
     */
    List<ContentTypeDTO> listContentTypes(ContentTypeDTO contentTypeDTO);
    
    /**
     * 分页列表所有的内容类型
     * 
     * @param contentTypeDTO
     * @param pagination
     * @return Pagination
     */
    Pagination listContentTypes(ContentTypeDTO contentTypeDTO, Pagination pagination);
    
    /**
     * 加载ContentType
     * 
     * @param contentTypeDTO
     * @return ContentTypeDTO
     */
    ContentTypeDTO loadContentType(ContentTypeDTO contentTypeDTO);
    
    /**
     * 校验类型名称唯一
     * 
     * @param contentTypeDTO
     * @return
     */
    boolean validateNameUnique(ContentTypeDTO contentTypeDTO);
    
    /**
     * 校验类型编码唯一
     * 
     * @param contentTypeDTO
     * @return
     */
    boolean validateCodeUnique(ContentTypeDTO contentTypeDTO);
    
    /**
     * 添加或修改内容类型
     * 
     * @param contentTypeDTO ContentTypeDTO
     */
    void saveOrUpdateWebsite(ContentTypeDTO contentTypeDTO);
    
    /**
     * 删除内容类型
     * 
     * @param contentTypeDTO
     */
    void deleteContentType(ContentTypeDTO contentTypeDTO);
}