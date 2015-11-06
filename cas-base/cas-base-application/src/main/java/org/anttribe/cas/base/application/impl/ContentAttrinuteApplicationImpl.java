/*
 * 文  件   名: ContentAttrinuteApplicationImpl.java
 * 版         本 : (Anttribe).cas-base-application All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.base.application.impl;

import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.application.ContentAttributeApplication;
import org.anttribe.cas.base.core.entity.ContentAttribute;
import org.anttribe.cas.base.core.errorno.SystemErrorNo;
import org.anttribe.cas.base.core.exception.UnifyException;
import org.anttribe.component.lang.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyong
 * @version 2015年11月6日
 */
@Service
public class ContentAttrinuteApplicationImpl implements ContentAttributeApplication
{
    
    private static Logger logger = LoggerFactory.getLogger(ContentAttrinuteApplicationImpl.class);
    
    @Override
    public List<ContentAttribute> listContentAttributes(Map<String, Object> criteria)
    {
        logger.debug("listing contentAttributes by criteria, param: [{}]", criteria);
        return ContentAttribute.find(ContentAttribute.class, criteria);
    }
    
    @Override
    public void persistentContentAttribute(ContentAttribute contentAttribute)
    {
        logger.debug("persistenting contentAttribute to DB, param: [{}]", contentAttribute);
        if (null == contentAttribute)
        {
            logger.warn("persistenting contentAttribute to DB, param contentAttribute is null.");
            throw new UnifyException(SystemErrorNo.PARAMETER_IS_NULL);
        }
        
        if (StringUtils.isEmpty(contentAttribute.getName()) || null == contentAttribute.getContentType())
        {
            logger.warn("persistenting contentAttribute to DB, param contentAttribute's name or contentType is null.");
            throw new UnifyException(SystemErrorNo.PARAMETER_LOGIC_ERROR);
        }
        
        if (StringUtils.isEmpty(contentAttribute.getId()))
        {
            contentAttribute.setId(UUIDUtils.getRandomUUID());
            contentAttribute.save();
            
            logger.debug("contentAttribute id not there, then save new contentAttribute to DB, contentAttribute: {}",
                contentAttribute.getId());
            return;
        }
        
        ContentAttribute tempContentAttribute = ContentAttribute.load(ContentAttribute.class, contentAttribute.getId());
        if (null == tempContentAttribute)
        {
            contentAttribute.save();
            logger.debug("contentAttribute not exist in DB, then save new contentAttribute to DB, contentAttribute: {}",
                contentAttribute.getId());
            return;
        }
        contentAttribute.update();
        logger.debug("contentAttribute exist in DB, then update contentAttribute info, contentAttribute: {}",
            contentAttribute.getId());
    }
    
    @Override
    public void deleteContentAttribute(ContentAttribute contentAttribute)
    {
        logger.debug("deleting contentAttribute from DB, param: [{}]", contentAttribute);
        
        if (null != contentAttribute)
        {
            contentAttribute.remove();
        }
    }
}