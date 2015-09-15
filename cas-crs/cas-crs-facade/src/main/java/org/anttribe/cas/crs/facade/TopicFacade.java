/*
 * 文  件   名: TopicFacade.java
 * 版         本 : (Anttribe).cas-crs-facade All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年8月4日
 */
package org.anttribe.cas.crs.facade;

import java.util.List;

import org.anttribe.cas.base.core.entity.Topic;

/**
 * @author zhaoyong
 * @version 2015年8月4日
 */
public interface TopicFacade
{
    List<Topic> listAllTopics();
    
    /**
     * 获取所有父主题
     * 
     * @return List<Topic>
     */
    List<Topic> listAllParentTopics();
}