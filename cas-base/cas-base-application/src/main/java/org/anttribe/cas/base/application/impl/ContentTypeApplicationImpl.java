/*
 * 文  件   名: ContentTypeApplicationImpl.java
 * 版         本 : (Anttribe).cas-base-application All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月5日
 */
package org.anttribe.cas.base.application.impl;

import org.anttribe.cas.base.application.IContentTypeApplication;
import org.anttribe.cas.base.core.dao.IContentTypeDao;
import org.anttribe.cas.base.core.entity.ContentType;
import org.anttribe.vigor.infra.common.service.AbstractServiceImpl;
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
        // TODO Auto-generated method stub
        return false;
    }
    
    @Override
    public boolean validateCodeUnique(ContentType contentType)
    {
        // TODO Auto-generated method stub
        return false;
    }
    
}