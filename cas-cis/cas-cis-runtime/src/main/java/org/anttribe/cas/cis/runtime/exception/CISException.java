/*
 * 文  件   名: CISException.java
 * 版         本: cas-cis-runtime(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月22日
 */
package org.anttribe.cas.cis.runtime.exception;

/**
 * @author zhaoyong
 * @version 2015年7月22日
 */
public class CISException extends RuntimeException
{
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2379755918024621831L;
    
    /**
     * 错误码
     */
    private String errorNo;
    
    /**
     * <默认构造函数>
     */
    public CISException()
    {
        super();
    }
    
    /**
     * <构造函数>
     */
    public CISException(String errorNo)
    {
        super();
        this.errorNo = errorNo;
    }
    
    /**
     * <构造函数>
     */
    public CISException(String errorNo, String message)
    {
        super(message);
        this.errorNo = errorNo;
    }
    
    /**
     * <构造函数>
     */
    public CISException(String errorNo, Throwable e)
    {
        super(e);
        this.errorNo = errorNo;
    }
    
    /**
     * <构造函数>
     */
    public CISException(String errorNo, String message, Throwable e)
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