package com.pack.safflower.model.read;

import java.util.List;

public interface ReadInterface {
    ReadRightData getRead(int id, String name);
    List<ReadLeftData> getReadLeft();
    List<ReadRightData> getReadRight(int id, String name);

}
