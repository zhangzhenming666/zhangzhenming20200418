package com.bw.zhangzhenming20200414;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bw.zhangzhenming20200414.adapter.MyFrag_LoginAdapter;
import com.google.android.material.tabs.TabLayout;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public class LoginActivity extends AppCompatActivity {

    private TabLayout tabLogin;
    private ViewPager viewPagerLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        //适配器
        MyFrag_LoginAdapter myFrag_loginAdapter = new MyFrag_LoginAdapter(getSupportFragmentManager());
        viewPagerLogin.setAdapter(myFrag_loginAdapter);
        tabLogin.setupWithViewPager(viewPagerLogin);
    }


    //跳转的fragment标记
    public void setintent(){
        viewPagerLogin.setCurrentItem(0);
    }

    private void initView() {
        tabLogin = (TabLayout) findViewById(R.id.tab_login);
        viewPagerLogin = (ViewPager) findViewById(R.id.viewPager_login);
    }
}
