/*
 * 文  件   名: ICategoryApplication.java
 * 版       本: Copyright (c) (Anttribe)cas v1.0. All rights reserved.
 * 描       述: <描述>
 * 修   改  人: zhaoyong(anshenglimin@163.com)
 * 修 改 时 间: 2016-02-04
 */
package org.anttribe.cas.base.application;

import org.anttribe.cas.base.core.entity.Category;
import org.anttribe.vigor.infra.common.service.IService;

/**
 * Category逻辑层处理接口
 * 
 * @author zhaoyong
 * @version 1.0
 */
public interface ICategoryApplication extends IService<Category>
{
    /**
     * 验证分类名是否唯一
     * 
     * @param category Category
     * @return boolean
     */
    boolean validateNameUnique(Category category);
}