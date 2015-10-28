/*
 * 文  件   名: CategoryAssembler.java
 * 版         本 : (Anttribe).cas-console-facade All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月19日
 */
package org.anttribe.cas.console.facade.assembler;

import java.util.ArrayList;
import java.util.List;

import org.anttribe.cas.base.core.entity.Category;
import org.anttribe.cas.console.facade.dto.CategoryDTO;
import org.apache.commons.collections.CollectionUtils;

/**
 * @author zhaoyong
 * @version 2015年10月19日
 */
public class CategoryAssembler
{
    public static CategoryDTO toDTO(Category category)
    {
        if (null != category)
        {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(category.getId());
            categoryDTO.setName(category.getName());
            categoryDTO.setParent(null != category.getParent() ? category.getParent().getId() : "");
            categoryDTO.setOrdinal(category.getOrdinal());
            categoryDTO.setCreateTime(category.getCreateTime());
            categoryDTO.setUpdateTime(category.getUpdateTime());
            categoryDTO.setChildren(CategoryAssembler.toDTO(category.getChildren()));
            
            return categoryDTO;
        }
        return null;
    }
    
    public static List<CategoryDTO> toDTO(List<Category> categories)
    {
        if (!CollectionUtils.isEmpty(categories))
        {
            List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
            for (Category category : categories)
            {
                CategoryDTO categoryDTO = CategoryAssembler.toDTO(category);
                if (null == categoryDTO)
                {
                    continue;
                }
                categoryDTOs.add(categoryDTO);
            }
            
            return categoryDTOs;
        }
        return null;
    }
    
    public static Category toEntity(CategoryDTO categoryDTO)
    {
        if (null != categoryDTO)
        {
            Category category = new Category();
            category.setId(categoryDTO.getId());
            category.setName(categoryDTO.getName());
            category.setOrdinal(categoryDTO.getOrdinal());
            category.setParent(new Category(categoryDTO.getParent()));
            category.setCreateTime(categoryDTO.getCreateTime());
            category.setUpdateTime(category.getUpdateTime());
            
            return category;
        }
        return null;
    }
}