package com.bw.zhangzhenming20200414.mvp.mvpddan;


import com.bw.zhangzhenming20200414.base.BasePresenter;
import com.bw.zhangzhenming20200414.bean.ddaobean.DDanBean;

public class DDanPresenterImpl extends BasePresenter<IDDanContract.IDDanView> implements IDDanContract.IDDanPresenter {
    private DDanModelImpl dDanModel;
    @Override
    public void initModel() {
        dDanModel=new DDanModelImpl();
    }

    @Override
    public void getDDan(int status, int page, int count) {
        dDanModel.getDDan(status, page, count, new IDDanContract.IDDanModel.DataCallBack() {
            @Override
            public void onSuccess(DDanBean dDanBean) {
                iBaseView.onSuccess(dDanBean);
            }

            @Override
            public void onError(String msg) {
                iBaseView.onError(msg);
            }
        });
    }
}
