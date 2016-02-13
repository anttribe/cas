/*
 * 文  件   名: WebsiteApplicationImpl.java
 * 版         本: cas-base-application(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月23日
 */
package org.anttribe.cas.base.application.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.application.WebsiteApplication;
import org.anttribe.cas.base.core.entity.Website;
import org.anttribe.cas.base.infra.entity.Pagination;
import org.anttribe.cas.base.infra.errorno.SystemErrorNo;
import org.anttribe.cas.base.infra.exception.UnifyException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
    public List<Website> listWebsites(Map<String, Object> criteria)
    {
        logger.debug("listing websites by criteria, params:[{}].", criteria);
        return Website.find(Website.class, criteria);
    }
    
    @Override
    public Pagination listWebsites(Map<String, Object> criteria, Pagination pagination)
    {
        List<Website> tempWebsites = Website.find(Website.class, criteria, pagination);
        int totalCount = Website.count(Website.class, criteria);
        if (null == pagination)
        {
            pagination = new Pagination();
        }
        pagination.setTotalRecords(totalCount);
        pagination.setDatas(tempWebsites);
        
        return pagination;
    }
    
    @Override
    public Website findWebsite(Map<String, Object> criteria)
    {
        logger.debug("find Website refer to criteria, param: criteria[{}]", criteria);
        
        if (null == criteria)
        {
            // 参数错误
            return null;
        }
        
        List<Website> tempWebsites = Website.find(Website.class, criteria);
        if (!CollectionUtils.isEmpty(tempWebsites))
        {
            return tempWebsites.get(0);
        }
        return null;
    }
    
    @Override
    public void persistentWebsite(Website website)
    {
        logger.debug("persistenting website to DB, param: website[{}]", website);
        if (null == website)
        {
            logger.warn("persistenting website to DB, param website is null.");
            throw new UnifyException(SystemErrorNo.PARAMETER_IS_NULL);
        }
        if (StringUtils.isEmpty(website.getSiteName()))
        {
            logger.warn("persistenting website to DB, param website name is null.");
            throw new UnifyException(SystemErrorNo.PARAMETER_LOGIC_ERROR);
        }
        
        if (null == website.getId())
        {
            website.setCreateTime(new Date());
            website.save();
            logger.debug("website's id not there, then save new website to DB, website: {}", website.getId());
            return;
        }
        
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("id", website.getId());
        Website tempWebsite =this.findWebsite(criteria);
        if (null == tempWebsite)
        {
            website.setCreateTime(new Date());
            website.save();
            logger.debug("website not exist in DB, then save new website to DB, website: {}", website.getId());
            return;
        }
        website.update();
        logger.debug("website exist in DB, then update category info, category: {}", website.getId());
    }
    
    @Override
    public void deleteWebsite(Website website)
    {
        logger.debug("deleting website from DB, param: website[{}]", website);
        
        if (null != website)
        {
            website.remove();
        }
    }
    
}