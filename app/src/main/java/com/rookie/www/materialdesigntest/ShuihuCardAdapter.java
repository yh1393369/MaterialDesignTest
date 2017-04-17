package com.rookie.www.materialdesigntest;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Hi on 2017/4/17.
 */

public class ShuihuCardAdapter extends RecyclerView.Adapter<ShuihuCardAdapter.ViewHolder>{

    private Context context;
    private List<ShuihuCard> shuihuCardList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView ivShuihucard;
        TextView tvShuihucard;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            ivShuihucard = (ImageView) itemView.findViewById(R.id.ivShuihucard);
            tvShuihucard = (TextView) itemView.findViewById(R.id.tvShuihucard);
        }
    }

    public ShuihuCardAdapter(List<ShuihuCard> shuihuCardList) {
        this.shuihuCardList = shuihuCardList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(context == null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.shuihucard_item_rvmain, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ShuihuCard shuihuCard = shuihuCardList.get(position);
        holder.tvShuihucard.setText(shuihuCard.getCardName());
        Glide.with(context).load(shuihuCard.getImageId()).into(holder.ivShuihucard);
    }

    @Override
    public int getItemCount() {
        return shuihuCardList.size();
    }

}
