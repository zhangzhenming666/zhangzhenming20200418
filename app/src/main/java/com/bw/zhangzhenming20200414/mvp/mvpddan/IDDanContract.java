package com.bw.zhangzhenming20200414.mvp.mvpddan;


import com.bw.zhangzhenming20200414.base.IBaseView;
import com.bw.zhangzhenming20200414.bean.ddaobean.DDanBean;

public interface IDDanContract {
    //
    interface IDDanView extends IBaseView {
        //成功
        void onSuccess(DDanBean dDanBean);
        //失败
        void onError(String msg);
    }
    //
    interface IDDanModel{
        void getDDan(int status, int page, int count, DataCallBack dataCallBack);
        interface DataCallBack{
            //成功
            void onSuccess(DDanBean dDanBean);
            //失败
            void onError(String msg);
        }
    }
    //
    interface IDDanPresenter{
        void getDDan(int status, int page, int count);
    }
}
