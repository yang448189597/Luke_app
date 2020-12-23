package com.example.luke_app.mvp.presenter;

import com.example.luke_app.mvp.ILifeCircle;
import com.example.luke_app.mvp.IMvpView;
import com.example.luke_app.mvp.MvpController;

import java.lang.ref.WeakReference;

/*
 * @Author: Luke
 * @Date: 12/23/20 7:35 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public abstract class LifeCircleMvpPresenter<T extends IMvpView> implements ILifeCircle {
    protected WeakReference<T> weakReference;
    protected LifeCircleMvpPresenter(){
        super();
    }

    public LifeCircleMvpPresenter(IMvpView iMvpView){
        super();
        attachView(iMvpView);
        MvpController mvpController = iMvpView.getMvpController();
        mvpController.savePresenter(this);
    }

    @Override
    public void attachView(IMvpView iMvpView) {
        if(weakReference == null){
            weakReference = new WeakReference(iMvpView);
        }else {
           T view = (T) weakReference.get();
           if(view != iMvpView){
               weakReference = new WeakReference(iMvpView);
           }
        }
    }

    @Override
    public void onDestroy() {
        weakReference = null;
    }

    protected T getView(){
        T view = weakReference != null ? (T) weakReference.get() : null;
        if(view == null){
            return getEmptyView();
        }
        return view;
    }

    protected abstract T getEmptyView();
}
