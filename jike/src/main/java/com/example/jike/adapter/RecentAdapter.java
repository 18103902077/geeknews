package com.example.jike.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jike.R;
import com.example.jike.bean.RecentOutBean;

import java.util.ArrayList;
import java.util.List;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.ViewHolder> {
    Context context;
    List<RecentOutBean.RecentBean> recent =new ArrayList<>();

    public RecentAdapter(Context context) {
        this.context = context;
    }

    public void getRecent(List<RecentOutBean.RecentBean> recent){
        this.recent.addAll(recent);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context, R.layout.recent_layout,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        RecentOutBean.RecentBean recentBean = recent.get(i);

        viewHolder.title_recent.setText(recentBean.getTitle());
        Glide.with(context).load(recentBean.getThumbnail()).into(viewHolder.img_recent);
    }

    @Override
    public int getItemCount() {
        return recent.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_recent;
        TextView title_recent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_recent=itemView.findViewById(R.id.img_recent);
            title_recent=itemView.findViewById(R.id.title_recent);
        }
    }
}
