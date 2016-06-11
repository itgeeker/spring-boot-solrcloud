package me.highgo.solr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Page.java
 *
 * @Description : 分页对象
 * @Author huangzhiwei
 * @DATE 2016/6/11
 */
public class Page<T> implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = -4906400433425467744L;

    /**
     * 默认每页记录数
     */
    private static int DEFAULT_PAGE_SIZE = 10;

    /**
     * 每页记录数
     */
    private int pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 起始记录位序
     */
    private long start;

    /**
     * 记录
     */
    private List<T> data;

    /**
     * 总记录数
     */
    private long totalCount;

    public Page() {
        this(DEFAULT_PAGE_SIZE,0,new ArrayList<T>(),0);
    }

    public Page(int pageSize, long start, List<T> data, long totalCount) {
        this.pageSize = pageSize;
        this.start = start;
        this.data = data;
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 取该页当前页码,页码从1开始.
     */
    public int getCurrentPageNo() {
        return (int)(start / pageSize + 1);
    }

    /**
     * 该页是否有下一页.
     */
    public boolean hasNextPage() {
        return this.getCurrentPageNo() < this.getTotalPageCount();
    }

    /**
     * 该页是否有上一页.
     */
    public boolean hasPreviousPage() {
        return this.getCurrentPageNo() > 1;
    }

    /**
     * 总页数
     */
    public int getTotalPageCount() {
        if (pageSize<=0)
               return 0;
        return (int)(totalCount/pageSize)+1;
    }

    /**
     * 获取任一页第一条数据在数据集的位置，每页条数使用默认值.
     */
    public static int getStartOfPage(int pageNo) {
        return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
    }

    /**
     * 获取任一页第一条数据在数据集的位置.
     */
    public static int getStartOfPage(int pageNo, int pageSize) {
        return (pageNo - 1) * pageSize;
    }
}
