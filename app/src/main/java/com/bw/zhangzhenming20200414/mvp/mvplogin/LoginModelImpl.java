package com.bw.zhangzhenming20200414.mvp.mvplogin;






import com.bw.zhangzhenming20200414.bean.loginbean.LoginBean;
import com.bw.zhangzhenming20200414.net.ApiSerview;
import com.bw.zhangzhenming20200414.net.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;



public class LoginModelImpl implements ILoginContract.ILoginModel {
    @Override
    public void getLogin(String phone, String pwd, final DataCallBack dataCallBack) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiSerview service = instance.createService();
        Observable<LoginBean> loginData = service.getLoginData(phone, pwd);
        loginData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(LoginBean loginBean) {
                        dataCallBack.onSuccess(loginBean);
                    }
                    @Override
                    public void onError(Throwable e) {
                        dataCallBack.onError(e.getMessage());
                    }
                    @Override
                    public void onComplete() {
                    }
                });
    }
}
