/*
 * 文  件   名: ContentAttributeFacadeImpl.java
 * 版         本 : (Anttribe).cas-console-facade All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.console.facade.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.application.ContentAttributeApplication;
import org.anttribe.cas.base.core.entity.ContentAttribute;
import org.anttribe.cas.console.facade.ContentAttributeFacade;
import org.anttribe.cas.console.facade.assembler.ContentAttributeAssembler;
import org.anttribe.cas.console.facade.dto.ContentAttributeDTO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyong
 * @version 2015年11月6日
 */
@Service
public class ContentAttributeFacadeImpl implements ContentAttributeFacade
{
    @Autowired
    private ContentAttributeApplication contentAttributeApplication;
    
    @Override
    public List<ContentAttributeDTO> listContentAttributes(ContentAttributeDTO contentAttributeDTO)
    {
        // 将对象转换成Map
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("id", contentAttributeDTO.getId());
        criteria.put("name", contentAttributeDTO.getName());
        criteria.put("attrValueType", contentAttributeDTO.getAttrValueType());
        criteria.put("contentType", contentAttributeDTO.getContentType());
        
        List<ContentAttribute> contentAttributes = contentAttributeApplication.listContentAttributes(criteria);
        return ContentAttributeAssembler.toDTO(contentAttributes);
    }
    
    @Override
    public ContentAttributeDTO loadContentAttribute(ContentAttributeDTO contentAttributeDTO)
    {
        if (null != contentAttributeDTO && !StringUtils.isEmpty(contentAttributeDTO.getId()))
        {
            // 将对象转换成Map
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("id", contentAttributeDTO.getId());
            List<ContentAttribute> contentAttributes = contentAttributeApplication.listContentAttributes(criteria);
            if (!CollectionUtils.isEmpty(contentAttributes))
            {
                return ContentAttributeAssembler.toDTO(contentAttributes.get(0));
            }
        }
        return null;
    }
    
    @Override
    public void editContentAttribute(ContentAttributeDTO contentAttributeDTO)
    {
        ContentAttribute contentAttribute = ContentAttributeAssembler.toEntity(contentAttributeDTO);
        if (null != contentAttribute)
        {
            contentAttributeApplication.persistentContentAttribute(contentAttribute);
        }
    }
    
    @Override
    public void deleteContentAttribute(ContentAttributeDTO contentAttributeDTO)
    {
        ContentAttribute contentAttribute = ContentAttributeAssembler.toEntity(contentAttributeDTO);
        if (null != contentAttribute)
        {
            contentAttributeApplication.deleteContentAttribute(contentAttribute);
        }
    }
    
}