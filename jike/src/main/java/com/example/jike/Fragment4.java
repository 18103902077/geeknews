package com.example.jike;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jike.adapter.RecentAdapter;
import com.example.jike.bean.RecentOutBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment4 extends Fragment {
    private static final String TAG = "tag";
    private View view;
    private RecyclerView rec4;
    private RecentAdapter recentAdapter;


    public Fragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment4, container, false);
        initView(view);
        getRecent();
        return view;
    }

    private void getRecent() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder()
                .url("http://news-at.zhihu.com/api/4/news/hot")
                .build();
        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: =========ok===="+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                RecentOutBean recentOutBean = new Gson().fromJson(string, RecentOutBean.class);
                final List<RecentOutBean.RecentBean> recent = recentOutBean.getRecent();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recentAdapter.getRecent(recent);
                    }
                });
            }
        });
    }

    private void initView(View view) {
        rec4 = (RecyclerView) view.findViewById(R.id.rec4);
        rec4.setLayoutManager(new LinearLayoutManager(getContext()));
        rec4.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        recentAdapter = new RecentAdapter(getContext());
        rec4.setAdapter(recentAdapter);
    }

}
