package com.example.luke_app.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.luke_app.mvp.IMvpView;
import com.example.luke_app.mvp.MvpController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

/*
 * @Author: Luke
 * @Date: 12/23/20 7:55 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */

// 静态代理类
public class LifeCircleMvpFragment extends Fragment implements IMvpView {
    private MvpController mvpController;

    @Override
    public MvpController getMvpController() {
        if (this.mvpController == null) {
            mvpController = new MvpController();
        }
        return this.mvpController;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if(bundle == null){
            bundle = new Bundle();
        }

        MvpController mvpController = this.getMvpController();
        if(mvpController != null){
            mvpController.onCreate(savedInstanceState,null,bundle);
            mvpController.onActivityCreated(savedInstanceState,null,bundle);
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = this.getArguments();
        if(bundle == null){
            bundle = new Bundle();
        }

        MvpController mvpController = this.getMvpController();
        if(mvpController != null){
            mvpController.onActivityCreated(savedInstanceState,null,bundle);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MvpController mvpController = this.getMvpController();
        if(mvpController != null){
            mvpController.onViewDestroy();
        }
    }

    @Override
    public void onStart( ) {
        super.onStart();
        MvpController mvpController = this.getMvpController();
        if(mvpController != null){
            mvpController.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MvpController mvpController = this.getMvpController();
        if(mvpController != null){
            mvpController.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        MvpController mvpController = this.getMvpController();
        if(mvpController != null){
            mvpController.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        MvpController mvpController = this.getMvpController();
        if(mvpController != null){
            mvpController.onStop();
        }
    }

    @Override
    public void onDestroy() {
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
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpController mvpController = this.getMvpController();
        if(mvpController != null){
            mvpController.onActivityResult(requestCode,resultCode,data);
        }
    }
}
