/*
 * 文  件   名: ContentAttributeApplication.java
 * 版         本 : cas-base-application.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月5日
 */
package org.anttribe.cas.base.application;

import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.core.entity.ContentAttribute;

/**
 * @author zhaoyong
 * @version 2015年11月5日
 */
public interface ContentAttributeApplication
{
    /**
     * 根据条件查询内容属性
     * 
     * @param criteria
     * @return List<ContentAttribute>
     */
    List<ContentAttribute> listContentAttributes(Map<String, Object> criteria);
    
    /**
     * 持久化内容属性信息
     * 
     * @param contentAttribute ContentAttribute
     */
    void persistentContentAttribute(ContentAttribute contentAttribute);
    
    /**
     * 删除分类信息
     * 
     * @param contentAttribute ContentAttribute
     */
    void deleteContentAttribute(ContentAttribute contentAttribute);
}