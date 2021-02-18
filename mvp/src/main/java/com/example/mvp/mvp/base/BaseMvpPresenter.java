package com.example.mvp.mvp.base;

import android.content.Intent;
import android.os.Bundle;

import com.example.mvp.mvp.IMvpView;
import com.example.mvp.mvp.presenter.LifeCircleMvpPresenter;

/*
 * @Author: Luke
 * @Date: 12/23/20 7:47 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public abstract class BaseMvpPresenter<T extends IMvpView> extends LifeCircleMvpPresenter<T> {

    public BaseMvpPresenter(T view){
        super(view);
    }

    @Override
    public void onCreate(Bundle saveInstanceState, Intent intent, Bundle getArguments) {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguments) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void destroyView() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {

    }
}
