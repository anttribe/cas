/*
 * 文  件   名: TopicApplicationImpl.java
 * 版         本 : cas-base-application.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年9月13日
 */
package org.anttribe.cas.base.application.impl;

import java.util.List;

import org.anttribe.cas.base.application.TopicApplication;
import org.anttribe.cas.base.core.entity.Topic;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyong
 * @version 2015年9月13日
 */
@Service("topicApplication")
public class TopicApplicationImpl implements TopicApplication
{
    @Override
    public List<Topic> listAllTopics()
    {
        return Topic.findAll(Topic.class);
    }
}