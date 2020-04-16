package com.bw.zhangzhenming20200414.mvp.mvplogin;


import com.bw.zhangzhenming20200414.base.BasePresenter;
import com.bw.zhangzhenming20200414.bean.loginbean.LoginBean;

public class LoginPresenterImpl extends BasePresenter<ILoginContract.ILoginView> implements ILoginContract.ILoginPresenter {
    private LoginModelImpl loginModel;
    @Override
    public void initModel() {
        loginModel=new LoginModelImpl();
    }

    @Override
    public void getLogin(String phone, String pwd) {
        loginModel.getLogin(phone, pwd, new ILoginContract.ILoginModel.DataCallBack() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                iBaseView.onSuccess(loginBean);
            }

            @Override
            public void onError(String msg) {
                iBaseView.onError(msg);
            }
        });
    }
}
