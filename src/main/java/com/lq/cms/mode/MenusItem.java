package com.lq.cms.mode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qi on 2017-11-29.
 */
public class MenusItem extends MenusComposite {

    public List<MenusComposite> menus=new ArrayList<>();

    public List<MenusComposite> getMenus() {
        return menus;
    }

    public void setMenus(List<MenusComposite> menus) {
        this.menus = menus;
    }

    public  MenusComposite add(MenusComposite menusComposite){
        menus.add(menusComposite);
        return  this;
    }


}
