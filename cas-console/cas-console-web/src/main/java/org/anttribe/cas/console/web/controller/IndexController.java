/*
 * 文  件   名: IndexController.java
 * 版         本 : cas-console-web © 2016 Anttribe. All rights reserved.
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2016年2月23日
 */
package org.anttribe.cas.console.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.anttribe.vigor.infra.common.web.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhaoyong
 * @version 2016年2月23日
 */
@Controller
public class IndexController extends AbstractController
{
    
    @RequestMapping({"", "/", "/index"})
    public ModelAndView index(HttpServletRequest request, ModelAndView mv)
    {
        mv.setViewName(Views.INDEX_VIEW);
        return mv;
    }
    
    class Views
    {
        public static final String INDEX_VIEW = "/index";
    }
    
}