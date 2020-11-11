package com.example.paging;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.room.RoomDatabase;

import com.example.paging.db.PagingDao;
import com.example.paging.db.Student;
import com.example.paging.db.StudentDatabase;

public class PagingPresenter {
    //    每页显示个数
    private static final int PAGE_SIZE = 15;
    private static final boolean ENABLE_PLACEHOLDERS = false;
    public LiveData<PagedList<Student>> allStudents;
    private Context context;
    private PagingDao pagingDao;


    public PagingPresenter(Context context) {
        this.context = context;
        pagingDao= StudentDatabase.getInstance(context).getStudentDao();
        allStudents = new LivePagedListBuilder(pagingDao.getAllStudent(),
                new PagedList.Config.Builder()
                        .setPageSize(PAGE_SIZE)                         //配置分页加载的数量
                        .setEnablePlaceholders(ENABLE_PLACEHOLDERS)     //配置是否启动PlaceHolders
                        .setInitialLoadSizeHint(PAGE_SIZE)              //初始化加载的数量
                        .build()
        ).build();
    }

    void insertStudent(String name) {
        pagingDao.insert(new Student(name));
    }
}
