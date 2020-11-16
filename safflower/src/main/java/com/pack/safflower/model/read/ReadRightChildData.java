package com.pack.safflower.model.read;

import java.util.List;

public class ReadRightChildData {
    private int id;
    private String name;
    private int imgId;
    private boolean isSelected;

    public ReadRightChildData() {

    }

    public ReadRightChildData(int id, String name, int imgId, boolean isSelected) {
        this.id = id;
        this.name = name;
        this.imgId = imgId;
        this.isSelected = isSelected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    @Override
    public String toString() {
        return "ReadRightChildData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imgId=" + imgId +
                ", isSelected=" + isSelected +
                '}';
    }
}
