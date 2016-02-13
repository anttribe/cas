/*
 * 文  件   名: ApplicationContextLoaderListener.java
 * 版         本 : (Anttribe) cas-base-infra All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2015年10月11日
 */
package org.anttribe.cas.base.infra.web.listener;

import javax.servlet.ServletContextEvent;

import org.dayatang.domain.InstanceFactory;
import org.dayatang.ioc.spring.factory.SpringInstanceProvider;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.util.WebUtils;

/**
 * @author zhaoyong
 * @version 2015年10月11日
 */
public class ApplicationContextLoaderListener extends ContextLoaderListener
{
    @Override
    public void contextInitialized(ServletContextEvent event)
    {
        super.contextInitialized(event);
        WebApplicationContext applicationContext =
            WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext());
        SpringInstanceProvider springProvider = new SpringInstanceProvider(applicationContext);
        InstanceFactory.setInstanceProvider(springProvider);
        
        WebUtils.setWebAppRootSystemProperty(event.getServletContext());
    }
}