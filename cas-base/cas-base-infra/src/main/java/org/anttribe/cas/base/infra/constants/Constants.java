/*
 * 文  件   名: Constants.java
 * 版         本 : (Anttribe).cas-base-core All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月10日
 */
package org.anttribe.cas.base.infra.constants;

/**
 * @author zhaoyong
 * @version 2015年11月10日
 */
public class Constants
{
    /**
     * 公用模块
     * 
     * @author zhaoyong
     * @version 2016年2月8日
     */
    public class Common
    {
    }
    
    /**
     * 站点相关
     * 
     * @author zhaoyong
     * @version 2016年3月9日
     */
    public class Website
    {
        /**
         * 默认字符集
         */
        public static final String DEFAULT_CHARSET = "UTF-8";
    }
    
    /**
     * 爬虫模块相关常量定义
     * 
     * @author zhaoyong
     * @version 2015年11月10日
     */
    public class Crawler
    {
        /**
         * 默认处理2个page之间的间隔时间
         */
        public static final int DEFAULT_PAGE_INTERVALTIME = 100;
        
        /**
         * 默认处理失败之后的重复次数
         */
        public static final int DEFAULT_RETRYTIMES = 3;
        
        /**
         * 默认超时时长
         */
        public static final int DEFAULT_TIMEOUT = 10000;
    }
}