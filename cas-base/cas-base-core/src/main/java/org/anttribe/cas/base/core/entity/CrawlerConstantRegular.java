/*
 * 文  件   名: CrawlerConstantRegular.java
 * 版         本 : cas-base-core © 2016 Anttribe. All rights reserved.
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2016年3月23日
 */
package org.anttribe.cas.base.core.entity;

/**
 * 爬虫固定的规则
 * 
 * @author zhaoyong
 * @version 2016年3月23日
 */
public class CrawlerConstantRegular
{
    
    /**
     * 内容列表规则
     */
    private String contentsRegular;
    
    /**
     * 内容连接正则
     */
    private String contentLinkRegex;
    
    public String getContentsRegular()
    {
        return contentsRegular;
    }
    
    public void setContentsRegular(String contentsRegular)
    {
        this.contentsRegular = contentsRegular;
    }
    
    public String getContentLinkRegex()
    {
        return contentLinkRegex;
    }
    
    public void setContentLinkRegex(String contentLinkRegex)
    {
        this.contentLinkRegex = contentLinkRegex;
    }
    
}