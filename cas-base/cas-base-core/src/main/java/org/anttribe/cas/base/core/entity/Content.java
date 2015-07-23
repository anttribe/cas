/*
 * 文  件   名: Content.java
 * 版         本: cas-base-core(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月22日
 */
package org.anttribe.cas.base.core.entity;

import java.sql.Timestamp;

import org.anttribe.opengadget.core.domain.MybatisAbstractEntity;

/**
 * @author zhaoyong
 * @version 2015年7月22日
 */
public class Content extends MybatisAbstractEntity
{
    /**
     * 内容id
     */
    private String contentId;
    
    /**
     * 内容类型
     */
    private ContentType contentType;
    
    /**
     * 内容标题
     */
    private String title;
    
    /**
     * 摘要
     */
    private String brief;
    
    /**
     * 缩略图
     */
    private String thumbnail;
    
    /**
     * 作者
     */
    private String author;
    
    /**
     * 内容
     */
    private String content;
    
    /**
     * 发布时间
     */
    private Timestamp publishTime;
    
    /**
     * 原链接
     */
    private String link;
    
    /**
     * 所属站点
     */
    private Website site;
    
    public String getContentId()
    {
        return contentId;
    }
    
    public void setContentId(String contentId)
    {
        this.contentId = contentId;
    }
    
    public ContentType getContentType()
    {
        return contentType;
    }
    
    public void setContentType(ContentType contentType)
    {
        this.contentType = contentType;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getBrief()
    {
        return brief;
    }
    
    public void setBrief(String brief)
    {
        this.brief = brief;
    }
    
    public String getThumbnail()
    {
        return thumbnail;
    }
    
    public void setThumbnail(String thumbnail)
    {
        this.thumbnail = thumbnail;
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
    public Timestamp getPublishTime()
    {
        return publishTime;
    }
    
    public void setPublishTime(Timestamp publishTime)
    {
        this.publishTime = publishTime;
    }
    
    public String getLink()
    {
        return link;
    }
    
    public void setLink(String link)
    {
        this.link = link;
    }
    
    public Website getSite()
    {
        return site;
    }
    
    public void setSite(Website site)
    {
        this.site = site;
    }
}