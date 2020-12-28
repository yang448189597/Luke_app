package com.example.luke_app.main;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.luke_app.R;
import com.example.luke_app.base.BaseActivity;
import com.example.luke_app.base.ViewInject;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(mainLayoutid = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainActivityContact.IView{

    private boolean isChangTopOrBottom;
    IMainActivityContact.IPresenter mPresenter = new MainActivityPresenter(this);


    @BindView(R.id.fac_main_home)
    FloatingActionButton facMainHome;
    @BindView(R.id.rb_main_shanghai)
    RadioButton rbMainShanghai;
    @BindView(R.id.rb_main_hangzhou)
    RadioButton rbMainHangzhou;
    @BindView(R.id.rg_main_top)
    RadioGroup rgMainTop;
    @BindView(R.id.fl_main_bottom)
    FrameLayout flMainBottom;
    @BindView(R.id.rb_main_shenzhen)
    RadioButton rbMainCustomer;
    @BindView(R.id.rb_main_beijing)
    RadioButton rbMainMine;
    @BindView(R.id.rg_main_bottom)
    RadioGroup rgMainBottom;

    @Override
    public void afterBindView() {
        initHomeFragment();
        changeAnima(rgMainBottom, rgMainTop);
    }

    // 初始化fragment
    private void initHomeFragment() {
        mPresenter.initHomeFragment();

    }

    @OnClick(R.id.fac_main_home)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fac_main_home:
                isChangTopOrBottom = !isChangTopOrBottom;
                if (isChangTopOrBottom) {
                    changeAnima(rgMainTop, rgMainBottom);
                } else {
                    changeAnima(rgMainBottom, rgMainTop);
                }
                break;
        }
    }

    private void changeAnima(RadioGroup gone, RadioGroup show) {
        // 消失 动画结束后隐藏
        gone.clearAnimation();
        Animation animationGone = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_hide);
        gone.startAnimation(animationGone);
        gone.setVisibility(View.GONE);

        // 展示 动画
        show.clearAnimation();
        Animation animationShow = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);
    }


    @Override
    public void showFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().show(mFragment).commit();
    }

    @Override
    public void addFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_content,mFragment).commit();
    }

    @Override
    public void hideFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().hide(mFragment).commit();
    }
}