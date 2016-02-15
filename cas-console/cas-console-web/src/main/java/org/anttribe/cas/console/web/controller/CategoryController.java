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
import org.anttribe.cas.base.infra.errorno.CategoryErrorNo;
import org.anttribe.cas.console.facade.CategoryFacade;
import org.anttribe.cas.console.facade.dto.CategoryDTO;
import org.apache.commons.lang.StringUtils;
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
    public String index(HttpServletRequest request)
    {
        return "/category/list";
    }
    
    @RequestMapping("/list")
    @ResponseBody
    public List<CategoryDTO> listCategories(HttpServletRequest request, CategoryDTO categoryDTO)
    {
        List<CategoryDTO> categorys = this.categoryFacade.listCategorys(categoryDTO);
        return categorys;
    }
    
    @RequestMapping("/tool/selector")
    public String select(HttpServletRequest request, CategoryDTO categoryDTO)
    {
        return "/category/tool.selector";
    }
    
    @RequestMapping("/add")
    public String goAddCategory()
    {
        return "/category/edit";
    }
    
    @RequestMapping("/edit")
    public String goEditCategory(HttpServletRequest request, CategoryDTO categoryDTO)
    {
        if (null != categoryDTO && null != categoryDTO.getId())
        {
            categoryDTO = categoryFacade.loadCategory(categoryDTO);
            if (null != categoryDTO)
            {
                request.setAttribute("category", categoryDTO);
                return "/category/edit";
            }
        }
        return "redirect:/category/index";
    }
    
    @ResponseBody
    @RequestMapping("/edit/exec")
    public Result<?> doEditCategory(HttpServletRequest request, CategoryDTO categoryDTO)
    {
        Result<?> result = new Result<Object>();
        if (null != categoryDTO)
        {
            boolean validateResult = this.categoryFacade.validateNameUnique(categoryDTO);
            if (!validateResult)
            {
                result.setResultCode(CategoryErrorNo.CATEGORY_NAME_UNIQUE);
                return result;
            }
            categoryFacade.saveOrUpdateCategory(categoryDTO);
            result.setResultCode(org.anttribe.cas.base.infra.constants.Constants.Common.DEFAULT_RESULT_CODE);
        }
        
        return result;
    }
    
    @ResponseBody
    @RequestMapping("/delete/exec")
    public Result<?> doDeleteCategory(HttpServletRequest request, CategoryDTO categoryDTO)
    {
        Result<?> result = new Result<Object>();
        if (null != categoryDTO)
        {
            categoryFacade.deleteCategory(categoryDTO);
            result.setResultCode(org.anttribe.cas.base.infra.constants.Constants.Common.DEFAULT_RESULT_CODE);
        }
        return result;
    }
    
    @ResponseBody
    @RequestMapping("/validate/nameUnique")
    public boolean validateNameUnique(HttpServletRequest request, CategoryDTO categoryDTO)
    {
        if (null != categoryDTO && !StringUtils.isEmpty(categoryDTO.getName()))
        {
            return this.categoryFacade.validateNameUnique(categoryDTO);
        }
        return false;
    }
}