package com.example.dell.myapplication.UI.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CircleFragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private View mView;
    private List<Fragment> mFragment;
    String[] PageTitle={"新闻","视频","图片"};

    public CircleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_circle, container, false);
        initView();
        init();
        return mView;
    }

    private void init() {
        mFragment=new ArrayList<>();
        mFragment.add(new NewsFragment());
        mFragment.add(new VideoFragment());
        mFragment.add(new ImageFragment());

       //当Fragment嵌套Fragment时，里面需要用getChildFragmentManager来获得FragmentManager
        mViewPager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager()));
        //TabLayout与ViewPager关联
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initView() {
        mTabLayout=(TabLayout)mView.findViewById(R.id.tab_layout);
        mViewPager=(ViewPager)mView.findViewById(R.id.view_pager);
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter{
        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragment.get(position);
        }

        @Override
        public int getCount() {
            return mFragment.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return PageTitle[position];
        }
    }
}
