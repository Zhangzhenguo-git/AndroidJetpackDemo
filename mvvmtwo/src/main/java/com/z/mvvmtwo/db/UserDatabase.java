package com.z.mvvmtwo.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.z.mvvmtwo.model.User;

/**
 * 创建room数据库
 */
@Database(entities = {User.class},version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static final String DATABASE_NAME="user_db";
    private static UserDatabase database;

    /**
     * 实例化database
     * @param context
     * @return
     */
    public static synchronized UserDatabase getInstance(Context context){
        if (database==null){
            database= Room.databaseBuilder(context.getApplicationContext(),UserDatabase.class,DATABASE_NAME).build();
        }
        return database;
    }

    /**
     * 获取dao
     * @return
     */
    public abstract UserDao userDao();
}
