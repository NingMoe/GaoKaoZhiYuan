package com.Gaokao.entity;

import java.util.List;

/**
 * 通用分页实体类
 */
public class Page<T> {

    //当前页
    private int currentPage=1;
    //页面显示数
    private int pageSize=10;
    //总记录条数
    private int rowCount;
    //总页数
    private int pageCount;
    // 开始位置
    private int beginIndex=0;
    // 结束位置
    private int endIndex;
    //数据
    private List<T> row;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getBeginIndex() {
        return beginIndex;
    }

    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public List<T> getRow() {
        return row;
    }

    public void setRow(List<T> row) {
        this.row = row;
    }
    public void setRow(List<T> row,int page) {
        this.currentPage = page;
        this.row = row;
        this.rowCount = row.size();
        this.pageCount =( (rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1) );
        this.beginIndex = (page-1)*pageSize;
        this.endIndex=((beginIndex+pageSize-1)<=rowCount)?(beginIndex+pageSize-1):(rowCount-1);
    }
}
