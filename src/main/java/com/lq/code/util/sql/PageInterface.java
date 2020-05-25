package com.lq.code.util.sql;

/**
 *  分页抽象类
 *  @author qi
 */
public interface PageInterface {

    /**
     *  页码
     * @return
     */
    Integer getPage();

    /**
     *  每页数量
     * @return
     */
    Integer getPageSize();
}
