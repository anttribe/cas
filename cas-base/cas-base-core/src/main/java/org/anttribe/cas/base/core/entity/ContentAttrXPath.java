/*
 * 文  件   名: ContentAttrXPath.java
 * 版         本: cas-base-core(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月22日
 */
package org.anttribe.cas.base.core.entity;

/**
 * @author zhaoyong
 * @version 2015年7月22日
 */
public class ContentAttrXPath
{
    /**
     * 编号
     */
    private String id;
    
    /**
     * 所属站点
     */
    public String siteId;
    
    /**
     * 内容列表
     */
    public String contentsXpath;
    
    /**
     * 标题
     */
    public String titleXpath;
    
    /**
     * 摘要
     */
    public String briefXpath;
    
    /**
     * 缩略图
     */
    public String thumbnailXpath;
    
    /**
     * 作者
     */
    public String authorXpath;
    
    /**
     * 发布时间
     */
    public String publishTimeXpath;
    
    /**
     * 标签
     */
    public String tagsXpath;
    
    /**
     * 内容
     */
    public String contentXpath;
    
    /**
     * 原文链接
     */
    public String linkXpath;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getSiteId()
    {
        return siteId;
    }
    
    public void setSiteId(String siteId)
    {
        this.siteId = siteId;
    }
    
    public String getContentsXpath()
    {
        return contentsXpath;
    }
    
    public void setContentsXpath(String contentsXpath)
    {
        this.contentsXpath = contentsXpath;
    }
    
    public String getTitleXpath()
    {
        return titleXpath;
    }
    
    public void setTitleXpath(String titleXpath)
    {
        this.titleXpath = titleXpath;
    }
    
    public String getBriefXpath()
    {
        return briefXpath;
    }
    
    public void setBriefXpath(String briefXpath)
    {
        this.briefXpath = briefXpath;
    }
    
    public String getThumbnailXpath()
    {
        return thumbnailXpath;
    }
    
    public void setThumbnailXpath(String thumbnailXpath)
    {
        this.thumbnailXpath = thumbnailXpath;
    }
    
    public String getAuthorXpath()
    {
        return authorXpath;
    }
    
    public void setAuthorXpath(String authorXpath)
    {
        this.authorXpath = authorXpath;
    }
    
    public String getPublishTimeXpath()
    {
        return publishTimeXpath;
    }
    
    public void setPublishTimeXpath(String publishTimeXpath)
    {
        this.publishTimeXpath = publishTimeXpath;
    }
    
    public String getTagsXpath()
    {
        return tagsXpath;
    }
    
    public void setTagsXpath(String tagsXpath)
    {
        this.tagsXpath = tagsXpath;
    }
    
    public String getContentXpath()
    {
        return contentXpath;
    }
    
    public void setContentXpath(String contentXpath)
    {
        this.contentXpath = contentXpath;
    }
    
    public String getLinkXpath()
    {
        return linkXpath;
    }
    
    public void setLinkXpath(String linkXpath)
    {
        this.linkXpath = linkXpath;
    }
}