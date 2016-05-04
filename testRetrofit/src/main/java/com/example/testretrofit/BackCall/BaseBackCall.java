package com.example.testretrofit.BackCall;

import okhttp3.Response;

/**
 * Created by Administrator on 2016/4/27.
 */
public abstract class BaseBackCall {

    public abstract void onFailure();
    public abstract void onSucced(Response succed);

}
