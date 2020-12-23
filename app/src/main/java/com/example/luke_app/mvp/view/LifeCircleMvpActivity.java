package com.example.luke_app.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.luke_app.mvp.IMvpView;
import com.example.luke_app.mvp.MvpController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
 * @Author: Luke
 * @Date: 12/23/20 7:55 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */

// 静态代理类
public class LifeCircleMvpActivity extends AppCompatActivity implements IMvpView {
    private MvpController mvpController;

    @Override
    public MvpController getMvpController() {
        if (this.mvpController == null) {
            mvpController = new MvpController();
        }
        return this.mvpController;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        if(intent == null){
            intent = new Intent();
        }
        MvpController mvpController = this.getMvpController();
        if(mvpController != null){
            mvpController.onCreate(savedInstanceState,intent,null);
            mvpController.onActivityCreated(savedInstanceState,intent,null);
        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MvpController mvpController = this.getMvpController();
        if(mvpController != null){
            mvpController.onNewIntent(intent);
        }
    }

    @Override
    protected void onStart( ) {
        super.onStart();
        MvpController mvpController = this.getMvpController();
        if(mvpController != null){
            mvpController.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MvpController mvpController = this.getMvpController();
        if(mvpController != null){
            mvpController.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        MvpController mvpController = this.getMvpController();
        if(mvpController != null){
            mvpController.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        MvpController mvpController = this.getMvpController();
        if(mvpController != null){
            mvpController.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MvpController mvpController = this.getMvpController();
        if(mvpController != null){
            mvpController.onDestroy();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        MvpController mvpController = this.getMvpController();
        if(mvpController != null){
            mvpController.onSaveInstanceState(outState);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpController mvpController = this.getMvpController();
        if(mvpController != null){
            mvpController.onActivityResult(requestCode,resultCode,data);
        }
    }
}
