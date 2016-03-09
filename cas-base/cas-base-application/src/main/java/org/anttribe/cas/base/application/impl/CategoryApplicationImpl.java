/*
 * 文  件   名: CategoryApplicationImpl.java
 * 版         本 : (Anttribe).cas-base-application All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月19日
 */
package org.anttribe.cas.base.application.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.application.ICategoryApplication;
import org.anttribe.cas.base.core.dao.ICategoryDao;
import org.anttribe.cas.base.core.entity.Category;
import org.anttribe.vigor.infra.common.service.AbstractServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhaoyong
 * @version 2015年10月19日
 */
@Service
public class CategoryApplicationImpl extends AbstractServiceImpl<ICategoryDao, Category> implements ICategoryApplication
{
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void persistentEntity(Category entity)
    {
        super.persistentEntity(entity);
        
        // 处理分类treeCode值
        this.processCategoryTreeCode(entity);
        dao.update(entity);
    }
    
    /**
     * 处理分类treeCode值
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
                parent = this.findEntity(criteria);
                if (null != parent)
                {
                    treeCode += StringUtils.isEmpty(parent.getTreeCode()) ? "" : parent.getTreeCode();
                }
            }
            treeCode += "-" + category.getId();
            category.setTreeCode(treeCode);
        }
    }
    
    @Override
    public boolean validateNameUnique(Category category)
    {
        logger.debug("validate category's name unique, param: [{}]", category);
        
        if (null != category && !StringUtils.isEmpty(category.getName()))
        {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("notId", category.getId());
            criteria.put("uniqueName", category.getName());
            List<Category> categorys = dao.find(criteria);
            if (CollectionUtils.isEmpty(categorys))
            {
                return true;
            }
        }
        return false;
    }
    
}