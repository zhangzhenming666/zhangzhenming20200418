package com.bw.zhangzhenming20200414.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public abstract class BaseFragment<p extends BasePresenter> extends Fragment implements IBaseView {
    public p presenter;
    public View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), initLayout(), null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
        initView();
        initListener();
        initData();
    }

    public abstract int initLayout();

    public abstract void initView();

    public abstract void initListener();

    public abstract void initData();

    public abstract p initPresenter();

    @Override
    public void onDetach() {
        super.onDetach();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}
