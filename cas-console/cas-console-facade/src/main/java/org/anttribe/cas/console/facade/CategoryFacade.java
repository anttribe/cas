/*
 * 文  件   名: CategoryFacade.java
 * 版         本 : (Anttribe).cas-console-facade All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月19日
 */
package org.anttribe.cas.console.facade;

import java.util.List;

import org.anttribe.cas.console.facade.dto.CategoryDTO;

/**
 * @author zhaoyong
 * @version 2015年10月19日
 */
public interface CategoryFacade
{
    /**
     * 根据父分类列表分类信息
     * 
     * @param categoryDTO
     * @return List<CategoryDTO>
     */
    List<CategoryDTO> listCategorys(CategoryDTO categoryDTO);
    
    /**
     * 加载分类信息
     * 
     * @param categoryDTO CategoryDTO
     * @return CategoryDTO
     */
    CategoryDTO loadCategory(CategoryDTO categoryDTO);
    
    /**
     * 校验分类名称唯一
     * 
     * @param categoryDTO
     * @return boolean
     */
    boolean validateNameUnique(CategoryDTO categoryDTO);
    
    /**
     * 添加或修改分类信息
     * 
     * @param categoryDTO CategoryDTO
     */
    void saveOrUpdateCategory(CategoryDTO categoryDTO);
    
    /**
     * 删除分类信息
     * 
     * @param categoryDTO
     */
    void deleteCategory(CategoryDTO categoryDTO);
}