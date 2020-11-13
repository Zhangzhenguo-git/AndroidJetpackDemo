package com.pack.safflower.model.read;

import java.util.List;

public class ReadModelImpl implements ReadInterface{

    private static ReadModelImpl instance;

    public static synchronized ReadModelImpl getInstance(){
        if (instance==null){
            instance=new ReadModelImpl();
        }
        return instance;
    };

    @Override
    public ReadRightData getRead(int id, String name) {
        return null;
    }

    @Override
    public List<ReadLeftData> getReadLeft() {
        List<ReadLeftData> leftDatas=null;
        for (int i=0;i<15;i++){
            ReadLeftData leftData=new ReadLeftData();
            leftData.setId(i);
            leftData.setName("left"+i);
            leftData.setSelected(false);
            leftDatas.add(leftData);
        }
        return leftDatas;
    }


    @Override
    public List<ReadRightData> getReadRight(int id, String name) {
        List<ReadRightData> rightDatas=null;
        for (int i=0;i<15;i++){
            ReadRightData rightData=new ReadRightData();
            rightData.setId(i);
            rightData.setName("right"+i);
            rightData.setSelected(false);
            rightDatas.add(rightData);
        }
        return rightDatas;
    }

}
