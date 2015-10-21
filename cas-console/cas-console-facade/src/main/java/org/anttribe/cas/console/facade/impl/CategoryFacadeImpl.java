/*
 * 文  件   名: CategoryFacadeImpl.java
 * 版         本 : (Anttribe).cas-console-facade All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月19日
 */
package org.anttribe.cas.console.facade.impl;

import java.util.List;

import org.anttribe.cas.base.application.CategoryApplication;
import org.anttribe.cas.base.core.entity.Category;
import org.anttribe.cas.console.facade.CategoryFacade;
import org.anttribe.cas.console.facade.assembler.CategoryAssembler;
import org.anttribe.cas.console.facade.dto.CategoryDTO;
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
        String parent = "";
        if (null != categoryDTO && !StringUtils.isEmpty(categoryDTO.getParent()))
        {
            parent = categoryDTO.getParent();
        }
        
        List<Category> categories = categoryApplication.listCategories(parent);
        return CategoryAssembler.toDTO(categories);
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