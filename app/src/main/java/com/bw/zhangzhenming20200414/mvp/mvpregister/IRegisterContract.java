package com.bw.zhangzhenming20200414.mvp.mvpregister;


import com.bw.zhangzhenming20200414.base.IBaseView;
import com.bw.zhangzhenming20200414.bean.registerbean.RegisterBean;

public interface IRegisterContract {
    //
    interface IRegisterView extends IBaseView {
        //成功
        void onSuccess(RegisterBean registerBean);
        //失败
        void onError(String msg);
    }
    //
    interface IRegisterModel{
        void getRegister(String phone, String pwd, DataCallBack dataCallBack);
        interface DataCallBack{
            //成功
            void onSuccess(RegisterBean registerBean);
            //失败
            void onError(String msg);
        }
    }
    //
    interface IRegisterPresenter{
        void getRegister(String phone, String pwd);
    }
}
