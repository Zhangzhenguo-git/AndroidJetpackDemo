package com.example.livedata.temp;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

public class LiveDataUser {
    //    普通属性
    private String city;
    //    动态更新属性
    private MutableLiveData<String> name = new MediatorLiveData<>();//live响应的属性
    private MutableLiveData<Integer> age = new MutableLiveData<>();//live属性

    public LiveDataUser(String city, String name, Integer age) {
        this.city = city;
        this.name.setValue(name);
        this.age.setValue(age);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public MutableLiveData<Integer> getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age.setValue(age);
    }
}
