package com.example.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao //room注解
public interface RoomDao {
    //    查询表中所有数据
    @Query(value = "select * from testDb")
    List<RoomEntity> getAll();


    //根据条件查询表中数据
    @Query(value = "select * from testDb where id in (:userIds)")
    List<RoomEntity> getByIdAll(int[] userIds);


//    根据name和age进行模糊查询 且只返回一条
    @Query(value = "select * from testDb where name like :name and age like :age limit 1")
    RoomEntity findByNameAge(String name, int age);

    @Query("select * from testDb where id like :id")
    RoomEntity getUserById(int id);

    @Insert
    void insertAll(RoomEntity... users);//支持可变参数

    @Delete
    void delete(RoomEntity user);//删除指定的user

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(RoomEntity user);//更新，若出现冲突，则使用替换策略，还有其他策略可选择

}
