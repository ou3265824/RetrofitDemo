package com.example.testretrofit.apiserver;

import com.example.testretrofit.entity.AppConfig;
import com.example.testretrofit.entity.BaseEntity;
import com.example.testretrofit.entity.ProductDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/4/25.
 */
public interface ApiServer {

    public static String pid="IP000185";
    public static String cid="14766";
    public static String token="60c62ce38b6ccebd262498c5ae7e5d51";
    public static String seed="1c498fdbe4315728";
    public static String url="http://test.ddearn.com/appservice.svc/GetConfigInfo/Token=6ac6cf6541cd36781a3ae53b289153e6&Seed=075f604aec23de2d";


//    http://test.ddearn.com/appservice.svc/GetProductDetail/Product_ID=IP000185&Cust_ID=14766&Token=60c62ce38b6ccebd262498c5ae7e5d51&Seed=1c498fdbe4315728

    @GET("GetProductDetail/Product_ID={Product_ID}&Cust_ID={Cust_ID}&Token={Token}&Seed={Seed}")
    Call<BaseEntity<ProductDetails>> getProductDetail3(@Path("Product_ID") String Product_ID, @Path("Cust_ID") String Cust_ID, @Path("Token") String token, @Path("Seed") String seed);
    @FormUrlEncoded
    @POST("GetProductDetail")
    Call<BaseEntity<ProductDetails>> getProductDetail4(@Field("Product_ID") String Product_ID, @Field("Cust_ID") String Cust_ID, @Field("Token") String token, @Field("Seed") String seed);
    @GET("GetProductDetail")
    Call<BaseEntity<ProductDetails>> getProductDetail(@Query("Product_ID") String Product_ID, @Query("Cust_ID") String Cust_ID, @Query("Token") String token, @Query("Seed") String seed);

    @GET("GetProductDetail/Token=60c62ce38b6ccebd262498c5ae7e5d51&Seed=1c498fdbe4315728")
    Call<BaseEntity<ProductDetails>> getProductDetail2(@Query("Product_ID") String Product_ID, @Query("Cust_ID") String Cust_ID);

    @GET("GetProductDetail/Product_ID=IP000185&Cust_ID=14766&Token=60c62ce38b6ccebd262498c5ae7e5d51&Seed=1c498fdbe4315728")
    Call<BaseEntity<ProductDetails>> getProductDetail();


    //    http://test.ddearn.com/appservice.svc/GetConfigInfo/Token=6ac6cf6541cd36781a3ae53b289153e6&Seed=075f604aec23de2d
    @GET("GetConfigInfo/Token=6ac6cf6541cd36781a3ae53b289153e6&Seed=075f604aec23de2d")
    Call<BaseEntity<List<AppConfig>>> GetConfigInfo();






}
