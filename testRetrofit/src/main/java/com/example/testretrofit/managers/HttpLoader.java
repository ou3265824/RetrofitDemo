package com.example.testretrofit.managers;

import com.example.testretrofit.Builder.LoggingInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2016/4/27.
 */
public class HttpLoader {


    public HttpLoader() {
        /**
         * 拦截器
         * 出现错误重新连接
         * 设置超时时间
         */
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor())
                .retryOnConnectionFailure(true).connectTimeout(15, TimeUnit.SECONDS).build();


    }
}
