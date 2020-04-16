package com.bw.zhangzhenming20200414.base;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public abstract class BasePresenter<view extends IBaseView> {
    public view iBaseView;

    public BasePresenter() {
        initModel();
    }

    public void attachView(view iBaseView) {
        this.iBaseView = iBaseView;
    }

    public void detachView() {
        if (iBaseView != null) {
            iBaseView = null;
        }
    }

    public abstract void initModel();


}
