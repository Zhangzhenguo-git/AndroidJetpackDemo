package com.example.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {RoomEntity.class}, version = 1)
public abstract class RooDatabase extends RoomDatabase {

    public static final String DB_NAME = "testDb";
    private static RooDatabase instance;

    //    数据库单例
    public static synchronized RooDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, RooDatabase.class, DB_NAME)
                    .allowMainThreadQueries()//默认room不允许在主线程操作数据库，这里设置允许
                    .build();
        }
        return instance;
    }

    public abstract RoomDao getUserDao();
}
