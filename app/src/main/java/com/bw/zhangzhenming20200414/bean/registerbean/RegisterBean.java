package com.bw.zhangzhenming20200414.bean.registerbean;

import java.io.Serializable;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public class RegisterBean implements Serializable {
    private  String message;
    private  String status;

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
