/*
 * 文  件   名: ContentPersistentPipeline.java
 * 版         本: cas-cis-runtime(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年7月22日
 */
package org.anttribe.cas.cis.runtime.pipeline;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.anttribe.cas.base.core.entity.Content;
import org.anttribe.cas.cis.runtime.constants.Constants;
import org.anttribe.component.lang.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * 内容持久化
 * 
 * @author zhaoyong
 * @version 2015年7月22日
 */
public class ContentPersistentPipeline implements Pipeline
{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ContentPersistentPipeline.class);
    
    /**
     * html标签正则对象
     */
    private static final Pattern HTML_TAG_PATTERN = Pattern.compile(Constants.REGEX_HTML_TAG, Pattern.CASE_INSENSITIVE);
    
    @Override
    synchronized public void process(ResultItems resultItems, Task task)
    {
        logger.debug("ContentPersistentPipeline processing resultItems to content, and persist content to DB.");
        
        Map<String, Object> attrs = resultItems.getAll();
        if (!MapUtils.isEmpty(attrs))
        {
            Content content = new Content();
            try
            {
                BeanUtils.populate(content, attrs);
                content.setContentId(UUIDUtils.getRandomUUID());
                // 根据内容，截取默认第一段的内容(第一个<p>包含的内容)或者固定长度内容
                content.setBrief(populateBrief(content.getContent()));
                // 保存数据到数据库
                content.save();
            }
            catch (Exception e)
            {
                logger.error("ContentPersistentPipeline processing resultItems to content get error, cause: ", e);
            }
        }
    }
    
    /**
     * 根据内容主体获取对应的摘要内容
     * 
     * @param contentBody String
     * @return String
     */
    public String populateBrief(String contentBody)
    {
        String brief = "";
        if (!StringUtils.isEmpty(contentBody))
        {
            int lengthIndex = Constants.DEFAULT_BRIEF_LENGTH;
            if (-1 != contentBody.indexOf("</p>"))
            {
                lengthIndex = contentBody.indexOf("</p>");
            }
            brief = contentBody.substring(0, lengthIndex);
            // 去除html标签元素
            Matcher htmlMatcher = HTML_TAG_PATTERN.matcher(brief);
            brief = StringUtils.trimToEmpty(htmlMatcher.replaceAll(""));
            if (StringUtils.isEmpty(brief))
            {
                brief = populateBrief(contentBody.substring(lengthIndex + 4));
            }
        }
        return brief;
    }
}