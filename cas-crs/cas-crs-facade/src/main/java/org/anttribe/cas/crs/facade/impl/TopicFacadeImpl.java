/*
 * 文  件   名: TopicFacadeImpl.java
 * 版         本 : cas-crs-facade.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年9月13日
 */
package org.anttribe.cas.crs.facade.impl;

import java.util.List;

import org.anttribe.cas.base.application.TopicApplication;
import org.anttribe.cas.base.core.entity.Topic;
import org.anttribe.cas.crs.facade.TopicFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyong
 * @version 2015年9月13日
 */
@Service("topicFacade")
public class TopicFacadeImpl implements TopicFacade
{
    @Autowired
    private TopicApplication topicApplication;
    
    @Override
    public List<Topic> listAllTopics()
    {
        return topicApplication.listAllTopics();
    }

    @Override
    public List<Topic> listAllParentTopics()
    {
        return topicApplication.listAllParentTopics();
    }
    
}