package com.example.jike;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jike.adapter.ImageAdapter;
import com.example.jike.adapter.StoriesAdapter;
import com.example.jike.bean.LatestBean;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {
    private static final String TAG = "tag";
    private View view;
    private RecyclerView rec1;
    private StoriesAdapter storiesAdapter;
    private ViewPager vp_latest;


    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        initView(view);
        getLatest();
        return view;
    }

    private void getLatest() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder()
                .url("http://news-at.zhihu.com/api/4/news/latest")
                .build();
        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: =========ok====" + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String string = response.body().string();
                    LatestBean latestBean = new Gson().fromJson(string, LatestBean.class);
                    final List<LatestBean.StoriesBean> stories = latestBean.getStories();
                    final List<LatestBean.TopStoriesBean> top_stories = latestBean.getTop_stories();

                    final ArrayList<View> views = new ArrayList<>();
                    for (int i = 0; i <top_stories.size() ; i++) {
                        View view = LayoutInflater.from(getActivity()).inflate(R.layout.vp_layout, null);
                        views.add(view);
                    }
/*

                     final ArrayList<View> views = new ArrayList<>();

                    JSONObject jsonObject = new JSONObject(string);
                    JSONArray top_stories = jsonObject.getJSONArray("top_stories");
                    for (int i = 0; i < top_stories.length(); i++) {
                        JSONObject json = top_stories.getJSONObject(i);
                        String image = json.optString("image");
                        String title = json.optString("title");

                        View view = LayoutInflater.from(getActivity()).inflate(R.layout.vp_layout, null);
                        ImageView img_vp = view.findViewById(R.id.img_vp);
                        TextView title_vp = view.findViewById(R.id.title_vp);

                        title_vp.setText(title);
                        Glide.with(getActivity()).load(image).into(img_vp);
                        views.add(view);
                    }
*/

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ImageAdapter imageAdapter = new ImageAdapter(getContext(),Fragment1.this, views);
                            vp_latest.setAdapter(imageAdapter);

                            imageAdapter.getTop(top_stories);
                            storiesAdapter.getStories(stories);

                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initView(View view) {
        rec1 = (RecyclerView) view.findViewById(R.id.rec1);
        vp_latest = (ViewPager) view.findViewById(R.id.vp_latest);

        rec1.setLayoutManager(new LinearLayoutManager(getContext()));
        rec1.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        storiesAdapter = new StoriesAdapter(getContext());
        rec1.setAdapter(storiesAdapter);


    }

}
