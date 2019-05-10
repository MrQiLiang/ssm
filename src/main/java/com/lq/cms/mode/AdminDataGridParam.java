package com.lq.cms.mode;

import java.util.List;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 4:00 PM 2019/2/2
 */
public class AdminDataGridParam<T> {

    /**
     *  数据总量
     */
    private Integer total;

    /**
     * 数据行
     */
    private List<T> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
