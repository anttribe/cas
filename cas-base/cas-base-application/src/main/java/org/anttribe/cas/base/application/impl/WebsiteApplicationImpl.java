/*
 * 文  件   名: WebsiteApplicationImpl.java
 * 版         本: cas-base-application(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月23日
 */
package org.anttribe.cas.base.application.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.application.IWebsiteApplication;
import org.anttribe.cas.base.core.dao.IWebsiteDao;
import org.anttribe.cas.base.core.entity.Website;
import org.anttribe.vigor.infra.common.service.AbstractServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyong
 * @version 2015年7月23日
 */
@Service
public class WebsiteApplicationImpl extends AbstractServiceImpl<IWebsiteDao, Website> implements IWebsiteApplication
{
    
    @Override
    public boolean validateNameUnique(Website website)
    {
        logger.debug("validate website's name unique, param: [{}]", website);
        
        if (null != website && !StringUtils.isEmpty(website.getSiteName()))
        {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("notId", website.getId());
            criteria.put("uniqueName", website.getSiteName());
            List<Website> websites = dao.find(criteria);
            if (CollectionUtils.isEmpty(websites))
            {
                return true;
            }
        }
        return false;
    }
}