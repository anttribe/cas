/*
 * 文  件   名: ContentAttrXPath.java
 * 版         本: cas-base-core(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月22日
 */
package org.anttribe.cas.base.core.entity;

import org.anttribe.opengadget.core.domain.MybatisAbstractEntity;

/**
 * 爬虫内容属性规则
 * 
 * @author zhaoyong
 * @version 2015年7月22日
 */
public class CrawlerContentRegular extends MybatisAbstractEntity
{
    /**
     * 编号
     */
    private String id;
    
    /**
     * 所属爬虫
     */
    public Crawler crawler;
    
    /**
     * 对应内容属性
     */
    private ContentAttribute attribute;
    
    /**
     * 规则
     */
    private String regular;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public Crawler getCrawler()
    {
        return crawler;
    }
    
    public void setCrawler(Crawler crawler)
    {
        this.crawler = crawler;
    }
    
    public ContentAttribute getAttribute()
    {
        return attribute;
    }
    
    public void setAttribute(ContentAttribute attribute)
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