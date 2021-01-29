package com.example.luke_app.main.shanghai;

import android.view.View;
import android.widget.TextView;

import com.example.luke_app.R;
import com.example.luke_app.base.BaseFragment;
import com.example.luke_app.base.ViewInject;
import com.example.luke_app.main.shanghai.adapter.ShangHaiAdapter;
import com.example.luke_app.main.shanghai.dto.ShangHaiBeanManager;
import com.example.luke_app.main.shanghai.dto.ShanghaiBean;
import com.example.luke_app.mvp.view.LifeCircleMvpFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/*
 * @Author: Luke
 * @Date: 12/28/20 11:45 AM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
@ViewInject(mainLayoutid = R.layout.fragment_shanghai)
public class ShangHaiFragment extends BaseFragment {

    @BindView(R.id.tv_shanghai_welcome)
    TextView tvShanghaiWelcome;
    @BindView(R.id.shanghai_collapsingToolbarLayout)
    CollapsingToolbarLayout shanghaiCollapsingToolbarLayout;
    @BindView(R.id.shanghai_app_bar_layout)
    AppBarLayout shanghaiAppBarLayout;
    @BindView(R.id.shanghai_recyclerview)
    RecyclerView shanghaiRecyclerview;

    @Override
    public void afterBindView() {
        initRecyclerView();
        initListener();
    }

    private void initRecyclerView() {
        shanghaiRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));

        shanghaiRecyclerview.setAdapter(new ShangHaiAdapter(getActivity(), ShangHaiBeanManager.getData(),false));
    }


    private void initListener() {
        shanghaiAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (-verticalOffset < appBarLayout.getMeasuredHeight() / 2) {
                    tvShanghaiWelcome.setVisibility(View.INVISIBLE);
                } else {
                    tvShanghaiWelcome.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
