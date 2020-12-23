package com.example.luke_app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * @Author: Luke
 * @Date: 12/21/20 6:37 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
@ViewInject(mainLayoutid = R.layout.activity_splash)
public class SplashActivity extends BaseActivity {
    @BindView(R.id.vv_play)
    FullScreenVideoView mVideoView;
    @BindView(R.id.tv_splash_timer)
    TextView tvCountTimer;
    private CustomCountDownTimer timer;// 抽取成员变量快捷键 command+option+f

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        tvCountTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        });

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


        timer = new CustomCountDownTimer(5, new ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                tvCountTimer.setText(time + "秒");
            }

            @Override
            public void onFinish() {
                tvCountTimer.setText("跳过");
            }
        });

        timer.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
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

