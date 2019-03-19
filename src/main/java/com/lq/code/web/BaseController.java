package com.lq.code.web;

import com.lq.code.entity.AjaxResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by qi on 2017/7/16.
 */
public class BaseController {

    @ExceptionHandler()
    @ResponseBody
    public AjaxResult handleException(Exception e) {
        e.printStackTrace();
       AjaxResult ajaxResult= getAjaxResult();
        ajaxResult.setSuccess(false);
        ajaxResult.setMsg(e.getMessage());
        return ajaxResult;
    }

    //返回ajax数据结构
    public AjaxResult getAjaxResult(){

        return new AjaxResult(true,"操作成功","");
    }

}
