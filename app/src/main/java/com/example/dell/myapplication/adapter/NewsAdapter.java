package com.example.dell.myapplication.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.dell.myapplication.R;
import com.example.dell.myapplication.bean.News;

import java.util.List;

/**
 * Created by dell on 2018/5/9.
 */

public class NewsAdapter extends BaseQuickAdapter<News,BaseViewHolder> {
    public NewsAdapter(@LayoutRes int layoutResId, @Nullable List<News> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, News item) {
        helper.setText(R.id.tv_title,item.getTitle());
        helper.setText(R.id.tv_content,item.getContent());
        Glide.with(mContext).load(item.getImageUrl()).error(R.mipmap.ic_launcher).into((ImageView)helper.getView(R.id.iv_image));
        // load( ) 网络图片的URL;  into() 需要显示图片的目标 ImageView
    }
}
