package com.bw.zhangzhenming20200414.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.zhangzhenming20200414.R;
import com.bw.zhangzhenming20200414.bean.ddaobean.DetaiListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public class MyInnerListAdapter extends RecyclerView.Adapter<MyInnerListAdapter.MyViewHolder>{
    private List<DetaiListBean> detailList = new ArrayList<>();
    private Context context;

    public MyInnerListAdapter(List<DetaiListBean> detailList, Context context) {
        this.detailList = detailList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_inner, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        //字符串  多张图片
        String commodityPic = detailList.get(i).getCommodityPic();
        String[] split = commodityPic.split(",");
        myViewHolder.img.setImageURI(split[0]);
        myViewHolder.name.setText(detailList.get(i).getCommodityName());
        myViewHolder.money.setText("$:"+detailList.get(i).getCommodityPrice()+"元");
    }

    @Override
    public int getItemCount() {
        return detailList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView img;
        private TextView name;
        private TextView money;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (SimpleDraweeView) itemView.findViewById(R.id.img);
            name = (TextView) itemView.findViewById(R.id.name);
            money = (TextView) itemView.findViewById(R.id.money);
        }
    }
}
