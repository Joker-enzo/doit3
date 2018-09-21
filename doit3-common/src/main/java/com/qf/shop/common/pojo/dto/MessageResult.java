package com.qf.shop.common.pojo.dto;

/**
 * 封装action到前台页面的数据传输对象
 * Created by 李杰 on 2018/9/15.
 */
public class MessageResult {
    private Boolean success;
    private String msg;
    private Object data;

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
}
