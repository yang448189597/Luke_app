package com.example.luke_app.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.mvp.mvp.view.LifeCircleMvpFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.ButterKnife;

/*
 * @Author: Luke
 * @Date: 12/23/20 6:08 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public abstract class BaseFragment extends LifeCircleMvpFragment {

    protected Context mContext;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = null;
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null) {
            int mainLayoutid = annotation.mainLayoutid();
            if (mainLayoutid > 0) {
                mView = initFragmentView(inflater,mainLayoutid);
                bindView(mView);
                afterBindView();
            } else {
                throw new RuntimeException("mainLayoutid < 0");
            }
        } else {
            throw new RuntimeException("annotation == null");
        }
        return mView;
    }

    public View initFragmentView(LayoutInflater inflater,int mainLayoutid){

        return inflater.from(mContext).inflate(mainLayoutid,null);

    }


    // 模板方法 设计模式 父类定义规则 具体的实现交给子类
    public abstract void afterBindView();

    // View的依赖注入绑定
    private void bindView(View mView) {

        ButterKnife.bind(this,mView);
    }
}
