/*
 * 文  件   名: Pagination.java
 * 版         本: opengadget-core(Anttribe). All rights reserved
 * 描         述: <描述>
 * 修   改  人: zhaoyong
 * 修改时 间: 2015年1月23日
 */
package org.anttribe.cas.base.infra.entity;

import java.util.List;

/**
 * 分页处理
 * 
 * @author zhaoyong
 * @version 2015年1月23日
 */
public class Pagination
{
    /**
     * 默认分页大小
     */
    public final static int DEFAULT_PAGESIZE = 10;
    
    /**
     * 每页大小
     */
    private int pagesize = DEFAULT_PAGESIZE;
    
    /**
     * 当前页码
     */
    private int currentPage = 1;
    
    /**
     * 偏移量
     */
    private int offset = 0;
    
    /**
     * 总页码
     */
    private int totalPages = 1;
    
    /**
     * 总记录数
     */
    private int totalRecords = 0;
    
    /**
     * 数据
     */
    private List<?> datas;
    
    /**
     * <默认构造器>
     */
    public Pagination()
    {
    }
    
    /**
     * <默认构造器>
     * 
     * @param page
     * @param pagesize
     */
    public Pagination(int currentPage, int pagesize)
    {
        setPagesize(pagesize);
        setCurrentPage(currentPage);
    }
    
    /**
     * <默认构造器>
     * 
     * @param page
     * @param pagesize
     * @param totalRecords
     */
    public Pagination(int currentPage, int pagesize, int totalRecords)
    {
        setPagesize(pagesize);
        setCurrentPage(currentPage);
        setTotalRecords(totalRecords);
    }
    
    public int getCurrentPage()
    {
        return currentPage;
    }
    
    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage < 1 ? 1
            : (this.totalPages > 1 && currentPage > this.totalPages ? this.totalPages : currentPage);
        if (currentPage > 1)
        {
            setOffset((this.currentPage - 1) * getPagesize());
        }
    }
    
    public int getPagesize()
    {
        return pagesize;
    }
    
    public void setPagesize(int pagesize)
    {
        this.pagesize = pagesize < 1 ? DEFAULT_PAGESIZE : pagesize;
        
        if (this.currentPage > 1)
        {
            setOffset((this.currentPage - 1) * this.pagesize);
        }
    }
    
    public int getOffset()
    {
        return offset;
    }
    
    public void setOffset(int offset)
    {
        this.offset = offset < 0 ? 0 : offset;
    }
    
    public int getTotalPages()
    {
        return totalPages;
    }
    
    public void setTotalPages(int totalPages)
    {
        this.totalPages = totalPages < 1 ? 0 : totalPages;
    }
    
    public int getTotalRecords()
    {
        return totalRecords;
    }
    
    public void setTotalRecords(int totalRecords)
    {
        this.totalRecords = totalRecords < 0 ? 0 : totalRecords;
        setTotalPages((int)Math.ceil((double)this.totalRecords / pagesize));
    }
    
    public List<?> getDatas()
    {
        return datas;
    }
    
    public void setDatas(List<?> datas)
    {
        this.datas = datas;
    }
}