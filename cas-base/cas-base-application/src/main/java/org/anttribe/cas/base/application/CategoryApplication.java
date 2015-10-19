/*
 * 文  件   名: CategoryApplication.java
 * 版         本 : (Anttribe).cas-base-application All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月19日
 */
package org.anttribe.cas.base.application;

import java.util.List;

import org.anttribe.cas.base.core.entity.Category;

/**
 * @author zhaoyong
 * @version 2015年10月19日
 */
public interface CategoryApplication
{
    /**
     * 根据父分类列表分类信息
     * 
     * @param parent
     * @return List<Category>
     */
    public List<Category> listCategories(String parent);
}