package com.lq.wap.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qi_liang on 2018/5/10.
 */
@Controller
@RequestMapping("/wap")
public class WapIndexController {

    @RequestMapping("/index")
    public String index(){

        return "/wap/index";
    }
}
