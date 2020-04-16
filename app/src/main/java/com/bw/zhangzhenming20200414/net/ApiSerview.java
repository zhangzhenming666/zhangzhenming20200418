package com.bw.zhangzhenming20200414.net;

import com.bw.zhangzhenming20200414.bean.ddaobean.DDanBean;
import com.bw.zhangzhenming20200414.bean.loginbean.LoginBean;
import com.bw.zhangzhenming20200414.bean.registerbean.RegisterBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public interface ApiSerview {
    //登录
    @POST(ApiUrl.LOGIN_URL)
    @FormUrlEncoded
    Observable<LoginBean> getLoginData(@Field("phone")String phone, @Field("pwd")String pwd);
    //注册
    @POST(ApiUrl.REGISTER_URL)
    @FormUrlEncoded
    Observable<RegisterBean> getRegisterData(@Field("phone")String phone, @Field("pwd")String pwd);
    //订单
    @GET(ApiUrl.DDAN_URL)
    Observable<DDanBean>getDDanData(@Query("status")int status, @Query("page")int page, @Query("count")int count);
}
