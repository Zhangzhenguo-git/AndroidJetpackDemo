package com.pack.safflower.model.read;

import com.pack.safflower.R;

import java.util.ArrayList;
import java.util.List;

public class ReadModelImpl implements ReadInterface {

    private static ReadModelImpl instance;

    public static synchronized ReadModelImpl getInstance() {
        if (instance == null) {
            instance = new ReadModelImpl();
        }
        return instance;
    }

    ;

    @Override
    public ReadRightData getRead(int id, String name) {
        return null;
    }


    @Override
    public List<ReadLeftData> getReadLeft() {
        List<ReadLeftData> leftDatas = new ArrayList<>();
        for (int i = 0; i < 35; i++) {
            ReadLeftData leftData = new ReadLeftData();
            leftData.setId(i);
            leftData.setName("left" + i);
            leftData.setSelected(false);
            leftDatas.add(leftData);
        }
        return leftDatas;
    }


    @Override
    public List<ReadRightData> getReadRight(String name) {
        List<ReadRightData> rightDatas = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            ReadRightData rightData = new ReadRightData();
            rightData.setId(i);
            rightData.setName("left" + i);
            rightData.setSelected(false);
            setRightChild(rightDatas, rightData);
        }
        return rightDatas;
    }

    @Override
    public List<ReadLeftData> getAllDatas() {
        List<ReadLeftData> leftDatas = new ArrayList<>();
        List<ReadRightData> rightDatas = new ArrayList<>();
        List<ReadRightChildData> childDataList = new ArrayList<>();
        for (int i = 0; i < 35; i++) {
            ReadLeftData leftData = new ReadLeftData();
            leftData.setId(i);
            leftData.setName("left" + i);
            leftData.setSelected(false);
            for (int q = 0; q < 10; q++) {
                ReadRightData rightData = new ReadRightData();
                rightData.setId(q);
                rightData.setName("left" + i);
                rightData.setSelected(false);
                for (int a = 0; a < 6; a++) {
                    ReadRightChildData childData = new ReadRightChildData();
                    childData.setId(q);
                    childData.setName("left" + q);
                    childData.setImgId(R.mipmap.ic_launcher);
                    childData.setSelected(false);
                    childDataList.add(childData);
                }
                rightData.setChildData(childDataList);
                rightDatas.add(rightData);
            }
            leftData.setRightData(rightDatas);
            leftDatas.add(leftData);
        }
        return leftDatas;
    }

    /**
     * 设置RightChild数据
     */
    private void setRightChild(List<ReadRightData> rightDatas, ReadRightData rightData) {
        List<ReadRightChildData> childDataList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            ReadRightChildData childData = new ReadRightChildData();
            childData.setId(i);
            childData.setName("left" + i);
            childData.setImgId(R.mipmap.ic_launcher);
            childData.setSelected(false);
            childDataList.add(childData);

            rightData.setChildData(childDataList);
            rightDatas.add(rightData);
        }
    }

}
