package com.example.jike.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jike.Fragment1;
import com.example.jike.R;
import com.example.jike.bean.LatestBean;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends PagerAdapter {
    Context context;
    Fragment1 fragment1;
    ArrayList<View> views;
    List<LatestBean.TopStoriesBean> top_stories =new ArrayList<>();

    public ImageAdapter(Context context,Fragment1 fragment1, ArrayList<View> views) {
        this.context = context;
        this.fragment1 = fragment1;
        this.views = views;
    }

    public void getTop(List<LatestBean.TopStoriesBean> top_stories){
        this.top_stories.addAll(top_stories);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return top_stories.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, int position) {
        final View view = views.get(position);
        final ImageView img = view.findViewById(R.id.img_vp);
        final TextView title = view.findViewById(R.id.title_vp);

        final LatestBean.TopStoriesBean topStoriesBean = top_stories.get(position);

        fragment1.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                title.setText(topStoriesBean.getTitle());
                Glide.with(context).load(topStoriesBean.getImage()).into(img);
                container.addView(view);
            }
        });

        return view;
    }

    @Override
    public void destroyItem(@NonNull final ViewGroup container, final int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
        fragment1.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                container.removeView(views.get(position));
            }
        });

    }
}
