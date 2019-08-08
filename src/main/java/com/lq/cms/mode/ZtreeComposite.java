package com.lq.cms.mode;

import java.util.Map;

/**
 * @author qi
 * easyUI tree菜单 数据
 * 抽象对象：节点
 */
public abstract class ZtreeComposite {
    /**
     * 资源ID
     */
    private Long id;
    /**
     * 节点名称
     */
    private String text;
    /**
     * 是否勾选
     */
    private boolean checked;
    /**
     * 自定义属性（数据）
     */
    private Map<String,Object> attributes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
