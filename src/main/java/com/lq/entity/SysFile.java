package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/**
 * 系统文件
 * Created by qi_liang on 2018/3/25.
 */
public class SysFile extends IdEntity {
    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件路径(相对路径)
     */
    private String path;
    /**
     * 上传时间
     */
    private Date createTime;
    /**
     * 文件类型（image:图片,viedo:视频,other:其他）
     */
    private String fileType;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
