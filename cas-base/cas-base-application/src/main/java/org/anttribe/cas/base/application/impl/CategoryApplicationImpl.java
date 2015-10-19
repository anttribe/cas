/*
 * 文  件   名: CategoryApplicationImpl.java
 * 版         本 : (Anttribe).cas-base-application All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月19日
 */
package org.anttribe.cas.base.application.impl;

import java.util.Date;
import java.util.List;

import org.anttribe.cas.base.application.CategoryApplication;
import org.anttribe.cas.base.core.entity.Category;
import org.anttribe.component.lang.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyong
 * @version 2015年10月19日
 */
@Service
public class CategoryApplicationImpl implements CategoryApplication
{
    
    private static Logger logger = LoggerFactory.getLogger(CategoryApplicationImpl.class);
    
    @Override
    public List<Category> listCategories(String parent)
    {
        logger.debug("listing categories refer to parent, param: parent[{}]", parent);
        return Category.listCategoriesByParent(parent);
    }
    
    @Override
    public void persistentCategory(Category category)
    {
        logger.debug("persistenting category to DB, param: category[{}]", category);
        
        if (StringUtils.isEmpty(category.getId()))
        {
            category.setId(UUIDUtils.getRandomUUID());
            category.setCreateTime(new Date());
            category.save();
            
            logger.debug("category's id not there, then save new category to DB, category: {}", category.getId());
            return;
        }
        
        Category tempCategory = Category.load(Category.class, category.getId());
        if (null != tempCategory)
        {
            category.setCreateTime(new Date());
            category.save();
            logger.debug("category not exist in DB, then save new category to DB, category: {}", category.getId());
            return;
        }
        category.update();
        logger.debug("category exist in DB, then update category info, category: {}", category.getId());
    }
    
    @Override
    public void deleteCategory(Category category)
    {
        logger.debug("deleting category from DB, param: category[{}]", category);
        
        if (null != category)
        {
            category.remove();
        }
    }
}