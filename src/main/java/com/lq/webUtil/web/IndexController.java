package com.lq.webUtil.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qi_liang on 2018/4/17.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){

        return "index";
    }
}
