/*
 * 文  件   名: ContentAttrXPathApplication.java
 * 版         本: cas-base-application(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月22日
 */
package org.anttribe.cas.base.application;

import org.anttribe.cas.base.core.entity.ContentAttrXPath;
import org.anttribe.cas.base.core.entity.Website;

/**
 * @author zhaoyong
 * @version 2015年7月22日
 */
public interface ContentAttrXPathApplication
{
    /**
     * 根据web站点对象获取对应需要获取内容的属性xpath的结构化对象
     * 
     * @param website Website
     * @return ContentAttrXPath
     */
    ContentAttrXPath getContentAttrXPathByWebsite(Website website);
}