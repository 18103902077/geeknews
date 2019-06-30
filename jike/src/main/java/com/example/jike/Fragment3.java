package com.example.jike;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jike.adapter.DiscriptionAdapter;
import com.example.jike.bean.DiscriptionBean;
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
public class Fragment3 extends Fragment {

    private static final String TAG = "tag";
    private View view;
    private RecyclerView rec3;
    private DiscriptionAdapter discriptionAdapter;


    public Fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);
        initView(view);
        getDiscription();
        return view;
    }

    private void getDiscription() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder()
                .url("http://news-at.zhihu.com/api/4/sections")
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
                    DiscriptionBean discriptionBean = new Gson().fromJson(string, DiscriptionBean.class);
                    final List<DiscriptionBean.DataBean> data = discriptionBean.getData();

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            discriptionAdapter.getDiscription(data);

                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initView(View view) {
        rec3 = (RecyclerView) view.findViewById(R.id.rec3);

        rec3.setLayoutManager(new GridLayoutManager(getContext(),2));
        rec3.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        discriptionAdapter = new DiscriptionAdapter(getContext());
        rec3.setAdapter(discriptionAdapter);

    }

}
