/*
 * 文  件   名: ArticleGadget.java
 * 版         本 : (Anttribe).cas-crs-web All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年8月4日
 */
package org.anttribe.cas.crs.web.gadget;

import java.util.List;

import org.anttribe.cas.base.core.entity.Content;
import org.anttribe.cas.base.core.entity.Topic;
import org.anttribe.cas.crs.facade.TopicFacade;
import org.anttribe.cas.crs.web.constants.Keys;
import org.anttribe.opengadget.runtime.stereotype.Gadget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhaoyong
 * @version 2015年8月4日
 */
@Gadget(name = "ArticleGadget")
@RequestMapping("/article")
public class ArticleGadget
{
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleGadget.class);
    
    /**
     * topicFacade
     */
    @Autowired
    private TopicFacade topicFacade;
    
    /**
     * index
     * 
     * @return String
     */
    @RequestMapping("/index")
    public ModelAndView index()
    {
        // 加载topic数据
        List<Topic> topics = topicFacade.listAllParentTopics();
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("article/articles");
        mv.addObject(Keys.KEY_TOPICS, topics);
        return mv;
    }
    
    public List<Content> latestArticles()
    {
        // 最新的文章列表
        return null;
    }
    
    public List<Content> topicArticles()
    {
        // topic对应的文章列表
        return null;
    }
}