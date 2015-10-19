/*
 * 文  件   名: CategoryApplicationImpl.java
 * 版         本 : (Anttribe).cas-base-application All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月19日
 */
package org.anttribe.cas.base.application.impl;

import java.util.List;

import org.anttribe.cas.base.application.CategoryApplication;
import org.anttribe.cas.base.core.entity.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhaoyong
 * @version 2015年10月19日
 */
public class CategoryApplicationImpl implements CategoryApplication
{
    
    private static Logger logger = LoggerFactory.getLogger(CategoryApplicationImpl.class);
    
    @Override
    public List<Category> listCategories(String parent)
    {
        logger.debug("listing categories refer to parent, param: parent[{}]", parent);
        return Category.listCategoriesByParent(parent);
    }
}