/*
 * 文  件   名: CrawlerApplicationImpl.java
 * 版         本 : (Anttribe).cas-base-application All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.base.application.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.application.ICrawlerApplication;
import org.anttribe.cas.base.core.dao.ICrawlerDao;
import org.anttribe.cas.base.core.entity.Crawler;
import org.anttribe.vigor.infra.common.service.AbstractServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyong
 * @version 2015年11月6日
 */
@Service
public class CrawlerApplicationImpl extends AbstractServiceImpl<ICrawlerDao, Crawler> implements ICrawlerApplication
{
    
    @Override
    public boolean validateTitleUnique(Crawler crawler)
    {
        logger.debug("validate crawler's title unique, param: [{}]", crawler);
        
        if (null != crawler && !StringUtils.isEmpty(crawler.getTitle()))
        {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("notId", crawler.getId());
            criteria.put("uniqueTitle", crawler.getTitle());
            List<Crawler> crawlers = dao.find(criteria);
            if (CollectionUtils.isEmpty(crawlers))
            {
                return true;
            }
        }
        return false;
    }
    
}