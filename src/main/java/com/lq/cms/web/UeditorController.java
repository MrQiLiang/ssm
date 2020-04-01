package com.lq.cms.web;

import com.baidu.ueditor.ActionEnter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/ueditor")
public class UeditorController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UeditorController.class);

    @RequestMapping("/dispatch")
    public void config(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding( "utf-8" );
            response.setHeader("Content-Type" , "text/html");
            String rootPath = request.getSession().getServletContext().getRealPath("/");

            PrintWriter out = response.getWriter();
            out.write( new ActionEnter( request, rootPath ).exec() );
            out.flush();
            out.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
