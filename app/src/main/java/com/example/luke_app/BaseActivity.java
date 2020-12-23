package com.example.luke_app;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

/*
 * @Author: Luke
 * @Date: 12/23/20 6:08 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null) {
            int mainLayoutid = annotation.mainLayoutid();
            if (mainLayoutid > 0) {
                setContentView(mainLayoutid);
                ButterKnife.bind(this);
            } else {
                throw new RuntimeException("mainLayoutid < 0");
            }
        } else {
            throw new RuntimeException("annotation == null");
        }
    }
}
