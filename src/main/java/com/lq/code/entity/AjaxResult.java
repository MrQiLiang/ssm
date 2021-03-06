package com.lq.code.entity;

/**
 * Created by qi on 2018-1-9.
 * @author qi
 */
public class AjaxResult {
    /**
     * 操作结果
     */
    private boolean success;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    public AjaxResult() {
        super();
        this.success =true;
        this.msg = "操作成功";
    }

    public AjaxResult(Boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static AjaxResult getInstance(){

        return new AjaxResult();
    }

    public static AjaxResult getSuccessInstance(){

        return new AjaxResult();
    }

    public static AjaxResult getSuccessInstance(Object data){
        AjaxResult  ajaxResult = new AjaxResult();
        ajaxResult.setData(data);
        return ajaxResult;
    }
}
