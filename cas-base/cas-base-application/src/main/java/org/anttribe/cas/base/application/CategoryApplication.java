/*
 * 文  件   名: CategoryApplication.java
 * 版         本 : (Anttribe).cas-base-application All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月19日
 */
package org.anttribe.cas.base.application;

import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.core.entity.Category;

/**
 * @author zhaoyong
 * @version 2015年10月19日
 */
public interface CategoryApplication
{
    /**
     * 根据条件查询分类信息
     * 
     * @param criteria 条件
     * @return List<Category>
     */
    List<Category> listCategories(Map<String, Object> criteria);
    
    /**
     * 持久化分类信息
     * 
     * @param category Category
     */
    void persistentCategory(Category category);
    
    /**
     * 删除分类信息
     * 
     * @param category Category
     */
    void deleteCategory(Category category);
}