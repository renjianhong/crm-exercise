package com.rjh.crm.vo;

import java.util.List;

/**
 * @author rjh
 * @date 2021/1/17 17:40
 */
public class PaginationVO<T> {
    private int total;
    private List<T> dataList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
