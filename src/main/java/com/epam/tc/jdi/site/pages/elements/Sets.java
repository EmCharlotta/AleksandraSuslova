package com.epam.tc.jdi.site.pages.elements;

import java.util.List;

public class Sets {
    private DataSetForTest data_1;
    private DataSetForTest data_2;
    private DataSetForTest data_3;
    private DataSetForTest data_4;
    private DataSetForTest data_5;

    public Sets(DataSetForTest data_1, DataSetForTest data_2, DataSetForTest data_3, DataSetForTest data_4,
                DataSetForTest data_5) {
        this.data_1 = data_1;
        this.data_2 = data_2;
        this.data_3 = data_3;
        this.data_4 = data_4;
        this.data_5 = data_5;
    }

    public DataSetForTest get1() {
        return data_1;
    }

    public DataSetForTest get2() {
        return data_2;
    }

    public DataSetForTest get3() {
        return data_3;
    }

    public DataSetForTest get4() {
        return data_4;
    }

    public DataSetForTest get5() {
        return data_5;
    }

    @Override
    public String toString() {
        return "Sets{" + "data_1=" + data_1.toString() + ", data_2=" + data_2.toString() + ", data_3="
            + data_3.toString() + ", data_4=" + data_4.toString() + ", data_5=" + data_5.toString() + '}';
    }
}
