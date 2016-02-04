/*
 * 文  件   名: CrawlerRegular.java
 * 版         本: cas-base-core(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月22日
 */
package org.anttribe.cas.base.core.entity;

import org.anttribe.cas.base.infra.entity.MybatisAbstractEntity;

/**
 * 爬虫内容属性规则
 * 
 * @author zhaoyong
 * @version 2015年7月22日
 */
public class CrawlerRegular extends MybatisAbstractEntity
{
    
    /**
     * id编号
     */
    private Long id;
    
    /**
     * 所属爬虫
     */
    public Crawler crawler;
    
    /**
     * 对应内容属性
     */
    private ContentAttribute contentAttr;
    
    /**
     * 规则
     */
    private String attrRegular;
    
    /**
     * <默认构造器>
     */
    public CrawlerRegular()
    {
    }
    
    @Override
    public String toString()
    {
        StringBuilder strB = new StringBuilder();
        strB.append("CrawlerRegular")
            .append("{")
            .append("id=")
            .append(this.getId())
            .append(',')
            .append("crawler=")
            .append(this.getCrawler())
            .append(',')
            .append("attrRegular=")
            .append(this.getAttrRegular())
            .append(',')
            .append("contentAttr=")
            .append(this.getContentAttr())
            .append("}");
        return strB.toString();
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
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
    
    public ContentAttribute getContentAttr()
    {
        return contentAttr;
    }
    
    public void setContentAttr(ContentAttribute contentAttr)
    {
        this.contentAttr = contentAttr;
    }
    
    public String getAttrRegular()
    {
        return attrRegular;
    }
    
    public void setAttrRegular(String attrRegular)
    {
        this.attrRegular = attrRegular;
    }
    
}