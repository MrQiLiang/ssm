package com.lq.wechat.mode.menu;

/**
 * 菜单配置类
 * @author qi
 */
public class WechatMenuCofig {

    /**
     * 自定义菜单
     */
    private WechatMenu menu;

    /**
     * 个性菜单
     */
    private WechatMenu conditionalmenu;

    public WechatMenu getMenu() {
        return menu;
    }

    public void setMenu(WechatMenu menu) {
        this.menu = menu;
    }

    public WechatMenu getConditionalmenu() {
        return conditionalmenu;
    }

    public void setConditionalmenu(WechatMenu conditionalmenu) {
        this.conditionalmenu = conditionalmenu;
    }

}
