/*
 * 文  件   名: Result.java
 * 版         本 : cas-base-infra.(Anttribe) All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月20日
 */
package org.anttribe.cas.base.infra.common;

/**
 * @author zhaoyong
 * @version 2015年10月20日
 */
public class Result<T>
{
    /**
     * 结果码
     */
    private String resultCode;
    
    /**
     * 消息
     */
    private String message;
    
    /**
     * 数据
     */
    private T data;
    
    public String getResultCode()
    {
        return resultCode;
    }
    
    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }
    
    public String getMessage()
    {
        return message;
    }
    
    public void setMessage(String message)
    {
        this.message = message;
    }
    
    public T getData()
    {
        return data;
    }
    
    public void setData(T data)
    {
        this.data = data;
    }
}