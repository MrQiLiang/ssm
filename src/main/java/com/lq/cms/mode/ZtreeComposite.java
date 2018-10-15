package com.lq.cms.mode;

import java.util.Map;

/**
 * Created by qi_liang on 2018/2/3.
 */
public abstract class ZtreeComposite {

    private Long id;

    private String text;

    private boolean checked;

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
