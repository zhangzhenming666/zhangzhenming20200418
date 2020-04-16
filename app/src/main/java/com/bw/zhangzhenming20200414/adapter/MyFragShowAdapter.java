package com.bw.zhangzhenming20200414.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bw.zhangzhenming20200414.R;
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
public class MyFragShowAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> strings = new ArrayList<>();



    public MyFragShowAdapter(@NonNull FragmentManager fm) {
        super(fm);
        strings.add("首页");
        strings.add("分类" );
        strings.add("购物车"  );
        strings.add("我的" );
        fragments.add(new Frag_one());
        fragments.add(new Frag_two());
        fragments.add(new Frag_three());
        fragments.add(new Frag_forue());
    }

    @NonNull
    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
