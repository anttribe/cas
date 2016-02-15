/*
 * 文  件   名: SpringContextHolder.java
 * 版         本 : (Anttribe) cas-base-infra All rights reserved
 * 描         述 : <描述>
 * 修   改  人: zhaoyong
 * 修改时间: 2016年2月15日
 */
package org.anttribe.cas.base.infra.context;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候获取ApplicaitonContext
 * 
 * @author zhaoyong
 * @version 2016年2月15日
 */
@Service
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware, DisposableBean
{
    
    private static Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);
    
    private static ApplicationContext applicationContext = null;
    
    /**
     * 取得ApplicationContext
     */
    public static ApplicationContext getApplicationContext()
    {
        SpringContextHolder.assertContextInjected();
        return applicationContext;
    }
    
    /**
     * 从静态变量applicationContext中取得Bean
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name)
    {
        SpringContextHolder.assertContextInjected();
        return (T)applicationContext.getBean(name);
    }
    
    /**
     * 从静态变量applicationContext中取得Bean
     */
    public static <T> T getBean(Class<T> requiredType)
    {
        SpringContextHolder.assertContextInjected();
        return applicationContext.getBean(requiredType);
    }
    
    /**
     * 清除SpringContextHolder中的ApplicationContext
     */
    public static void clear()
    {
        if (logger.isDebugEnabled())
        {
            logger.debug("Clearing ApplicationContext from SpringContextHolder");
        }
        applicationContext = null;
    }
    
    /**
     * 检查ApplicationContext不为空
     */
    private static void assertContextInjected()
    {
        Validate.notNull(applicationContext,
            "applicaitonContext属性未注入, 请在applicationContext.xml中定义SpringContextHolder.");
    }
    
    /**
     * 实现ApplicationContextAware接口, 注入Context到静态变量中
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
    {
        logger.debug("Injecting applicationContext[{}] to SpringContextHolder", applicationContext);
        
        SpringContextHolder.applicationContext = applicationContext;
    }
    
    /**
     * 实现DisposableBean接口, 在Context关闭时清理静态变量.
     */
    @Override
    public void destroy()
        throws Exception
    {
        SpringContextHolder.clear();
    }
    
}