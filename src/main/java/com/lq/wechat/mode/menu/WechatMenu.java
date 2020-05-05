package com.lq.wechat.mode.menu;

import java.util.List;

/**
 * 菜单类
 * @author qi
 */
public class WechatMenu {
    /**
     * 菜单类
     */
    private List<WechatButton> button;

    public List<WechatButton> getButton() {
        return button;
    }

    public void setButton(List<WechatButton> button) {
        this.button = button;
    }
}
