package com.lq.cms.mode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by qi_liang on 2018/2/3.
 */
public class ZtreeItem extends ZtreeComposite{

    public List<ZtreeComposite> children=new ArrayList<>();
    private String iconCls;
    private String state;
    private Map<String,Object> attributes;

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public List<ZtreeComposite> getChildren() {
        return children;
    }

    public void setChildren(List<ZtreeComposite> children) {
        this.children = children;
    }

    public void add(ZtreeComposite ztreeComposite){
        this.children.add(ztreeComposite);
    }


}
