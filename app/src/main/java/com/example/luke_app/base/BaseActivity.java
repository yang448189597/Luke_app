package com.example.luke_app.base;

import android.os.Bundle;

import com.example.luke_app.mvp.view.LifeCircleMvpActivity;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;

/*
 * @Author: Luke
 * @Date: 12/23/20 6:08 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public abstract class BaseActivity extends LifeCircleMvpActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null) {
            int mainLayoutid = annotation.mainLayoutid();
            if (mainLayoutid > 0) {
                setContentView(mainLayoutid);
                bindView();
                afterBindView();
            } else {
                throw new RuntimeException("mainLayoutid < 0");
            }
        } else {
            throw new RuntimeException("annotation == null");
        }
    }


    // 模板方法 设计模式 父类定义规则 具体的实现交给子类
    public abstract void afterBindView();

    // View的依赖注入绑定
    private void bindView() {

        ButterKnife.bind(this);
    }
}
