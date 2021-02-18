package com.example.luke_app.main.shanghai.presenter;

import com.example.luke_app.base.BasePresenter;
import com.example.luke_app.main.shanghai.If.IShanghaiDetailContact;
import com.example.luke_app.main.shanghai.module.ShangHaiDetailHttpTask;
import com.example.mvp.mvp.base.BaseMvpPresenter;
import com.example.task.LfTask;

/*
 * @Author: Luke
 * @Date: 2/18/21 6:40 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class ShanghaiDetailPresenter extends BasePresenter<IShanghaiDetailContact.IView> implements IShanghaiDetailContact, IShanghaiDetailContact.IPresenter {
    public ShanghaiDetailPresenter(IShanghaiDetailContact.IView view) {
        super(view);
    }

    @Override
    protected IShanghaiDetailContact.IView getEmptyView() {
        return IShanghaiDetailContact.emptyView;
    }

    @Override
    public void getNetData() {
        submitTask(new LfTask() {
            @Override
            public void onSuccess(Object o) {
                //获取网络结果
            }

            @Override
            public void onException(Throwable throwable) {

            }

            // 运行子线程
            @Override
            public Object onBackground() {
                return new ShangHaiDetailHttpTask().getXiaoHuaList("desc","1","2");
            }
        });
    }
}
