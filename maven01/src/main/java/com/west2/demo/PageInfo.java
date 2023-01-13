package com.west2.demo;
import java.io.Serializable;
import java.util.List;
//分页
public class PageInfo<T> implements Serializable{
    private List<T> list;    //保存页面数据
    private int totalNum;    //查询到的总记录数
    private int currentPage; //当前页面
    private int pageSize;        //每页数据量
    private int totalPages;      //总页数
    private int previousPage;    //上一页
    private int nextPage;        //下一页

    public static PageInfo startPage(int currentPage, int pageSize){
        return new PageInfo(currentPage, pageSize);
    }

    public PageInfo(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List getList() {
        return list;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }
    //总页数
    public int getTotalPages() {
        if (this.totalNum % this.pageSize == 0) {
            //刚刚好整除的情况
            this.totalPages = this.totalNum / this.pageSize;
        } else {
            //有多出几条数据（<每页数据量），额外需要1页
            this.totalPages = this.totalNum / this.pageSize + 1;
        }
        return this.totalPages;
    }

    public int getPreviousPage() {
        if (currentPage == 1) {
            //如果第一页，就没有上一页了
            previousPage = 1;
        } else {
            previousPage = currentPage - 1;
        }
        return previousPage;
    }

    public int getNextPage() {
        if (currentPage == totalPages) {
            //如果是最后一页，就没有下一页了
            nextPage = totalPages;
        } else {
            nextPage = currentPage + 1;
        }
        return nextPage;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "list=" + list +
                ", totalNum=" + totalNum +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalPages=" + totalPages +
                ", previousPage=" + previousPage +
                ", nextPage=" + nextPage +
                '}';
    }
}