/*
 * 文  件   名: ContentTypeApplicationImpl.java
 * 版         本 : (Anttribe).cas-base-application All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月5日
 */
package org.anttribe.cas.base.application.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.application.ContentTypeApplication;
import org.anttribe.cas.base.core.entity.ContentType;
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
 * @version 2015年11月5日
 */
@Service
public class ContentTypeApplicationImpl implements ContentTypeApplication
{
    
    private static Logger logger = LoggerFactory.getLogger(ContentTypeApplicationImpl.class);
    
    @Override
    public List<ContentType> listContentTypes(Map<String, Object> criteria)
    {
        logger.debug("listing contentTypes by criteria, criteria[{}]", criteria);
        if (null == criteria)
        {
            criteria = new HashMap<String, Object>();
        }
        return ContentType.find(ContentType.class, criteria);
    }
    
    @Override
    public Pagination listContentTypes(Map<String, Object> criteria, Pagination pagination)
    {
        logger.debug("listing ContentTypes refer to criteria and pagination, param: criteria[{}], pagination[{}]",
            criteria,
            pagination);
            
        if (null == criteria)
        {
            criteria = new HashMap<String, Object>();
        }
        List<ContentType> tempContentTypes = ContentType.find(ContentType.class, criteria, pagination);
        int totalCount = ContentType.count(ContentType.class, criteria);
        if (null == pagination)
        {
            pagination = new Pagination();
        }
        pagination.setTotalRecords(totalCount);
        pagination.setDatas(tempContentTypes);
        
        return pagination;
    }
    
    @Override
    public ContentType findContentType(Map<String, Object> criteria)
    {
        logger.debug("find ContentType refer to criteria, param: criteria[{}]", criteria);
        
        if (null == criteria)
        {
            // 参数错误
            return null;
        }
        
        List<ContentType> tempContentTypes = ContentType.find(ContentType.class, criteria);
        if (!CollectionUtils.isEmpty(tempContentTypes))
        {
            return tempContentTypes.get(0);
        }
        return null;
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
        
        if (null == contentType.getId())
        {
            contentType.save();
            logger.debug("contentType id not there, then save new contentType to DB, contentType: {}",
                contentType.getId());
            return;
        }
        
        ContentType tempContentType = ContentType.load(ContentType.class, contentType.getId());
        if (null == tempContentType)
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