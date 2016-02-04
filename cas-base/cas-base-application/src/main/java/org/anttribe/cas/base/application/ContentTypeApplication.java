/*
 * 文  件   名: ContentTypeApplication.java
 * 版       本: Copyright (c) (Anttribe)cas v1.0. All rights reserved.
 * 描       述: <描述>
 * 修   改  人: zhaoyong(anshenglimin@163.com)
 * 修 改 时 间: 2016-02-04
 */
package org.anttribe.cas.base.application;

import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.core.entity.ContentType;
import org.anttribe.cas.base.infra.entity.Pagination;

/**
 * ContentType逻辑层处理接口
 * 
 * @author zhaoyong
 * @version 1.0
 */
public interface ContentTypeApplication
{
    
    /**
     * 列表数据
     * 
     * @param criteria Map<String, Object>
     * @return List<ContentType>
     */
    List<ContentType> listContentTypes(Map<String, Object> criteria);
    
    /**
     * 根据分类参数列表数据
     * 
     * @param criteria Map<String, Object>
     * @return Pagination
     */
    Pagination listContentTypes(Map<String, Object> criteria, Pagination pagination);
    
    /**
     * 根据条件获取单条数据
     * 
     * @param criteria Map<String, Object>
     * @return ContentType
     */
    ContentType findContentType(Map<String, Object> criteria);
    
    /**
     * 持久化数据
     * 
     * @param contentType ContentType
     */
    void persistentContentType(ContentType contentType);
    
    /**
     * 删除数据
     * 
     * @param contentType ContentType
     */
    void deleteContentType(ContentType contentType);
    
}