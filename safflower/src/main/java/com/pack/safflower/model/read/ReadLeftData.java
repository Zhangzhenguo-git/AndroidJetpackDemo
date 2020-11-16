package com.pack.safflower.model.read;

import java.util.List;

public class ReadLeftData {
    private int id;
    private String name;
    private List<ReadRightData> rightData;
    private boolean isSelected;

    public ReadLeftData() {
    }

    public ReadLeftData(int id, String name, List<ReadRightData> rightData, boolean isSelected) {
        this.id = id;
        this.name = name;
        this.rightData = rightData;
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

    public List<ReadRightData> getRightData() {
        return rightData;
    }

    public void setRightData(List<ReadRightData> rightData) {
        this.rightData = rightData;
    }

    @Override
    public String toString() {
        return "ReadLeftData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rightData=" + rightData +
                ", isSelected=" + isSelected +
                '}';
    }
}
