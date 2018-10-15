package com.lq.cms.service;

import com.lq.cms.vo.SysLogVo;
import com.lq.code.service.BaseService;
import com.lq.entity.SysLog;

import java.util.List;

/**
 * Created by qi_liang on 2018/6/21.
 */
public interface SysLogService extends BaseService<SysLog> {

    /**
     *  返回数据行数
     * @param vo
     * @return
     */
    Integer count(SysLogVo vo);

    /**
     *  返回分页数据
     * @param vo
     * @return
     */
    List<SysLogVo> findListPage(SysLogVo vo);


}
