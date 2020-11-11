package com.example.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.room.databinding.ActivityRoomBinding;

import java.util.List;

public class RoomActivity extends AppCompatActivity {

    private ActivityRoomBinding binding;
    private RooDatabase instance;
    private RoomDao roomDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(RoomActivity.this, R.layout.activity_room);
        instance = RooDatabase.getInstance(this);
//        删除数据
        deleteDatabase(RooDatabase.DB_NAME);
        roomDao = instance.getUserDao();
    }

    //    插入一条数据
    public void insert(View view) {
        StringBuffer buffer = new StringBuffer();
        RoomEntity entity;
        for (int i = 0; i < 6; i++) {
            entity = new RoomEntity();
            entity.setName("小明"+i);
            entity.setAge(20+i);
            entity.setCity("上海"+i);
            entity.setSingle(i % 2 == 0);
            roomDao.insertAll(entity);
            buffer.append(entity.toString()).append("\n");
        }
        binding.tvInsertRoom.setText(buffer.toString());

        getAll();
    }

    //获取所有数据
    private void getAll() {
        List<RoomEntity> list = roomDao.getAll();
        StringBuffer sb = new StringBuffer();
        if (list != null) {
            for (RoomEntity user:list){
                sb.append("uid: ")
                        .append(user.getId())
                        .append("姓名: ")
                        .append(user.getName())
                        .append("年龄: ")
                        .append(user.getAge())
                        .append("城市: ")
                        .append(user.getCity())
                        .append("Single: ")
                        .append(user.isSingle())
                        .append("\n");
            }
            String text = "All Size ： " + list.size();
            binding.tvSizeRoom.setText(text);
            binding.tvAllRoom.setText(sb.toString());
        }

    }

    public void delete(View view) {
        RoomEntity user = roomDao.findByNameAge("小明" + 3, 23);
        if (user!=null){
            roomDao.delete(user);
            binding.tvDeleteRoom.setText(user.toString());
            getAll();
        }
    }

    public void update(View view) {
        RoomEntity user = roomDao.findByNameAge("小明" + 2, 22);
        if (user!=null){
            user.setAge(33);
            user.setCity("上海");
            user.setName("张三");
            user.setSingle(true);
            roomDao.update(user);
            binding.tvUpdateRoom.setText(user.toString());
            getAll();
        }
    }

    public void queryId(View view) {
        RoomEntity userById = roomDao.getUserById(3);
        if (userById != null) {
            binding.tvQueryIdRoom.setText(userById.toString());
        } else {
            Toast.makeText(this, "id=3 的user查询不到", Toast.LENGTH_SHORT).show();
        }
        //为了显示操作后的更新数据
        getAll();
    }

    public void queryAll(View view) {
        getAll();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance.clearAllTables();
    }
}