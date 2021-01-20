package com.example.luke_app.main.shanghai.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.luke_app.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 * @Author: Luke
 * @Date: 1/20/21 5:09 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class ShangHaiAdapter extends RecyclerView.Adapter {

    private final ArrayList<String> mData;

    public ShangHaiAdapter(ArrayList<String> data){
        mData = data;

    }

    // 适配器设计模式
    // ViewHolder 创建view 缓存View 节省内存
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment,null);
        ShangHaiViewHolder viewHolder = new ShangHaiViewHolder(inflate);
        return viewHolder;
    }

    // 每一条条目都会调用一次
    // 绑定数据
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String s = mData.get(position);
        ((ShangHaiViewHolder)holder).mTV.setText(s);

    }

    // 所有条目的数量
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // 缓存view
    public class ShangHaiViewHolder extends RecyclerView.ViewHolder{

        private TextView mTV;

        public ShangHaiViewHolder(@NonNull View itemView) {
            super(itemView);
            mTV = itemView.findViewById(R.id.item_shanghai_tv);
        }
    }
}
