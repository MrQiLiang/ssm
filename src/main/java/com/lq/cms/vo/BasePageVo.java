package com.lq.cms.vo;

/**分页父类
 * Created by qi_liang on 2018/1/27.
 */
public class BasePageVo {

    //页码
    private Integer page;
    //行数
    private Integer rows;

    public Integer getPage() {
        return page;
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
