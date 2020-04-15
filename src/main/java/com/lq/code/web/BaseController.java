package com.lq.code.web;

import com.lq.code.entity.AjaxResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author qi
 * @date 2017/7/16
 */
public class BaseController {

    @ExceptionHandler()
    @ResponseBody
    public AjaxResult handleException(Exception e) {
        e.printStackTrace();
        AjaxResult ajaxResult= AjaxResult.getSuccessInstance();
        ajaxResult.setSuccess(false);
        ajaxResult.setMsg(e.getMessage());
        return ajaxResult;
    }



}
