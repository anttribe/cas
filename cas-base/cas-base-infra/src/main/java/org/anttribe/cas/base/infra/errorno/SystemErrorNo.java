/*
 * 文  件   名: SystemErrorNo.java
 * 版         本: cas-base-core(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月23日
 */
package org.anttribe.cas.base.infra.errorno;

/**
 * 系统错误码
 * 
 * @author zhaoyong
 * @version 2015年7月23日
 */
public final class SystemErrorNo
{
    /**
     * 系统错误模块编号
     */
    public static final String MODULE_NO = "00";
    
    /**
     * 系统错误
     */
    public static final String SYSTEM_ERROR = "000001";
    
    /**
     * 参数为null
     */
    public static final String PARAMETER_IS_NULL = "000002";
    
    /**
     * 参数不合法
     */
    public static final String PARAMETE_ILLEGAL = "000003";
    
    /**
     * 参数逻辑错误
     */
    public static final String PARAMETER_LOGIC_ERROR = "000004";
    
    /**
     * 参数格式化错误
     */
    public static final String PARAMETE_FORMAT_ERROR = "000005";
    
    /**
     * 数据库内部错误
     */
    public static final String DATABASE_INNER_ERROR = "000006";
    
    /**
     * 数据库操作错误
     */
    public static final String DATABASE_OPERATION_ERROR = "000007";
    
    /**
     * 登录超时
     */
    public static final String LOGIN_TIMEOUT_ERROR = "000008";
    
    /**
     * 错误状态
     */
    public static final String INVALID_STATE_ERROR = "000009";
}