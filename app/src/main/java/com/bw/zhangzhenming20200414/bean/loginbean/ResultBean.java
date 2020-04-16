package com.bw.zhangzhenming20200414.bean.loginbean;

import java.io.Serializable;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public class ResultBean implements Serializable {
    private  String headPic;
    private  String nickName;
    private  String phone;
    private  String sessionId;
    private int userId;

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
