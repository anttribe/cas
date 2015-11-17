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
    public List<CategoryDTO> listCategories(CategoryDTO categoryDTO)
    {
        // 将对象转换成Map
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("id", categoryDTO.getId());
        criteria.put("name", categoryDTO.getName());
        criteria.put("parent", CategoryAssembler.toEntity(categoryDTO.getParent()));
        
        List<Category> categories = categoryApplication.listCategories(criteria);
        return CategoryAssembler.toDTO(categories);
    }
    
    @Override
    public CategoryDTO loadCategory(CategoryDTO categoryDTO)
    {
        if (null != categoryDTO && !StringUtils.isEmpty(categoryDTO.getId()))
        {
            // 将对象转换成Map
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put("id", categoryDTO.getId());
            List<Category> categories = categoryApplication.listCategories(criteria);
            if (!CollectionUtils.isEmpty(categories))
            {
                return CategoryAssembler.toDTO(categories.get(0));
            }
        }
        
        return null;
    }
    
    @Override
    public void editCategory(CategoryDTO categoryDTO)
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