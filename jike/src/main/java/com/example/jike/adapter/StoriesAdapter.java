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
import com.example.jike.bean.LatestBean;

import java.util.ArrayList;
import java.util.List;

public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.ViewHolder> {
    Context context;
    List<LatestBean.StoriesBean> stories =new ArrayList<>();

    public StoriesAdapter(Context context) {
        this.context = context;
    }

    public void getStories(List<LatestBean.StoriesBean> stories){
        this.stories.addAll(stories);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context, R.layout.stories_layout,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        LatestBean.StoriesBean storiesBean = stories.get(i);

        viewHolder.title_stories.setText(storiesBean.getTitle());
        Glide.with(context).load(storiesBean.getImages().get(0)).into(viewHolder.img_stories);
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_stories;
        TextView title_stories;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_stories=itemView.findViewById(R.id.img_stories);
            title_stories=itemView.findViewById(R.id.title_stories);
        }
    }
}
