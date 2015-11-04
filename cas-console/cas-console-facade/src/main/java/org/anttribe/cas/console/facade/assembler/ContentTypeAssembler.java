/*
 * 文  件   名: ContentTypeAssembler.java
 * 版         本 : (Anttribe).cas-console-facade All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月4日
 */
package org.anttribe.cas.console.facade.assembler;

import java.util.ArrayList;
import java.util.List;

import org.anttribe.cas.base.core.entity.ContentType;
import org.anttribe.cas.console.facade.dto.ContentTypeDTO;
import org.apache.commons.collections.CollectionUtils;

/**
 * @author zhaoyong
 * @version 2015年11月4日
 */
public class ContentTypeAssembler
{
    public static ContentTypeDTO toDTO(ContentType contentType)
    {
        if (null != contentType)
        {
            ContentTypeDTO contentTypeDTO = new ContentTypeDTO();
            contentTypeDTO.setId(contentType.getId());
            contentTypeDTO.setName(contentType.getName());
            contentTypeDTO.setCode(contentType.getCode());
            
            return contentTypeDTO;
        }
        return null;
    }
    
    public static List<ContentTypeDTO> toDTO(List<ContentType> contentTypes)
    {
        if (!CollectionUtils.isEmpty(contentTypes))
        {
            List<ContentTypeDTO> contentTypeDTOs = new ArrayList<ContentTypeDTO>();
            for (ContentType contentType : contentTypes)
            {
                ContentTypeDTO contentTypeDTO = ContentTypeAssembler.toDTO(contentType);
                if (null == contentTypeDTO)
                {
                    continue;
                }
                contentTypeDTOs.add(contentTypeDTO);
            }
            
            return contentTypeDTOs;
        }
        return null;
    }
    
    public static ContentType toEntity(ContentTypeDTO contentTypeDTO)
    {
        if (null != contentTypeDTO)
        {
            ContentType contentType = new ContentType();
            contentType.setId(contentTypeDTO.getId());
            contentType.setName(contentTypeDTO.getName());
            contentType.setCode(contentTypeDTO.getCode());
            
            return contentType;
        }
        return null;
    }
}