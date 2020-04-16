package com.bw.zhangzhenming20200414.fragment;

import android.text.TextUtils;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.bw.zhangzhenming20200414.R;
import com.bw.zhangzhenming20200414.adapter.MyFragGoodsAdapter;
import com.bw.zhangzhenming20200414.base.BaseFragment;
import com.bw.zhangzhenming20200414.base.BasePresenter;
import com.bw.zhangzhenming20200414.net.SpUtil;
import com.google.android.material.tabs.TabLayout;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public class Frag_forue extends BaseFragment {
    private TextView tvPhone;
    private TabLayout tabGoods;
    private ViewPager viewPagerGoods;

    @Override
    public int initLayout() {
        return R.layout.frag_ddan;
    }
    @Override
    public void initView() {
        tvPhone = (TextView) view.findViewById(R.id.tv_phone);
        tabGoods = (TabLayout) view.findViewById(R.id.tab_goods);
        viewPagerGoods = (ViewPager) view.findViewById(R.id.viewPager_goods);
    }
    @Override
    public void initListener() {
    }
    @Override
    public void initData() {
        String headPic = SpUtil.getString("headPic");
        String nickName = SpUtil.getString("nickName");
        if(!TextUtils.isEmpty(headPic)){
            //img.setImageURI(headPic);
            tvPhone.setText(nickName);
        }
        //适配器
        MyFragGoodsAdapter myFragGoodsAdapter = new MyFragGoodsAdapter(getChildFragmentManager());
        viewPagerGoods.setAdapter(myFragGoodsAdapter);
        tabGoods.setupWithViewPager(viewPagerGoods);
    }
    @Override
    public BasePresenter initPresenter() {
        return null;
    }
}
