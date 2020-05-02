package com.lq.cms.vo;

import com.lq.code.util.sql.PageInterface;

/**分页父类
 * Created by qi_liang on 2018/1/27.
 */
public class BasePageVo implements PageInterface {

    /**
     * 页码
     */
    private Integer page;
    /**
     * 行数
     */
    private Integer rows;

    @Override
    public Integer getPage() {
        return page;
    }

    @Override
    public Integer getPageSize() {
        return rows;
    }

    public BasePageVo setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
