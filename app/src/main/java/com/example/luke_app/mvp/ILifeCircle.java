package com.example.luke_app.mvp;

import android.content.Intent;
import android.os.Bundle;

/*
 * @Author: Luke
 * @Date: 12/23/20 7:27 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public interface ILifeCircle {
    void onCreate(Bundle saveInstanceState, Intent intent,Bundle getArguments);
    void onActivityCreated(Bundle savedInstanceState,Intent intent,Bundle getArguments);
    void onStart();
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();
    void destroyView();
    void onViewDestroy();
    void onNewIntent(Intent intent);
    void onActivityResult(int requestCode,int resultCode,Intent data);
    void onSaveInstanceState(Bundle bundle);
    void attachView(IMvpView iMvpView);
}
