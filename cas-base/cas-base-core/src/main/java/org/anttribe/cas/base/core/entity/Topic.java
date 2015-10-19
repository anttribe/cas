/*
 * 文  件   名: Topic.java
 * 版         本 : (Anttribe).cas-base-core All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年8月4日
 */
package org.anttribe.cas.base.core.entity;

import java.util.ArrayList;
import java.util.List;

import org.anttribe.opengadget.core.domain.MybatisAbstractEntity;

/**
 * @author zhaoyong
 * @version 2015年8月4日
 */
public class Topic extends MybatisAbstractEntity
{
    /**
     * 话题id
     */
    private String topicId;
    
    /**
     * 话题名称
     */
    private String topicName;
    
    /**
     * 父话题
     */
    private Topic parent;
    
    /**
     * 列表所有父话题
     * 
     * @return List<Topic>
     */
    public static List<Topic> listAllParentTopics()
    {
        List<Topic> topics = new ArrayList<Topic>();
        topics = Topic.getSqlSessionTemplate().selectList(Topic.class.getCanonicalName() + ".queryAllParent");
        return topics;
    }
    
    public String getTopicId()
    {
        return topicId;
    }
    
    public void setTopicId(String topicId)
    {
        this.topicId = topicId;
    }
    
    public String getTopicName()
    {
        return topicName;
    }
    
    public void setTopicName(String topicName)
    {
        this.topicName = topicName;
    }
    
    public Topic getParent()
    {
        return parent;
    }
    
    public void setParent(Topic parent)
    {
        this.parent = parent;
    }
}