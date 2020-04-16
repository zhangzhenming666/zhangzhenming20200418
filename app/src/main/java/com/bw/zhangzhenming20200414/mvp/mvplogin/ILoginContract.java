package com.bw.zhangzhenming20200414.mvp.mvplogin;


import com.bw.zhangzhenming20200414.base.IBaseView;
import com.bw.zhangzhenming20200414.bean.loginbean.LoginBean;

public interface ILoginContract {
    //
    interface ILoginView extends IBaseView {
        //成功
        void onSuccess(LoginBean loginBean);
        //失败
        void onError(String msg);
    }
    //
    interface ILoginModel{
        void getLogin(String phone, String pwd, DataCallBack dataCallBack);
        interface DataCallBack{
            //成功
            void onSuccess(LoginBean loginBean);
            //失败
            void onError(String msg);
        }
    }
    //
    interface ILoginPresenter{
        void getLogin(String phone, String pwd);
    }
}
