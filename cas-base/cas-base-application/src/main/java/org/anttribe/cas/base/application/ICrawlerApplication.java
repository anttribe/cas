/*
 * 文  件   名: ICrawlerApplication.java
 * 版       本: Copyright (c) (Anttribe)cas v1.0. All rights reserved.
 * 描       述: <描述>
 * 修   改  人: zhaoyong(anshenglimin@163.com)
 * 修 改 时 间: 2016-02-04
 */
package org.anttribe.cas.base.application;

import org.anttribe.cas.base.core.entity.Crawler;
import org.anttribe.vigor.infra.common.service.IService;

/**
 * Crawler逻辑层处理接口
 * 
 * @author zhaoyong
 * @version 1.0
 */
public interface ICrawlerApplication extends IService<Crawler>
{
    /**
     * 校验爬虫标题唯一
     * 
     * @param crawler Crawler
     * @return boolean
     */
    boolean validateTitleUnique(Crawler crawler);
}