/*
 * 文  件   名: ContentAttrXPathApplicationImpl.java
 * 版         本: cas-base-application(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月23日
 */
package org.anttribe.cas.base.application.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.application.ContentAttrXPathApplication;
import org.anttribe.cas.base.core.entity.ContentAttrXPath;
import org.anttribe.cas.base.core.entity.Website;
import org.anttribe.cas.base.core.errorno.SystemErrorNo;
import org.anttribe.cas.base.core.exception.UnifyException;
import org.apache.commons.collections.CollectionUtils;

/**
 * @author zhaoyong
 * @version 2015年7月23日
 */
public class ContentAttrXPathApplicationImpl implements ContentAttrXPathApplication
{
    
    @Override
    public ContentAttrXPath getContentAttrXPathByWebsite(Website website)
    {
        if (null == website)
        {
            // 参数错误
            throw new UnifyException(SystemErrorNo.PARAMETER_IS_NULL,
                "Invoking ContentAttrXPathApplicationImpl.getContentAttrXPathByWebsite(), param website is null.");
        }
        
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("website", website.getId());
        // 添加参数
        List<ContentAttrXPath> tempList = ContentAttrXPath.find(ContentAttrXPath.class, criteria);
        if (!CollectionUtils.isEmpty(tempList))
        {
            return tempList.get(0);
        }
        return null;
    }
    
}