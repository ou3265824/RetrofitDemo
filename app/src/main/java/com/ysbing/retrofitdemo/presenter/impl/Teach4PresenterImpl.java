package com.ysbing.retrofitdemo.presenter.impl;

import com.ysbing.retrofitdemo.bean.ApiBean;
import com.ysbing.retrofitdemo.bean.IpBean;
import com.ysbing.retrofitdemo.model.Teach4Model;
import com.ysbing.retrofitdemo.model.impl.Teach4ModelImpl;
import com.ysbing.retrofitdemo.presenter.Teach4Presenter;
import com.ysbing.retrofitdemo.view.ITeach4View;

import rx.Subscriber;

/**
 * IP查询操作接口
 */
public class Teach4PresenterImpl implements Teach4Presenter {
    private ITeach4View teach4View;
    private Teach4Model teach4Model;

    public Teach4PresenterImpl(ITeach4View teach4View) {
        this.teach4View = teach4View;
        teach4Model = new Teach4ModelImpl();
    }

    @Override
    public void queryIpInfo(String ip) {
        Subscriber<ApiBean<IpBean>> mySubscriber = new Subscriber<ApiBean<IpBean>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                teach4View.showError(e);
            }

            @Override
            public void onNext(ApiBean<IpBean> apiBean) {
                teach4View.showIpInfo(apiBean.data);
            }
        };
        teach4Model.queryIpInfo(ip, mySubscriber);
    }
}
