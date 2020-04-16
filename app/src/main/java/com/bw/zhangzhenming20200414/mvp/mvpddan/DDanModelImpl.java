package com.bw.zhangzhenming20200414.mvp.mvpddan;



import com.bw.zhangzhenming20200414.App;
import com.bw.zhangzhenming20200414.CacheRntity;
import com.bw.zhangzhenming20200414.bean.ddaobean.DDanBean;
import com.bw.zhangzhenming20200414.net.ApiSerview;
import com.bw.zhangzhenming20200414.net.ApiUrl;
import com.bw.zhangzhenming20200414.net.RetrofitUtil;
import com.google.gson.Gson;
import com.greendao.gen.CacheRntityDao;


import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class DDanModelImpl implements IDDanContract.IDDanModel {
    @Override
    public void getDDan(int status, int page, int count, final DataCallBack dataCallBack) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        //网络判断
                boolean net = instance.net();
                if(!net){
                    CacheRntityDao cacheRntityDao = App.daoSession.getCacheRntityDao();
                    CacheRntity load = cacheRntityDao.load(2l);
                    if(load!=null){
                        Gson gson = new Gson();
                        DDanBean dDanBean = gson.fromJson(load.json, DDanBean.class);
                        dataCallBack.onSuccess(dDanBean);
                    }else{
                        dataCallBack.onError("网络异常");
                        return;
            }
        }
        ApiSerview service = instance.createService();
        Observable<DDanBean> dDanData = service.getDDanData(status, page, count);
        dDanData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DDanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(DDanBean dDanBean) {
                        dataCallBack.onSuccess(dDanBean);
                        //存
                        Gson gson = new Gson();
                        String json = gson.toJson(dDanBean);
                        CacheRntityDao cacheRntityDao = App.daoSession.getCacheRntityDao();
                        CacheRntity cacheRntity = new CacheRntity(2l, ApiUrl.DDAN_URL, json);
                        cacheRntityDao.insertOrReplace(cacheRntity);
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
