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
import com.example.jike.bean.WeiXinBean;

import java.util.ArrayList;
import java.util.List;

public class SingleAdapter extends RecyclerView.Adapter<SingleAdapter.ViewHolder> {
    Context context;
    List<WeiXinBean.NewslistBean> newslist =new ArrayList<>();

    public SingleAdapter(Context context) {
        this.context = context;
    }

    public void getWeiXinNews(List<WeiXinBean.NewslistBean> newslist){
        this.newslist.addAll(newslist);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context, R.layout.weixin_layout,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        WeiXinBean.NewslistBean newslistBean = newslist.get(i);
        viewHolder.author.setText(newslistBean.getDescription());
        viewHolder.time.setText(newslistBean.getCtime());
        viewHolder.title.setText(newslistBean.getTitle());
        Glide.with(context).load(newslistBean.getPicUrl()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return newslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;
        TextView author;
        TextView time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_weixin);
            title=itemView.findViewById(R.id.title_weixin);
            author=itemView.findViewById(R.id.author_weixin);
            time=itemView.findViewById(R.id.time_weixin);
        }
    }
}
