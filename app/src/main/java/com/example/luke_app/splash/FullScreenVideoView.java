package com.example.luke_app.splash;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/*
 * @Author: Luke
 * @Date: 12/23/20 12:29 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class FullScreenVideoView extends VideoView {
    // 主要用于new 出来对象
    public FullScreenVideoView(Context context) {
        super(context);
    }

    // 主要用于xml文件，支持自定义属性
    public FullScreenVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    // 主要用于xml文件,支持自定义属性，同时支持style
    public FullScreenVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    // 重写onMeasure 方法
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 测量模式
        // 测量大小
        // 获取屏幕尺寸的原始宽高，setMeasuredDimension
        // onMeasure 源码会做一些兼容性的相关处理，重新计算宽高
        int width = getDefaultSize(0,widthMeasureSpec);
        int height = getDefaultSize(0,heightMeasureSpec);
        setMeasuredDimension(width,height);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
