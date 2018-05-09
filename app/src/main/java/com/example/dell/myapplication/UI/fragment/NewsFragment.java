package com.example.dell.myapplication.UI.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.myapplication.R;
import com.example.dell.myapplication.adapter.NewsAdapter;
import com.example.dell.myapplication.bean.News;
import com.example.dell.myapplication.net.HttpResult;
import com.example.dell.myapplication.net.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private View mView;
    private List<News> mNews;
    private NewsAdapter mNewsAdapter;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_news, container, false);
        initView();
        init();
        return mView;
    }

    private void init() {
        mNews=new ArrayList<>();
        mNewsAdapter=new NewsAdapter(R.layout.item_view_news,mNews);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mNewsAdapter);
        RetrofitUtil.getNews(new Callback<HttpResult<List<News>>>() {
            @Override
            public void onResponse(Call<HttpResult<List<News>>> call, Response<HttpResult<List<News>>> response) {
               mNewsAdapter.addData(response.body().getData());
            }

            @Override
            public void onFailure(Call<HttpResult<List<News>>> call, Throwable t) {

            }
        });
    }

    private void initView() {
        mRecyclerView=(RecyclerView)mView.findViewById(R.id.recycler_view);
    }

}
