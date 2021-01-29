package com.example.luke_app.main.shanghai.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luke_app.R;
import com.example.luke_app.main.shanghai.dto.ShanghaiBean;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/*
 * @Author: Luke
 * @Date: 1/20/21 5:09 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class ShangHaiAdapter extends RecyclerView.Adapter {

    private final ArrayList<ShanghaiBean> mData;
    private final Context mContext;
    private final boolean mIsHor;
    private final RecyclerView.RecycledViewPool recycledViewPool;

    public ShangHaiAdapter(Context context,ArrayList<ShanghaiBean> data,boolean isHor){
        recycledViewPool = new RecyclerView.RecycledViewPool();
        mContext = context;
        mData = data;
        mIsHor = isHor;
    }

    // 适配器设计模式
    // ViewHolder 创建view 缓存View 节省内存
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 根据不同的类型 绑定不同的viewHolder
        if (viewType == ShanghaiBean.IShanghaiItemType.VERTICAL){
            if(mIsHor){
                Log.e("onCreateViewHolder","vertical");
            }

            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment,parent,false);
            ShangHaiViewHolder viewHolder = new ShangHaiViewHolder(inflate);
            return viewHolder;
        }
        else if(viewType == ShanghaiBean.IShanghaiItemType.HORIZANTAL){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment_rv,null);
            ShangHaiViewHolderRv viewHolder = new ShangHaiViewHolderRv(inflate);
            return viewHolder;
        }
        return null;
    }

    // 每一条条目都会调用一次
    // 绑定数据
    // 节省内存
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShanghaiBean shanghaiBean = mData.get(position);
        if(holder instanceof ShangHaiViewHolder){
            Log.e("onBindViewHolder","vertical"+"position= "+position);
            ((ShangHaiViewHolder)holder).mTV.setText(shanghaiBean.getmDec());
            ((ShangHaiViewHolder)holder).mIv.setVisibility(shanghaiBean.isShowImg()?View.VISIBLE:View.GONE);
            // view 可以设置tag
            ((ShangHaiViewHolder)holder).itemView.setTag(position);

        }
        else if(holder instanceof ShangHaiViewHolderRv){

            ((ShangHaiViewHolderRv)holder).mRv.setAdapter(new ShangHaiAdapter(mContext,shanghaiBean.getData(),true));
        }

    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getmItemType();
    }

    // 所有条目的数量
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // 缓存view
    public class ShangHaiViewHolder extends RecyclerView.ViewHolder{

        private TextView mTV;
        private ImageView mIv;

        public ShangHaiViewHolder(@NonNull View itemView) {
            super(itemView);
            mTV = itemView.findViewById(R.id.item_shanghai_tv);
            mIv = itemView.findViewById(R.id.item_shanghai_img);
            //view 的点击事件 要写在viewHolder 中
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = (int) v.getTag();
                    Toast.makeText(mContext,"我被点击了,点击的position= "+position,Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    // 缓存view
    public class ShangHaiViewHolderRv extends RecyclerView.ViewHolder{

//        private final LinearLayoutManager linearLayoutManager;
//            recycledViewPool 可以实现recycleview 中多个item的复用
        private RecyclerView mRv;

        public ShangHaiViewHolderRv(@NonNull View itemView) {
            super(itemView);
            mRv = itemView.findViewById(R.id.item_shanghai_rv);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
            linearLayoutManager.setRecycleChildrenOnDetach(true);
            mRv.setLayoutManager(linearLayoutManager);
            mRv.setRecycledViewPool(recycledViewPool);

        }
    }
}
