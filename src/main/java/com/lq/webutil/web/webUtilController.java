package com.lq.webutil.web;

import com.lq.webutil.util.IPUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qi
 * 网页在线工具
 * 1.ip 查询公网ip
 * 2.在线大小字幕
 */
@Controller
@RequestMapping("/webUtil")
public class webUtilController
{
    @RequestMapping("/ip/toIpIndex")
    public String toIpIndex(HttpServletRequest request, Model model){

        String userIp= IPUtil.getIP(request);
        System.out.println("用户ip:"+userIp);
        model.addAttribute("userIp",userIp);
        return "/webUtil/ipIndex";
    }

    @RequestMapping("/letter/toletter")
    public String toLetter(){

        return  "/webUtil/letterUtil";
    }


    @RequestMapping("toTestIndex")
    public String toTestIndex(){
        return "/webUtil/testIndex";
    }

}
