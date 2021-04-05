package com.z.mvvmtwo.api;

import com.z.mvvmtwo.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 定义访问接口
 */
public interface Api {

    @GET("users/{userId}")
    Call<User> getUser(@Path("userId")String userId);

}
