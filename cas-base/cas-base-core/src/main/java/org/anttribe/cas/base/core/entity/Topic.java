/*
 * 文  件   名: Topic.java
 * 版         本 : (Anttribe).cas-base-core All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年8月4日
 */
package org.anttribe.cas.base.core.entity;

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
     * 主题名称
     */
    private String topicName;
    
    /**
     * 优先级
     */
    private String priority;
}