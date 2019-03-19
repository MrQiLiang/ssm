package com.lq.wechat.mode.menu;

/**
 * Created by qi_liang on 2018/5/24.
 */
public class WechatMenuCofig {

    //自定义菜单
    private WechatMenu menu;

    //个性菜单
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
