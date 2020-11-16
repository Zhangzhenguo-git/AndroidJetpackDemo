package com.pack.safflower.model.read;

import java.util.List;

public class ReadRightData {
    private int id;
    private String name;
    private List<ReadRightChildData> childData;
    private boolean isSelected;

    public ReadRightData() {
    }

    public ReadRightData(int id, String name, List<ReadRightChildData> childData, boolean isSelected) {
        this.id = id;
        this.name = name;
        this.childData = childData;
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

    public List<ReadRightChildData> getChildData() {
        return childData;
    }

    public void setChildData(List<ReadRightChildData> childData) {
        this.childData = childData;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public String toString() {
        return "ReadRightData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", childData=" + childData +
                ", isSelected=" + isSelected +
                '}';
    }

}
