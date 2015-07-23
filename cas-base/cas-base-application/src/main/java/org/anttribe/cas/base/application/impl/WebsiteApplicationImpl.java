/*
 * 文  件   名: WebsiteApplicationImpl.java
 * 版         本: cas-base-application(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月23日
 */
package org.anttribe.cas.base.application.impl;

import java.util.List;

import org.anttribe.cas.base.application.WebsiteApplication;
import org.anttribe.cas.base.core.entity.Website;

/**
 * @author zhaoyong
 * @version 2015年7月23日
 */
public class WebsiteApplicationImpl implements WebsiteApplication
{
    
    @Override
    public List<Website> listAvailableWebsites()
    {
        return Website.findAll(Website.class);
    }
    
}