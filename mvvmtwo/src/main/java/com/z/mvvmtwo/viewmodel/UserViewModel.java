package com.z.mvvmtwo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.z.mvvmtwo.MyApplication;
import com.z.mvvmtwo.db.UserDao;
import com.z.mvvmtwo.db.UserDatabase;
import com.z.mvvmtwo.model.User;
import com.z.mvvmtwo.repository.UserRepository;

/**
 * 从Repository层中获取数据，ViewModel不需要关心数据的来源是room还是api接口
 */
public class UserViewModel extends AndroidViewModel {

    private LiveData<User> user;
    private UserRepository userRepository;
    private String userName="MichaelYe";

    public UserViewModel(@NonNull Application application) {
        super(application);
        UserDatabase userDatabase= MyApplication.getUserDatabase();
        UserDao userDao=userDatabase.userDao();
        userRepository=new UserRepository(userDao,MyApplication.getApi());
        user=userRepository.getUser(userName);
    }




}
