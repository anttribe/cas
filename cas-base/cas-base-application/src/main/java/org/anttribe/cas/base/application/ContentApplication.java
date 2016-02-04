/*
 * 文  件   名: ContentApplication.java
 * 版       本: Copyright (c) (Anttribe)cas v1.0. All rights reserved.
 * 描       述: <描述>
 * 修   改  人: zhaoyong(anshenglimin@163.com)
 * 修 改 时 间: 2016-02-04
 */
package org.anttribe.cas.base.application;

import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.core.entity.Content;
import org.anttribe.cas.base.infra.entity.Pagination;

/**
 * Content逻辑层处理接口
 * 
 * @author zhaoyong
 * @version 1.0
 */
public interface ContentApplication
{

    /**
     * 列表数据
     * 
     * @param criteria Map<String, Object>
	 * @return List<Content>
     */
    List<Content> listContents(Map<String, Object> criteria);
	
	/**
     * 根据分类参数列表数据
     * 
     * @param criteria Map<String, Object>
	 * @return Pagination
     */
    Pagination listContents(Map<String, Object> criteria, Pagination pagination);
	
	/**
     * 根据条件获取单条数据
     * 
     * @param criteria Map<String, Object>
	 * @return Content
     */
	Content findContent(Map<String, Object> criteria);
	
	/**
     * 持久化数据
     * 
     * @param content Content
     */
    void persistentContent(Content content);
    
    /**
     * 删除数据
     * 
     * @param content Content
     */
    void deleteContent(Content content);

}