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

import org.anttribe.cas.base.application.IContentTypeApplication;
import org.anttribe.cas.base.core.dao.IContentTypeDao;
import org.anttribe.cas.base.core.entity.ContentType;
import org.anttribe.vigor.infra.common.service.AbstractServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyong
 * @version 2015年11月5日
 */
@Service
public class ContentTypeApplicationImpl extends AbstractServiceImpl<IContentTypeDao, ContentType>
    implements IContentTypeApplication
{
    
    @Override
    public boolean validateNameUnique(ContentType contentType)
    {
        logger.debug("validate contentType's name unique, param: [{}]", contentType);
        if (null != contentType && !StringUtils.isEmpty(contentType.getName()))
        {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("notId", contentType.getId());
            criteria.put("uniqueName", contentType.getName());
            List<ContentType> contentTypes = dao.find(criteria);
            if (CollectionUtils.isEmpty(contentTypes))
            {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean validateCodeUnique(ContentType contentType)
    {
        logger.debug("validate contentType's code unique, param: [{}]", contentType);
        if (null != contentType && !StringUtils.isEmpty(contentType.getCode()))
        {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("notId", contentType.getId());
            criteria.put("uniqueCode", contentType.getCode());
            List<ContentType> contentTypes = dao.find(criteria);
            if (CollectionUtils.isEmpty(contentTypes))
            {
                return true;
            }
        }
        return false;
    }
    
}