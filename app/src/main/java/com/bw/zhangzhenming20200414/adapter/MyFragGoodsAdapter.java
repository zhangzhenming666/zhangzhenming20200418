package com.bw.zhangzhenming20200414.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bw.zhangzhenming20200414.R;
import com.bw.zhangzhenming20200414.base.BaseFragment;
import com.bw.zhangzhenming20200414.fragment.Frag_Goods;
import com.bw.zhangzhenming20200414.fragment.Frag_forue;
import com.bw.zhangzhenming20200414.fragment.Frag_one;
import com.bw.zhangzhenming20200414.fragment.Frag_three;
import com.bw.zhangzhenming20200414.fragment.Frag_two;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public class MyFragGoodsAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments=new ArrayList<>();
    private List<String> strings=new ArrayList<>();

    public MyFragGoodsAdapter(FragmentManager fm) {
        super(fm);
        strings.add("全部");
        strings.add("待付款");
        strings.add("待收货");
        strings.add("待评价");
        strings.add("已完成");
        for(int i=0;i<strings.size()-1;i++){
            fragments.add(Frag_Goods.newInstance(i));
        }
        fragments.add(Frag_Goods.newInstance(9));
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
