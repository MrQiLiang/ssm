package com.lq.cms.emun;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qi_liang on 2018/4/1.
 */
public enum  FileTypeEnum {
    FILE_TYPE_IMAGE("IMAGE","图片"),
    FILE_TYPE_VIEDO("VIEDO","视频"),
    FILE_TYPE_PDF("PDF","电子书"),
    FILE_TYPE_OTHER("OTHER","其他")
    ;

    private String value;
    private String desc;

    FileTypeEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
