package com.z.mvvmtwo.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.z.mvvmtwo.model.User;

/**
 *
 */
@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);


    @Delete()
    void deleteStudent(User user);

    @Query("select * from user where name=:name")
    LiveData<User> getUserByName(String name);
}
