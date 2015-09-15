/*
 * 文  件   名: TopicApplication.java
 * 版         本 : cas-base-application.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年9月13日
 */
package org.anttribe.cas.base.application;

import java.util.List;

import org.anttribe.cas.base.core.entity.Topic;

/**
 * @author zhaoyong
 * @version 2015年9月13日
 */
public interface TopicApplication
{
    /**
     * 列表所有topic
     * 
     * @return List<Topic>
     */
    List<Topic> listAllTopics();
    
    /**
     * 列表所有父Topic
     * 
     * @return List<Topic>
     */
    List<Topic> listAllParentTopics();
}