package com.bw.zhangzhenming20200414.bean.loginbean;

import java.io.Serializable;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public class LoginBean implements Serializable {
    private  ResultBean  result;
    private  String message;
    private  String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
