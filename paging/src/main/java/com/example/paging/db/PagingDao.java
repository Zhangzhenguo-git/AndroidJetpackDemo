package com.example.paging.db;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PagingDao {
//    这里就是使用了paging的DataSource，用于便捷加载分页数据
    @Query(value = "select * from Student order by name collate nocase asc")
    DataSource.Factory<Integer, Student> getAllStudent();

    @Insert
    void insert(List<Student> students);

    @Insert
    void insert(Student student);
}
