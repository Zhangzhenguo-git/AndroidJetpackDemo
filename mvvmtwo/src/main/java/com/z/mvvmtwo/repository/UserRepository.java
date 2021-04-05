package com.z.mvvmtwo.repository;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.z.mvvmtwo.api.Api;
import com.z.mvvmtwo.db.UserDao;
import com.z.mvvmtwo.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 用户处理Room中的数据与API接口得来的网络数据之间的业务关系
 */
public class UserRepository {
    private String TAG=this.getClass().getName();
    private UserDao userDao;
    private Api api;



    public UserRepository(UserDao userDao,Api api){
        this.userDao=userDao;
        this.api=api;
    }
    public LiveData<User> getUser(final String name){
        refresh(name);
        return userDao.getUserByName(name);
    }

    /**
     * 刷新数据
     * @param userName
     */
    public void refresh(String userName){
        api.getUser(userName).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.body()!=null){
                    insertUser(response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    /**
     * 插入room数据库
     * @param user
     */
    private void insertUser(User user){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertUser(user);
            }
        });
    }
}
