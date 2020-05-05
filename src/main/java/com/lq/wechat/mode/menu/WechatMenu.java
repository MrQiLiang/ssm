package com.lq.wechat.mode.menu;

import java.util.List;

/**
 * @author qi
 * 菜单类
 */
public class WechatMenu {
    //菜单类
    private List<WechatButton> button;

    public List<WechatButton> getButton() {
        return button;
    }

    public void setButton(List<WechatButton> button) {
        this.button = button;
    }
}
