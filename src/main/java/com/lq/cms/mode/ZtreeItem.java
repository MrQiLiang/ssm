package com.lq.cms.mode;

import java.util.ArrayList;
import java.util.List;

/**
 * 树选项
 * @author qi
 */
public class ZtreeItem extends ZtreeComposite{
    /**
     *  子节点集合
     */
    public List<ZtreeComposite> children=new ArrayList<>();
    /**
     * 节点图标
     */
    private String iconCls;
    /**
     * 节点状态("open","closed")
     */
    private String state;

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
