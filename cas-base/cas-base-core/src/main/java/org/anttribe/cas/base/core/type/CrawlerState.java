/*
 * 文  件   名: CrawlerState.java
 * 版         本 : cas-base-core.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月3日
 */
package org.anttribe.cas.base.core.type;

/**
 * 爬虫状态枚举
 * 
 * @author zhaoyong
 * @version 2015年11月3日
 */
public enum CrawlerState
{
    /** 初始化 */
    INIT,
    /** 运行中 */
    RUNNING,
    /** 休眠 */
    DORMANCY,
    /** 停止 */
    STOP;
}