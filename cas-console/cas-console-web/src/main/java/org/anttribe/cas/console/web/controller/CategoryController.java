/*
 * 文  件   名: CategoryController.java
 * 版         本 : (Anttribe).cas-console-web All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月19日
 */
package org.anttribe.cas.console.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.anttribe.cas.base.infra.common.Result;
import org.anttribe.cas.console.facade.CategoryFacade;
import org.anttribe.cas.console.facade.dto.CategoryDTO;
import org.anttribe.cas.console.web.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaoyong
 * @version 2015年10月19日
 */
@Controller
@RequestMapping("/category")
public class CategoryController
{
    
    @Autowired
    private CategoryFacade categoryFacade;
    
    @RequestMapping("/index")
    public String index(HttpServletRequest request, CategoryDTO categoryDTO)
    {
        return "/category/list";
    }
    
    @RequestMapping("/list")
    @ResponseBody
    public Result<List<CategoryDTO>> listCategories(HttpServletRequest request, CategoryDTO categoryDTO)
    {
        List<CategoryDTO> categories = categoryFacade.listCategories(categoryDTO);
        
        Result<List<CategoryDTO>> result = new Result<List<CategoryDTO>>();
        result.setResultCode(Constants.DEFAULT_RESULT_CODE);
        result.setData(categories);
        return result;
    }
    
    @RequestMapping("/goAdd")
    public String goAddCategory()
    {
        return "/category/edit";
    }
    
    @RequestMapping("/goEdit")
    public String goEditCategory()
    {
        return "/category/edit";
    }
    
    @RequestMapping("/edit")
    public String doEditCategory(HttpServletRequest request, CategoryDTO categoryDTO)
    {
        if (null != categoryDTO)
        {
            categoryFacade.editCategory(categoryDTO);
        }
        return "redirect:/category/index";
    }
    
    @RequestMapping("/delete")
    public String doDeleteCategory(HttpServletRequest request, CategoryDTO categoryDTO)
    {
        if (null != categoryDTO)
        {
            categoryFacade.deleteCategory(categoryDTO);
        }
        return "redirect:/category/index";
    }
}