/*
 * 文  件   名: Constants.java
 * 版         本: cas-cis-runtime(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月24日
 */
package org.anttribe.cas.cis.runtime.constants;

/**
 * 常量定义
 * 
 * @author zhaoyong
 * @version 2015年7月24日
 */
public class Constants
{
    /**
     * HTML标签的正则表达式
     */
    public static final String REGEX_HTML_TAG = "<[^>]+>";
    
    /**
     * 默认brief字段内容长度
     */
    public static final int DEFAULT_BRIEF_LENGTH = 64;
    
    /**
     * 抓取的目标utl地址列表
     */
    public static final String REDIS_KEY_CRAWL_TARGET_URLS = "crawl_target_urls";
    
    /**
     * 抓取的内容标题列表
     */
    public static final String REDIS_KEY_CRAWL_CONTENT_TITLES = "crawl_content_titles";
}