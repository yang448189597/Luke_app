package com.example.luke_app.main.shanghai.If;

import com.example.luke_app.main.IMainActivityContact;
import com.example.mvp.mvp.ILifeCircle;
import com.example.mvp.mvp.IMvpView;
import com.example.mvp.mvp.MvpController;

import androidx.fragment.app.Fragment;

/*
 * @Author: Luke
 * @Date: 2/18/21 6:42 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public interface IShanghaiDetailContact {
    interface IView extends IMvpView {

    }

    interface IPresenter extends ILifeCircle {

        void getNetData();
    }

    IShanghaiDetailContact.IView emptyView = new IShanghaiDetailContact.IView() {

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
