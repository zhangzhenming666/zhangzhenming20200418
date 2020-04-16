package com.bw.zhangzhenming20200414.net;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public interface ApiUrl {
    String URL = "http://mobile.bwstudent.com/small/";
    //登录
    String LOGIN_URL = "user/v1/login";
    //注册
    String REGISTER_URL = "user/v1/register";
    //订单
    String DDAN_URL = "order/verify/v1/findOrderListByStatus";
}
