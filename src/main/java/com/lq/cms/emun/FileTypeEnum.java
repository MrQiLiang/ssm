package com.lq.cms.emun;

/**
 * Created by qi_liang on 2018/4/1.
 * @author qi
 * 文件类型枚举
 */
public enum  FileTypeEnum {
    //图片类型
    FILE_TYPE_IMAGE("IMAGE","图片"),
    //视频类型
    FILE_TYPE_VIEDO("VIEDO","视频"),
    //pdf类型
    FILE_TYPE_PDF("PDF","电子书"),
    //其他类型
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
