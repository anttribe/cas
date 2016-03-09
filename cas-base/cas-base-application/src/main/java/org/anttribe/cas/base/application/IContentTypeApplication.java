/*
 * 文  件   名: IContentTypeApplication.java
 * 版       本: Copyright (c) (Anttribe)cas v1.0. All rights reserved.
 * 描       述: <描述>
 * 修   改  人: zhaoyong(anshenglimin@163.com)
 * 修 改 时 间: 2016-02-04
 */
package org.anttribe.cas.base.application;

import org.anttribe.cas.base.core.entity.ContentType;
import org.anttribe.vigor.infra.common.service.IService;

/**
 * ContentType逻辑层处理接口
 * 
 * @author zhaoyong
 * @version 1.0
 */
public interface IContentTypeApplication extends IService<ContentType>
{
    
    /**
     * 校验内容类型名称唯一
     * 
     * @param contentType ContentType
     * @return boolean
     */
    boolean validateNameUnique(ContentType contentType);
    
    /**
     * 校验内容类型code唯一
     * 
     * @param contentType ContentType
     * @return boolean
     */
    boolean validateCodeUnique(ContentType contentType);
    
}