/*
 * 文  件   名: ContentAttributeFacade.java
 * 版         本 : cas-console-facade.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月5日
 */
package org.anttribe.cas.console.facade;

import java.util.List;

import org.anttribe.cas.console.facade.dto.ContentAttributeDTO;

/**
 * @author zhaoyong
 * @version 2015年11月5日
 */
public interface ContentAttributeFacade
{
    /**
     * 根据条件列表内容属性
     * 
     * @param contentAttributeDTO
     * @return List<ContentAttributeDTO>
     */
    List<ContentAttributeDTO> listContentAttributes(ContentAttributeDTO contentAttributeDTO);
    
    /**
     * 添加或修改内容属性
     * 
     * @param contentAttributeDTO ContentAttributeDTO
     */
    void editContentAttribute(ContentAttributeDTO contentAttributeDTO);
    
    /**
     * 删除内容属性
     * 
     * @param contentTypeDTO
     */
    void deleteContentAttribute(ContentAttributeDTO contentAttributeDTO);
}