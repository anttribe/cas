/*
 * 文  件   名: CategoryFacadeImpl.java
 * 版         本 : (Anttribe).cas-console-facade All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月19日
 */
package org.anttribe.cas.console.facade.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anttribe.cas.base.application.CategoryApplication;
import org.anttribe.cas.base.core.entity.Category;
import org.anttribe.cas.console.facade.CategoryFacade;
import org.anttribe.cas.console.facade.assembler.CategoryAssembler;
import org.anttribe.cas.console.facade.dto.CategoryDTO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyong
 * @version 2015年10月19日
 */
@Service
public class CategoryFacadeImpl implements CategoryFacade
{
    @Autowired
    private CategoryApplication categoryApplication;
    
    @Override
    public List<CategoryDTO> listCategorys(CategoryDTO categoryDTO)
    {
        // 将对象转换成Map
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("id", categoryDTO.getId());
        criteria.put("name", categoryDTO.getName());
        criteria.put("parent", CategoryAssembler.toEntity(categoryDTO.getParent()));
        
        List<Category> categories = categoryApplication.listCategorys(criteria);
        return CategoryAssembler.toDTO(categories);
    }
    
    @Override
    public CategoryDTO loadCategory(CategoryDTO categoryDTO)
    {
        if (null != categoryDTO && null != categoryDTO.getId())
        {
            // 将对象转换成Map
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("id", categoryDTO.getId());
            Category category = categoryApplication.findCategory(criteria);
            if (null != category)
            {
                return CategoryAssembler.toDTO(category);
            }
        }
        
        return null;
    }
    
    @Override
    public boolean validateNameUnique(CategoryDTO categoryDTO)
    {
        if (null != categoryDTO && !StringUtils.isEmpty(categoryDTO.getName()))
        {
            // 将对象转换成Map
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("notId", categoryDTO.getId());
            criteria.put("uniqueName", categoryDTO.getName());
            List<Category> categorys = this.categoryApplication.listCategorys(criteria);
            if (CollectionUtils.isEmpty(categorys))
            {
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public void saveOrUpdateCategory(CategoryDTO categoryDTO)
    {
        Category category = CategoryAssembler.toEntity(categoryDTO);
        if (null != category)
        {
            categoryApplication.persistentCategory(category);
        }
    }
    
    @Override
    public void deleteCategory(CategoryDTO categoryDTO)
    {
        Category category = CategoryAssembler.toEntity(categoryDTO);
        if (null != category)
        {
            categoryApplication.deleteCategory(category);
        }
    }
    
}