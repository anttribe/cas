/*
 * 文  件   名: ContentAttrinuteApplicationImpl.java
 * 版         本 : (Anttribe).cas-base-application All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.base.application.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.application.ContentAttributeApplication;
import org.anttribe.cas.base.core.entity.ContentAttribute;
import org.anttribe.cas.base.infra.entity.Pagination;
import org.anttribe.cas.base.infra.errorno.SystemErrorNo;
import org.anttribe.cas.base.infra.exception.UnifyException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
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
        if (null == criteria)
        {
            criteria = new HashMap<String, Object>();
        }
        return ContentAttribute.find(ContentAttribute.class, criteria);
    }
    
    @Override
    public Pagination listContentAttributes(Map<String, Object> criteria, Pagination pagination)
    {
        logger.debug("listing ContentAttributes refer to criteria and pagination, param: criteria[{}], pagination[{}]",
            criteria,
            pagination);
            
        if (null == criteria)
        {
            criteria = new HashMap<String, Object>();
        }
        List<ContentAttribute> tempContentAttributes =
            ContentAttribute.find(ContentAttribute.class, criteria, pagination);
        int totalCount = ContentAttribute.count(ContentAttribute.class, criteria);
        if (null == pagination)
        {
            pagination = new Pagination();
        }
        pagination.setTotalRecords(totalCount);
        pagination.setDatas(tempContentAttributes);
        
        return pagination;
    }
    
    @Override
    public ContentAttribute findContentAttribute(Map<String, Object> criteria)
    {
        logger.debug("find ContentAttr refer to criteria, param: criteria[{}]", criteria);
        
        if (null == criteria)
        {
            // 参数错误
            return null;
        }
        
        List<ContentAttribute> tempContentAttributes = ContentAttribute.find(ContentAttribute.class, criteria);
        if (!CollectionUtils.isEmpty(tempContentAttributes))
        {
            return tempContentAttributes.get(0);
        }
        return null;
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
        
        if (null == contentAttribute.getId())
        {
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