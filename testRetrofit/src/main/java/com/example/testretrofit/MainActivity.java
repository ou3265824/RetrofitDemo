package com.example.testretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.testretrofit.apiserver.ApiServer;
import com.example.testretrofit.entity.BaseEntity;
import com.example.testretrofit.entity.ProductDetails;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getprode(ApiServer.pid,ApiServer.cid,ApiServer.token,ApiServer.seed);
            }
        });
        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestActivity.class));
            }
        });
    }


    private String url="http://test.ddearn.com/appservice.svc/";

    public void getprode(String prodid,String custid,String token,String seed){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        ApiServer apiServer=retrofit.create(ApiServer.class);
//        Toast.makeText(getApplicationContext(),prodid+"---"+custid+"---"+token+"---"+seed , Toast.LENGTH_SHORT).show();
//        Call<BaseEntity<ProductDetails>> productDetail=apiServer.getProductDetail4(prodid, custid, token, seed);

        Call<BaseEntity<ProductDetails>> productDetail=apiServer.getProductDetail3(prodid, custid, token, seed);

//        Call<BaseEntity<ProductDetails>> productDetail=apiServer.getProductDetail(prodid, custid, token, seed);
//        Call<BaseEntity<ProductDetails>> productDetail=apiServer.getProductDetail2(prodid, custid);
//        Call<BaseEntity<ProductDetails>> productDetail=apiServer.getProductDetail();
         productDetail.enqueue(new Callback<BaseEntity<ProductDetails>>() {
             @Override
             public void onResponse(Call<BaseEntity<ProductDetails>> call, Response<BaseEntity<ProductDetails>> response) {
                 BaseEntity baseEntity=response.body();
//                Toast.makeText(getApplicationContext(),baseEntity.getStateExplain(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), baseEntity.getStateCode() + "---" + baseEntity.getStateExplain() + "---" + baseEntity.getDataObj(), Toast.LENGTH_SHORT).show();
//                ProductDetails productDetails= (ProductDetails) baseEntity.getDataObj();

//                Log.i("test",baseEntity+"--");
//                Toast.makeText(getApplicationContext(),productDetails.toString(),Toast.LENGTH_SHORT).show();
//                Log.i("test", response != null ? "ok" : "no");
             }

             @Override
             public void onFailure(Call<BaseEntity<ProductDetails>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(),t.toString()+"" , Toast.LENGTH_SHORT).show();

             }
         });


//        Call<BaseEntity<List<AppConfig>>> productDetail=apiServer.GetConfigInfo();
//        productDetail.enqueue(new Callback<BaseEntity<List<AppConfig>>>() {
//            @Override
//            public void onResponse(Response<BaseEntity<List<AppConfig>>> response, Retrofit retrofit) {
//                BaseEntity baseEntity=response.body();
//                List<AppConfig> appConfig= (List<AppConfig>) baseEntity.getDataObj();
//
//                Toast.makeText(getApplicationContext(),baseEntity.getDataObj()+"" , Toast.LENGTH_SHORT).show();
//                Log.i("test",baseEntity+"--");
////                Toast.makeText(getApplicationContext(),baseEntity.getStateCode()+"---"+baseEntity.getStateExplain()+"---"+a,Toast.LENGTH_SHORT).show();
//                Log.i("test", response != null ? "ok" : "no");
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
