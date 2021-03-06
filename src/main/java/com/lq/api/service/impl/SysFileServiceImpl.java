package com.lq.api.service.impl;

import com.lq.api.service.SysFileService;
import com.lq.code.dao.BaseDao;
import com.lq.dao.SysFileDao;
import com.lq.entity.SysFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统文件事务类
 * @author qi
 */
@Service
public class SysFileServiceImpl  implements SysFileService {

    @Autowired
    private SysFileDao sysFileDao;

    @Override
    public BaseDao<SysFile> getBaseDao() {
        return sysFileDao;
    }
}
