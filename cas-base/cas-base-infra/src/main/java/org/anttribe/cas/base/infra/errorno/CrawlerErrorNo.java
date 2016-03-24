/*
 * 文  件   名: CrawlerErrorNo.java
 * 版         本 : (Anttribe)cas-base-infra. All rights reserved.
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2016年2月8日
 */
package org.anttribe.cas.base.infra.errorno;

/**
 * 爬虫相关错误码
 * 
 * @author zhaoyong
 * @version 2016年2月8日
 */
public final class CrawlerErrorNo
{
    /**
     * 爬虫模块编号
     */
    public static final String MODULE_NO = "04";
    
    /**
     * 爬虫名唯一
     */
    public static final String CRAWLER_TITLE_UNIQUE = MODULE_NO + "0001";
    
    /**
     * 启动爬虫失败
     */
    public static final String CRAWLER_STARTUP_ERROR = MODULE_NO + "0002";
    
    /**
     * 停止爬虫失败
     */
    public static final String CRAWLER_STOP_ERROR = MODULE_NO + "0003";
    
}