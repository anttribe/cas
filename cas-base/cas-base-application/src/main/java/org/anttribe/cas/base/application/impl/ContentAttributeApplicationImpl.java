/*
 * 文  件   名: ContentAttrinuteApplicationImpl.java
 * 版         本 : (Anttribe).cas-base-application All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年11月6日
 */
package org.anttribe.cas.base.application.impl;

import org.anttribe.cas.base.application.IContentAttributeApplication;
import org.anttribe.cas.base.core.dao.IContentAttributeDao;
import org.anttribe.cas.base.core.entity.ContentAttribute;
import org.anttribe.vigor.infra.common.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyong
 * @version 2015年11月6日
 */
@Service
public class ContentAttributeApplicationImpl extends AbstractServiceImpl<IContentAttributeDao, ContentAttribute>
    implements IContentAttributeApplication
{
}