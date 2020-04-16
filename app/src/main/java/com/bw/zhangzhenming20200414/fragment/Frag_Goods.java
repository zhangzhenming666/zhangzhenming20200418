package com.bw.zhangzhenming20200414.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.zhangzhenming20200414.R;
import com.bw.zhangzhenming20200414.adapter.MyOrderListAdapter;
import com.bw.zhangzhenming20200414.base.BaseFragment;
import com.bw.zhangzhenming20200414.bean.ddaobean.DDanBean;
import com.bw.zhangzhenming20200414.bean.ddaobean.OrderListBean;
import com.bw.zhangzhenming20200414.mvp.mvpddan.DDanPresenterImpl;
import com.bw.zhangzhenming20200414.mvp.mvpddan.IDDanContract;


import java.util.List;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public class Frag_Goods extends BaseFragment<DDanPresenterImpl> implements IDDanContract.IDDanView {
    private RecyclerView recycler;

    public static Frag_Goods newInstance(int status) {
        Bundle args = new Bundle();
        args.putInt("status",status);
        Frag_Goods fragment = new Frag_Goods();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int initLayout() {
        return R.layout.frag_goods;
    }
    @SuppressLint("WrongConstant")
    @Override
    public void initView() {
        recycler = (RecyclerView) view.findViewById(R.id.recycler);
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);
    }
    @Override
    public void initListener() {
    }
    @Override
    public void initData() {
        //取值  状态值
        Bundle bundle = getArguments();
        int status = bundle.getInt("status");
        presenter.getDDan(status,1,10);
    }
    @Override
    public DDanPresenterImpl initPresenter() {
        return new DDanPresenterImpl();
    }
    @Override
    public void onSuccess(DDanBean dDanBean) {
        List<OrderListBean> orderList = dDanBean.getOrderList();
        //适配器
        MyOrderListAdapter myOrderListAdapter = new MyOrderListAdapter(orderList, getContext());
        recycler.setAdapter(myOrderListAdapter);
    }
    @Override
    public void onError(String msg) {
    }
}
