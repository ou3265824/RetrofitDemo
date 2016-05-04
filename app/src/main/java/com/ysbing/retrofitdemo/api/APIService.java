package com.ysbing.retrofitdemo.api;
/*Retrofit2.0*/

import com.ysbing.retrofitdemo.bean.ApiBean;
import com.ysbing.retrofitdemo.bean.DemoBean;
import com.ysbing.retrofitdemo.bean.IpBean;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface APIService {

    @GET("/service/getIpInfo.php")
    Call<DemoBean> getIpInfo(@Query("ip") String ip);

    @GET("/service/getIpInfo.php")
    Call<ApiBean<IpBean>> getIpInfo2(@Query("ip") String ip);
}