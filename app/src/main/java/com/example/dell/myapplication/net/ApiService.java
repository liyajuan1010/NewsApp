package com.example.dell.myapplication.net;

import com.example.dell.myapplication.bean.News;

import java.util.List;
import java.util.NavigableMap;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dell on 2018/5/9.
 */

public interface ApiService {
    @GET("getNews.php")
    Call<HttpResult<List<News>>> getNews();
}
