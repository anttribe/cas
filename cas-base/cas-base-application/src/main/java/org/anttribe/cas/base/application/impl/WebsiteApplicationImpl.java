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

import org.anttribe.cas.base.application.WebsiteApplication;
import org.anttribe.cas.base.core.entity.Website;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyong
 * @version 2015年7月23日
 */
@Service
public class WebsiteApplicationImpl implements WebsiteApplication
{
    private static Logger logger = LoggerFactory.getLogger(WebsiteApplicationImpl.class);
    
    @Override
    public List<Website> listAvailableWebsites()
    {
        logger.debug("listing available websites.");
        
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("available", true);
        return Website.find(Website.class, criteria);
    }
}