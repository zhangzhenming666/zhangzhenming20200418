package com.bw.zhangzhenming20200414.mvp.mvpregister;




import com.bw.zhangzhenming20200414.bean.registerbean.RegisterBean;
import com.bw.zhangzhenming20200414.net.ApiSerview;
import com.bw.zhangzhenming20200414.net.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class RegisterModelImpl implements IRegisterContract.IRegisterModel {
    @Override
    public void getRegister(String phone, String pwd, final DataCallBack dataCallBack) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiSerview service = instance.createService();
        Observable<RegisterBean> registerData = service.getRegisterData(phone, pwd);
        registerData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(RegisterBean registerBean) {
                        dataCallBack.onSuccess(registerBean);
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
