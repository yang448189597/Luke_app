package com.example.luke_app.splash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.example.luke_app.base.BaseActivity;
import com.example.luke_app.main.MainActivity;
import com.example.luke_app.R;
import com.example.luke_app.base.ViewInject;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

/*
 * @Author: Luke
 * @Date: 12/21/20 6:37 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
@ViewInject(mainLayoutid = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashActivityContact.IView {
    @BindView(R.id.vv_play)
    FullScreenVideoView mVideoView;
    @BindView(R.id.tv_splash_timer)
    TextView tvCountTimer;
    private ISplashActivityContact.IPresenter timerPresenter;

    @Override
    public void afterBindView() {

        initTimerPresenter();
        initListener();
        initVideo();
    }


    private void initTimerPresenter() {
        timerPresenter = new SplashTimerPresenter(SplashActivity.this);
        timerPresenter.initTimer();
    }

    private void initVideo() {

        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    public void setTvTimer(String s) {
        tvCountTimer.setText(s);
    }

    private void initListener() {

        tvCountTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });

    }

    @OnClick(R.id.tv_splash_timer)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_splash_timer:
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                break;
            default:
                break;
        }
    }
}

