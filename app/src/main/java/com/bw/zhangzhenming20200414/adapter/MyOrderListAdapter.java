package com.bw.zhangzhenming20200414.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.zhangzhenming20200414.R;
import com.bw.zhangzhenming20200414.bean.ddaobean.DetaiListBean;
import com.bw.zhangzhenming20200414.bean.ddaobean.OrderListBean;
import com.bw.zhangzhenming20200414.net.TimeToUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public class MyOrderListAdapter  extends RecyclerView.Adapter<MyOrderListAdapter.MyViewHolder>{
    private List<OrderListBean> orderList = new ArrayList<>();
    private Context context;

    public MyOrderListAdapter(List<OrderListBean> orderList, Context context) {
        this.orderList.addAll(orderList);
        this.context = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_order, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        OrderListBean orderListBean = orderList.get(i);
        int orderStatus = orderListBean.getOrderStatus();
        List<DetaiListBean> detailList = orderListBean.getDetailList();
        for(int j=0;j<detailList.size();j++){
            DetaiListBean detaiListBean = detailList.get(j);
            detaiListBean.setStatus(orderStatus);
        }
        switch (orderStatus){
            case 0:
                onBind0(myViewHolder,orderListBean);
                break;
            case 1:
                onBind1(myViewHolder,orderListBean);
                break;
            case 2:
                onBind2(myViewHolder,orderListBean);
                break;
            case 3:
                onBind3(myViewHolder,orderListBean);
                break;
            case 9:
                onBind9(myViewHolder,orderListBean);
                break;
        }
    }
    private void onBind0(@NonNull MyViewHolder myViewHolder,OrderListBean orderListBean){
        onBind1(myViewHolder,orderListBean);
        onBind2(myViewHolder,orderListBean);
        onBind3(myViewHolder,orderListBean);
        onBind9(myViewHolder,orderListBean);
    }
    @SuppressLint("WrongConstant")
    private void onBind1(@NonNull MyViewHolder myViewHolder, OrderListBean orderListBean){
        myViewHolder.tvOrderNum.setText(orderListBean.getOrderId());
        //时间
        Long aLong = orderListBean.getOrderTime();
        String time = TimeToUtil.getTime(aLong);
        myViewHolder.tvOrderTime.setText(time);
        //信息
        myViewHolder.orderDesc.setText("共"+orderListBean.getPayMethod()+"件商品，需付款"+orderListBean.getPayAmount()+"元");
        //按钮
        myViewHolder.tvCancle.setText("取消订单");
        myViewHolder.tvPay.setText("去支付");
        //数据
        //布局管理器
        RecyclerView recyclerView = myViewHolder.recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        //适配器
        List<DetaiListBean> detailList = orderListBean.getDetailList();
        MyInnerListAdapter myInnerListAdapter = new MyInnerListAdapter(detailList, context);
        recyclerView.setAdapter(myInnerListAdapter);
    }
    @SuppressLint("WrongConstant")
    private void onBind2(@NonNull MyViewHolder myViewHolder, OrderListBean orderListBean){
        myViewHolder.tvOrderNum.setText(orderListBean.getOrderId());
        //时间
        Long aLong = orderListBean.getOrderTime();
        String time = TimeToUtil.getTime(aLong);
        myViewHolder.tvOrderTime.setText(time);
        //信息
        myViewHolder.orderDesc.setText("派件公司:"+orderListBean.getExpressCompName());
        //按钮
        myViewHolder.tvCancle.setText("快递单号:"+orderListBean.getOrderId());
        myViewHolder.tvPay.setText("确认收货");
        //数据
        //布局管理器
        RecyclerView recyclerView = myViewHolder.recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        //适配器
        List<DetaiListBean> detailList = orderListBean.getDetailList();
        MyInnerListAdapter myInnerListAdapter = new MyInnerListAdapter(detailList, context);
        recyclerView.setAdapter(myInnerListAdapter);
    }
    @SuppressLint("WrongConstant")
    private void onBind3(@NonNull MyViewHolder myViewHolder, OrderListBean orderListBean){
        myViewHolder.tvOrderNum.setText(orderListBean.getOrderId());
        //时间
        Long aLong = orderListBean.getOrderTime();
        String time = TimeToUtil.getTime(aLong);
        myViewHolder.tvOrderTime.setText("......");
        //信息
        myViewHolder.orderDesc.setText(time);
        //按钮
        myViewHolder.tvCancle.setText("");
        myViewHolder.tvPay.setText("去评价");
        //数据
        //布局管理器
        RecyclerView recyclerView = myViewHolder.recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        //适配器
        List<DetaiListBean> detailList = orderListBean.getDetailList();
        MyInnerListAdapter myInnerListAdapter = new MyInnerListAdapter(detailList, context);
        recyclerView.setAdapter(myInnerListAdapter);
    }
    @SuppressLint("WrongConstant")
    private void onBind9(@NonNull MyViewHolder myViewHolder, OrderListBean orderListBean){
        myViewHolder.tvOrderNum.setText(orderListBean.getOrderId());
        //时间
        Long aLong = orderListBean.getOrderTime();
        String time = TimeToUtil.getTime(aLong);
        myViewHolder.tvOrderTime.setText("......");
        //信息
        myViewHolder.orderDesc.setText(time);
        //按钮
        myViewHolder.tvCancle.setText("");
        myViewHolder.tvPay.setText("返回主页");
        //数据
        //布局管理器
        RecyclerView recyclerView = myViewHolder.recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        //适配器
        List<DetaiListBean> detailList = orderListBean.getDetailList();
        MyInnerListAdapter myInnerListAdapter = new MyInnerListAdapter(detailList, context);
        recyclerView.setAdapter(myInnerListAdapter);
    }
    @Override
    public int getItemCount() {
        return orderList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvOrderNum;
        private TextView tvOrderTime;
        private RecyclerView recyclerView;
        private TextView orderDesc;
        private TextView tvCancle;
        private TextView tvPay;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOrderNum = (TextView) itemView.findViewById(R.id.tvOrderNum);
            tvOrderTime = (TextView) itemView.findViewById(R.id.tvOrderTime);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
            orderDesc = (TextView) itemView.findViewById(R.id.orderDesc);
            tvCancle = (TextView) itemView.findViewById(R.id.tvCancle);
            tvPay = (TextView) itemView.findViewById(R.id.tvPay);
        }
    }
}
