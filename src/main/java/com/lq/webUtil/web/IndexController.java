package com.lq.webUtil.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制类
 * @author qi
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){

        return "index";
    }
}
