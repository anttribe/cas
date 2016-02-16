/*
 * 文  件   名: CategoryApplicationImpl.java
 * 版         本 : (Anttribe).cas-base-application All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月19日
 */
package org.anttribe.cas.base.application.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.application.CategoryApplication;
import org.anttribe.cas.base.core.entity.Category;
import org.anttribe.cas.base.infra.entity.Pagination;
import org.anttribe.cas.base.infra.errorno.SystemErrorNo;
import org.anttribe.cas.base.infra.exception.UnifyException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
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
    public List<Category> listCategorys(Map<String, Object> criteria)
    {
        logger.debug("listing categories refer to criteria, param: [{}]", criteria);
        if (null == criteria)
        {
            criteria = new HashMap<String, Object>();
        }
        return Category.find(Category.class, criteria);
    }
    
    @Override
    public Pagination listCategorys(Map<String, Object> criteria, Pagination pagination)
    {
        logger.debug("listing Categorys refer to criteria and pagination, param: criteria[{}], pagination[{}]",
            criteria,
            pagination);
            
        if (null == criteria)
        {
            criteria = new HashMap<String, Object>();
        }
        List<Category> tempCategorys = Category.find(Category.class, criteria, pagination);
        int totalCount = Category.count(Category.class, criteria);
        if (null == pagination)
        {
            pagination = new Pagination();
        }
        pagination.setTotalRecords(totalCount);
        pagination.setDatas(tempCategorys);
        
        return pagination;
    }
    
    @Override
    public Category findCategory(Map<String, Object> criteria)
    {
        logger.debug("find Category refer to criteria, param: criteria[{}]", criteria);
        
        if (null == criteria)
        {
            // 参数错误
            return null;
        }
        
        List<Category> tempCategorys = Category.find(Category.class, criteria);
        if (!CollectionUtils.isEmpty(tempCategorys))
        {
            return tempCategorys.get(0);
        }
        return null;
    }
    
    @Override
    public void persistentCategory(Category category)
    {
        logger.debug("persistenting category to DB, param: category[{}]", category);
        
        // 参数校验
        if (null == category)
        {
            logger.warn("persistenting category to DB, param category is null.");
            throw new UnifyException(SystemErrorNo.PARAMETER_IS_NULL);
        }
        if (StringUtils.isEmpty(category.getName()))
        {
            logger.warn("persistenting category to DB, param category's name is null.");
            throw new UnifyException(SystemErrorNo.PARAMETER_LOGIC_ERROR);
        }
        
        if (null == category.getId())
        {
            category.setCreateTime(new Date());
            category.save();
            logger.debug("category's id not there, then save new category to DB, category: {}", category.getId());
            this.processCategoryTreeCode(category);
        }
        else
        {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("id", category.getId());
            Category tempCategory = this.findCategory(criteria);
            if (null == tempCategory)
            {
                category.setCreateTime(new Date());
                category.save();
                logger.debug("category not exist in DB, then save new category to DB, category: {}", category.getId());
                this.processCategoryTreeCode(category);
            }
        }
        category.update();
        logger.debug("category exist in DB, then update category info, category: {}", category.getId());
    }
    
    /**
     * 处理分类的treeCode
     * 
     * @param category
     */
    private void processCategoryTreeCode(Category category)
    {
        if (null != category && null != category.getId())
        {
            String treeCode = "";
            Category parent = category.getParent();
            if (null != parent && null != parent.getId())
            {
                Map<String, Object> criteria = new HashMap<String, Object>();
                criteria.put("id", parent.getId());
                parent = this.findCategory(criteria);
                if (null != parent)
                {
                    treeCode = treeCode + (StringUtils.isEmpty(parent.getTreeCode()) ? "" : parent.getTreeCode());
                }
            }
            treeCode = treeCode + "-" + category.getId();
            category.setTreeCode(treeCode);
        }
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