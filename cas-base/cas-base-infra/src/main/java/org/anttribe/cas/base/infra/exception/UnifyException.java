/*
 * 文  件   名: UnifyException.java
 * 版         本: cas-base-core(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月23日
 */
package org.anttribe.cas.base.infra.exception;

/**
 * 统一异常信息
 * 
 * @author zhaoyong
 * @version 2015年7月23日
 */
public class UnifyException extends RuntimeException
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 9173775029890091289L;
    
    /**
     * 错误码
     */
    private String errorNo;
    
    /**
     * <默认构造函数>
     */
    public UnifyException()
    {
        super();
    }
    
    /**
     * <构造函数>
     */
    public UnifyException(String errorNo)
    {
        super();
        this.errorNo = errorNo;
    }
    
    /**
     * <构造函数>
     */
    public UnifyException(String errorNo, String message)
    {
        super(message);
        this.errorNo = errorNo;
    }
    
    /**
     * <构造函数>
     */
    public UnifyException(String errorNo, Throwable e)
    {
        super(e);
        this.errorNo = errorNo;
    }
    
    /**
     * <构造函数>
     */
    public UnifyException(String errorNo, String message, Throwable e)
    {
        super(message, e);
        this.errorNo = errorNo;
    }
    
    public String getErrorNo()
    {
        return errorNo;
    }
    
    public void setErrorNo(String errorNo)
    {
        this.errorNo = errorNo;
    }
}