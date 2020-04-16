package com.bw.zhangzhenming20200414.mvp.mvpregister;


import com.bw.zhangzhenming20200414.base.BasePresenter;
import com.bw.zhangzhenming20200414.bean.registerbean.RegisterBean;

public class RegisterPresenterImpl extends BasePresenter<IRegisterContract.IRegisterView> implements IRegisterContract.IRegisterPresenter {
    private RegisterModelImpl registerModel;
    @Override
    public void initModel() {
        registerModel=new RegisterModelImpl();
    }

    @Override
    public void getRegister(String phone, String pwd) {
        registerModel.getRegister(phone, pwd, new IRegisterContract.IRegisterModel.DataCallBack() {
            @Override
            public void onSuccess(RegisterBean registerBean) {
                iBaseView.onSuccess(registerBean);
            }

            @Override
            public void onError(String msg) {
                iBaseView.onError(msg);
            }
        });
    }
}
