package com.example.dell.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.dell.myapplication.UI.fragment.CircleFragment;
import com.example.dell.myapplication.UI.fragment.FindFragment;
import com.example.dell.myapplication.UI.fragment.MeFragment;
import com.example.dell.myapplication.UI.fragment.MessageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar mBottomNavigationBar;
    private List<Fragment> mFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
    }

    private void init() {
        mFragment=new ArrayList<>();
        mFragment.add(new CircleFragment());
        mFragment.add(new FindFragment());
        mFragment.add(new MessageFragment());
        mFragment.add(new MeFragment());

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.nav_circle_selector,"动态"))
                .addItem(new BottomNavigationItem(R.drawable.nav_find_selector,"发现"))
                .addItem(new BottomNavigationItem(R.drawable.nav_message_selector,"消息"))
                .addItem(new BottomNavigationItem(R.drawable.nav_me_selector,"我的"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .initialise();
        mBottomNavigationBar.setTabSelectedListener(this);
        setFragment(0);
    }

    private void setFragment(int i) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,mFragment.get(i));
        ft.commit();
    }

    private void initView() {
        mBottomNavigationBar=(BottomNavigationBar)findViewById(R.id.bottom_navigation_bar);
    }

    @Override
    public void onTabSelected(int position) {
          setFragment(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
