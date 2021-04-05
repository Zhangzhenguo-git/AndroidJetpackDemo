package com.z.mvvmtwo.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 请求API数据
 */
public class RetrofitClient {

    private static final String BASE_URL="https://api.github.com/";
    private static RetrofitClient retrofitClient;
    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
//                添加工厂，用于对象的序列化和反序列化
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized RetrofitClient getInstance(){
        if (retrofitClient==null){
            retrofitClient=new RetrofitClient();
        }
        return retrofitClient;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }
}
