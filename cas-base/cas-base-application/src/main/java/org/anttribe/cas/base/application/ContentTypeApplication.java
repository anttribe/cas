/*
 * 文  件   名: ContentTypeApplication.java
 * 版         本 : cas-base-application.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月4日
 */
package org.anttribe.cas.base.application;

import java.util.List;

import org.anttribe.cas.base.core.entity.ContentType;

/**
 * @author zhaoyong
 * @version 2015年11月4日
 */
public interface ContentTypeApplication
{
    /**
     * 列表内容类型
     * 
     * @return List<ContentType>
     */
    List<ContentType> listContentTypes();
    
    /**
     * 持久化内容类型
     * 
     * @param ContentType ContentType
     */
    void persistentContentType(ContentType contentType);
    
    /**
     * 删除内容类型
     * 
     * @param contentType ContentType
     */
    void deleteContentType(ContentType contentType);
}