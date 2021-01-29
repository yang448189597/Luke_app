package com.example.luke_app.main.shanghai.dto;

import java.util.ArrayList;

/*
 * @Author: Luke
 * @Date: 1/20/21 5:38 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class ShanghaiBean {
    private int mItemType = IShanghaiItemType.VERTICAL;
    private String mDec;
    private boolean isShowImg;
    private ArrayList<ShanghaiBean> data;

    public int getmItemType() {
        return mItemType;
    }

    public void setmItemType(int mItemType) {
        this.mItemType = mItemType;
    }

    public String getmDec() {
        return mDec;
    }

    public void setmDec(String mDec) {
        this.mDec = mDec;
    }

    public boolean isShowImg() {
        return isShowImg;
    }

    public void setShowImg(boolean showImg) {
        isShowImg = showImg;
    }

    public ArrayList<ShanghaiBean> getData() {
        return data;
    }

    public void setData(ArrayList<ShanghaiBean> data) {
        this.data = data;
    }

    public interface IShanghaiItemType{
        int VERTICAL = 0;
        int HORIZANTAL =1 ;
    }


}
