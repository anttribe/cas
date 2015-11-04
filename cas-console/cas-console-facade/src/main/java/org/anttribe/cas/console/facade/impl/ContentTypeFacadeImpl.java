/*
 * 文  件   名: ContentTypeFacadeImpl.java
 * 版         本 : (Anttribe).cas-console-facade All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月4日
 */
package org.anttribe.cas.console.facade.impl;

import java.util.List;

import org.anttribe.cas.base.application.ContentTypeApplication;
import org.anttribe.cas.base.core.entity.ContentType;
import org.anttribe.cas.console.facade.ContentTypeFacade;
import org.anttribe.cas.console.facade.assembler.ContentTypeAssembler;
import org.anttribe.cas.console.facade.dto.ContentTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyong
 * @version 2015年11月4日
 */
@Service
public class ContentTypeFacadeImpl implements ContentTypeFacade
{
    @Autowired
    private ContentTypeApplication contentTypeApplication;
    
    @Override
    public List<ContentTypeDTO> listContentTypes()
    {
        List<ContentType> ContentTypes = contentTypeApplication.listContentTypes();
        return ContentTypeAssembler.toDTO(ContentTypes);
    }
    
    @Override
    public void editContentType(ContentTypeDTO contentTypeDTO)
    {
        ContentType contentType = ContentTypeAssembler.toEntity(contentTypeDTO);
        if (null != contentType)
        {
            contentTypeApplication.persistentContentType(contentType);
        }
    }
    
    @Override
    public void deleteContentType(ContentTypeDTO contentTypeDTO)
    {
        ContentType contentType = ContentTypeAssembler.toEntity(contentTypeDTO);
        if (null != contentType)
        {
            contentTypeApplication.deleteContentType(contentType);
        }
    }
    
}