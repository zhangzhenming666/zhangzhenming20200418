package com.bw.zhangzhenming20200414.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bw.zhangzhenming20200414.R;
import com.bw.zhangzhenming20200414.fragment.Frag_Login;
import com.bw.zhangzhenming20200414.fragment.Frag_Register;
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
public class MyFrag_LoginAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments=new ArrayList<>();
    private List<String> strings=new ArrayList<>();

    public MyFrag_LoginAdapter(FragmentManager fm) {
        super(fm);
        strings.add("登录");
        strings.add("注册");
        fragments.add(new Frag_Login());
        fragments.add(new Frag_Register());
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
