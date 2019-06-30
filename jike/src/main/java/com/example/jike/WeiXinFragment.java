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

import com.example.jike.adapter.SingleAdapter;
import com.example.jike.bean.WeiXinBean;
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
public class WeiXinFragment extends Fragment {

    private static final String TAG = "tag";
    private RecyclerView recycler_weixin;
    private SingleAdapter singleAdapter;

    public WeiXinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weixin, container, false);
        initView(view);
        getWeiXinData();
        return view;
    }

    private void getWeiXinData() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder()
                .url("http://api.tianapi.com/wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
                .build();
        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: =========ok===="+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                WeiXinBean weiXinBean = new Gson().fromJson(string, WeiXinBean.class);
                final List<WeiXinBean.NewslistBean> newslist = weiXinBean.getNewslist();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        singleAdapter.getWeiXinNews(newslist);
                    }
                });
            }
        });
    }

    private void initView(View view) {
        recycler_weixin = (RecyclerView) view.findViewById(R.id.recycler_weixin);
        recycler_weixin.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler_weixin.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        singleAdapter = new SingleAdapter(getContext());
        recycler_weixin.setAdapter(singleAdapter);
    }

}
