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
import org.anttribe.cas.base.infra.entity.Pagination;

/**
 * @author zhaoyong
 * @version 2015年11月5日
 */
public interface ContentAttributeApplication
{
    /**
     * 列表数据
     * 
     * @param criteria Map<String, Object>
     * @return List<ContentAttribute>
     */
    List<ContentAttribute> listContentAttributes(Map<String, Object> criteria);
    
    /**
     * 根据分类参数列表数据
     * 
     * @param criteria Map<String, Object>
     * @return Pagination
     */
    Pagination listContentAttributes(Map<String, Object> criteria, Pagination pagination);
    
    /**
     * 根据条件获取单条数据
     * 
     * @param criteria Map<String, Object>
     * @return ContentAttribute
     */
    ContentAttribute findContentAttribute(Map<String, Object> criteria);
    
    /**
     * 持久化数据
     * 
     * @param contentAttribute ContentAttribute
     */
    void persistentContentAttribute(ContentAttribute contentAttribute);
    
    /**
     * 删除数据
     * 
     * @param contentAttribute ContentAttribute
     */
    void deleteContentAttribute(ContentAttribute contentAttribute);
    
}