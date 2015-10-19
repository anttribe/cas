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

import org.anttribe.cas.console.facade.CategoryFacade;
import org.anttribe.cas.console.facade.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    
    @RequestMapping("list")
    public ModelAndView listCategories(HttpServletRequest request, CategoryDTO categoryDTO)
    {
        List<CategoryDTO> categories = categoryFacade.listCategories(categoryDTO);
        
        ModelAndView mv = new ModelAndView();
        mv.addObject("categories", categories);
        mv.setViewName("/category/list");
        return mv;
    }
    
    @RequestMapping("goAdd")
    public String goAddCategory()
    {
        return "/category/edit";
    }
    
    @RequestMapping("add")
    public String doAddCategory(HttpServletRequest request, CategoryDTO categoryDTO)
    {
        if (null != categoryDTO)
        {
            categoryFacade.editCategory(categoryDTO);
        }
        return "redirect:/category/list";
    }
    
    @RequestMapping("goEdit")
    public String goEditCategory()
    {
        return "/category/edit";
    }
    
    @RequestMapping("edit")
    public String doEditCategory(HttpServletRequest request, CategoryDTO categoryDTO)
    {
        if (null != categoryDTO)
        {
            categoryFacade.editCategory(categoryDTO);
        }
        return "redirect:/category/list";
    }
    
    @RequestMapping("delete")
    public String doDeleteCategory(HttpServletRequest request, CategoryDTO categoryDTO)
    {
        if (null != categoryDTO)
        {
            categoryFacade.deleteCategory(categoryDTO);
        }
        return "redirect:/category/list";
    }
}