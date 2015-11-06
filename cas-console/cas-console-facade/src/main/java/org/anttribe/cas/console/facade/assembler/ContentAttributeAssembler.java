/*
 * 文  件   名: ContentAttributeAssembler.java
 * 版         本 : (Anttribe).cas-console-facade All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.console.facade.assembler;

import java.util.ArrayList;
import java.util.List;

import org.anttribe.cas.base.core.entity.ContentAttribute;
import org.anttribe.cas.console.facade.dto.ContentAttributeDTO;
import org.apache.commons.collections.CollectionUtils;

/**
 * 
 * @author zhaoyong
 * @version 2015年11月6日
 */
public class ContentAttributeAssembler
{
    public static ContentAttributeDTO toDTO(ContentAttribute contentAttribute)
    {
        if (null != contentAttribute)
        {
            ContentAttributeDTO contentAttributeDTO = new ContentAttributeDTO();
            contentAttributeDTO.setId(contentAttribute.getId());
            contentAttributeDTO.setName(contentAttribute.getName());
            contentAttributeDTO.setAttrValueType(contentAttribute.getAttrValueType());
            contentAttributeDTO.setContentType(ContentTypeAssembler.toDTO(contentAttribute.getContentType()));
            
            return contentAttributeDTO;
        }
        return null;
    }
    
    public static List<ContentAttributeDTO> toDTO(List<ContentAttribute> contentAttributes)
    {
        if (!CollectionUtils.isEmpty(contentAttributes))
        {
            List<ContentAttributeDTO> contentAttributeDTOs = new ArrayList<ContentAttributeDTO>();
            for (ContentAttribute contentAttribute : contentAttributes)
            {
                ContentAttributeDTO contentAttributeDTO = ContentAttributeAssembler.toDTO(contentAttribute);
                if (null == contentAttributeDTO)
                {
                    continue;
                }
                contentAttributeDTOs.add(contentAttributeDTO);
            }
            
            return contentAttributeDTOs;
        }
        return null;
    }
    
    public static ContentAttribute toEntity(ContentAttributeDTO contentAttributeDTO)
    {
        if (null != contentAttributeDTO)
        {
            ContentAttribute contentAttribute = new ContentAttribute();
            contentAttribute.setId(contentAttributeDTO.getId());
            contentAttribute.setName(contentAttributeDTO.getName());
            contentAttribute.setAttrValueType(contentAttributeDTO.getAttrValueType());
            contentAttribute.setContentType(ContentTypeAssembler.toEntity(contentAttributeDTO.getContentType()));
            
            return contentAttribute;
        }
        return null;
    }
}