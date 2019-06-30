package com.example.jike.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.jike.R;
import com.example.jike.bean.DiscriptionBean;

import java.util.ArrayList;
import java.util.List;

public class DiscriptionAdapter extends RecyclerView.Adapter<DiscriptionAdapter.ViewHolder> {
    Context context;
    List<DiscriptionBean.DataBean> data =new ArrayList<>();

    public DiscriptionAdapter(Context context) {
        this.context = context;
    }

    public void getDiscription(List<DiscriptionBean.DataBean> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context, R.layout.discription_layout,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        DiscriptionBean.DataBean dataBean = data.get(i);

        viewHolder.tv_discription.setText(dataBean.getDescription());
        viewHolder.tv1_discription.setText(dataBean.getName());

        RoundedCorners roundedCorners = new RoundedCorners(15);
        RequestOptions requestOptions = RequestOptions.bitmapTransform(roundedCorners);
        Glide.with(context).load(dataBean.getThumbnail())
                .apply(requestOptions).into(viewHolder.img_discription);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_discription;
        TextView tv_discription;
        TextView tv1_discription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_discription=itemView.findViewById(R.id.img_discription);
            tv_discription=itemView.findViewById(R.id.tv_discription);
            tv1_discription=itemView.findViewById(R.id.tv1_discription);
        }
    }
}
