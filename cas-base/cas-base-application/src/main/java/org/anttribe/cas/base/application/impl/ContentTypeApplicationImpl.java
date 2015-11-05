/*
 * 文  件   名: ContentTypeApplicationImpl.java
 * 版         本 : (Anttribe).cas-base-application All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月5日
 */
package org.anttribe.cas.base.application.impl;

import java.util.List;

import org.anttribe.cas.base.application.ContentTypeApplication;
import org.anttribe.cas.base.core.entity.Category;
import org.anttribe.cas.base.core.entity.ContentType;
import org.anttribe.cas.base.core.errorno.SystemErrorNo;
import org.anttribe.cas.base.core.exception.UnifyException;
import org.anttribe.component.lang.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyong
 * @version 2015年11月5日
 */
@Service
public class ContentTypeApplicationImpl implements ContentTypeApplication
{
    
    private static Logger logger = LoggerFactory.getLogger(ContentTypeApplicationImpl.class);
    
    @Override
    public List<ContentType> listContentTypes()
    {
        logger.debug("listing all contentTypes");
        return ContentType.findAll(ContentType.class);
    }
    
    @Override
    public void persistentContentType(ContentType contentType)
    {
        logger.debug("persistenting contentType to DB, param: contentType[{}]", contentType);
        if (null == contentType)
        {
            logger.warn("persistenting contentType to DB, param contentType is null.");
            throw new UnifyException(SystemErrorNo.PARAMETER_IS_NULL);
        }
        
        if (StringUtils.isEmpty(contentType.getName()))
        {
            logger.warn("persistenting contentType to DB, param contentType name is null.");
            throw new UnifyException(SystemErrorNo.PARAMETER_LOGIC_ERROR);
        }
        
        if (StringUtils.isEmpty(contentType.getId()))
        {
            contentType.setId(UUIDUtils.getRandomUUID());
            contentType.save();
            
            logger.debug("contentType id not there, then save new contentType to DB, contentType: {}",
                contentType.getId());
            return;
        }
        
        ContentType tempContentType = ContentType.load(Category.class, contentType.getId());
        if (null != tempContentType)
        {
            contentType.save();
            logger.debug("contentType not exist in DB, then save new contentType to DB, contentType: {}",
                contentType.getId());
            return;
        }
        contentType.update();
        logger.debug("contentType exist in DB, then update contentType info, contentType: {}", contentType.getId());
    }
    
    @Override
    public void deleteContentType(ContentType contentType)
    {
        logger.debug("deleting contentType from DB, param: contentType[{}]", contentType);
        
        if (null != contentType)
        {
            contentType.remove();
        }
    }
    
}