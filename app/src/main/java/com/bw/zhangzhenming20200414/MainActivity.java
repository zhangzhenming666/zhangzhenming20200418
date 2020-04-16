package com.bw.zhangzhenming20200414;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.bw.zhangzhenming20200414.adapter.MyFragShowAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPagerShow;
    private TabLayout tabShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        MyFragShowAdapter myFragShowAdapter = new MyFragShowAdapter(getSupportFragmentManager());
        viewPagerShow.setAdapter(myFragShowAdapter);
        tabShow.setupWithViewPager(viewPagerShow);
    }

    private void initView() {
        viewPagerShow = (ViewPager) findViewById(R.id.viewPager_show);
        tabShow = (TabLayout) findViewById(R.id.tab_show);
    }
}
