package com.pack.safflower.model.read;

public class ReadRightData {
    private int id;
    private String name;
    private boolean isSelected;

    public ReadRightData() {
    }

    public ReadRightData(int id, String name, boolean isSelected) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "ReadTable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isSelected=" + isSelected +
                '}';
    }

}
