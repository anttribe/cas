/*
 * 文  件   名: CrawlerRegularDTO.java
 * 版         本 : (Anttribe).cas-console-facade All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.console.facade.dto;

import java.io.Serializable;

/**
 * @author zhaoyong
 * @version 2015年11月6日
 */
public class CrawlerRegularDTO implements Serializable
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3653334187608956900L;
    
    /**
     * 编号
     */
    private Long id;
    
    /**
     * 所属爬虫
     */
    public String crawler;
    
    /**
     * 对应内容属性
     */
    private String attribute;
    
    /**
     * 规则
     */
    private String regular;
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getCrawler()
    {
        return crawler;
    }
    
    public void setCrawler(String crawler)
    {
        this.crawler = crawler;
    }
    
    public String getAttribute()
    {
        return attribute;
    }
    
    public void setAttribute(String attribute)
    {
        this.attribute = attribute;
    }
    
    public String getRegular()
    {
        return regular;
    }
    
    public void setRegular(String regular)
    {
        this.regular = regular;
    }
}