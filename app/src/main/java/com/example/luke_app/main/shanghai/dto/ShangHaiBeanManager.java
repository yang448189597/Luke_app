package com.example.luke_app.main.shanghai.dto;

import java.util.ArrayList;

/*
 * @Author: Luke
 * @Date: 1/20/21 6:03 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class ShangHaiBeanManager {


    // 竖向数据
    private static ArrayList<ShanghaiBean> getVerData(int len){
        ArrayList<ShanghaiBean> data = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ShanghaiBean bean = new ShanghaiBean();
            bean.setShowImg(false);
            bean.setmDec("上海是个好地方");
            data.add(bean);
        }
        return data;
    }

    // 横向数据
    private static ArrayList<ShanghaiBean> getHorData(int len){
        ArrayList<ShanghaiBean> data = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ShanghaiBean bean = new ShanghaiBean();
            bean.setShowImg(true);
            bean.setmDec("上海是个魔都");
            data.add(bean);
        }
        return data;
    }

    public static ArrayList<ShanghaiBean> getData(){
        ArrayList<ShanghaiBean> data = new ArrayList<>();
        data.addAll(getVerData(5));
        ShanghaiBean bean = new ShanghaiBean();
        bean.setData(getHorData(10));
        bean.setmItemType(ShanghaiBean.IShanghaiItemType.HORIZANTAL);
        data.add(bean);

        data.addAll(getVerData(5));
        ShanghaiBean bean1 = new ShanghaiBean();
        bean1.setData(getHorData(10));
        bean1.setmItemType(ShanghaiBean.IShanghaiItemType.HORIZANTAL);
        data.add(bean1);

        return data;


    }
}
