/*
 * 文  件   名: IWebsiteApplication.java
 * 版       本: Copyright (c) (Anttribe)cas v1.0. All rights reserved.
 * 描       述: <描述>
 * 修   改  人: zhaoyong(anshenglimin@163.com)
 * 修 改 时 间: 2016-02-04
 */
package org.anttribe.cas.base.application;

import org.anttribe.cas.base.core.entity.Website;
import org.anttribe.vigor.infra.common.service.IService;

/**
 * Website逻辑层处理接口
 * 
 * @author zhaoyong
 * @version 1.0
 */
public interface IWebsiteApplication extends IService<Website>
{
    /**
     * 校验站点名唯一
     * 
     * @param website
     * @return boolean
     */
    boolean validateNameUnique(Website website);
}