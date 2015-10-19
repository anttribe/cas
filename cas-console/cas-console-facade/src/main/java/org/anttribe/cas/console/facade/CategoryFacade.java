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
    List<CategoryDTO> listCategories(CategoryDTO categoryDTO);
    
    /**
     * 添加分类信息
     * 
     * @param categoryDTO CategoryDTO
     */
    void editCategory(CategoryDTO categoryDTO);
    
    /**
     * 删除分类信息
     * 
     * @param categoryDTO
     */
    void deleteCategory(CategoryDTO categoryDTO);
}