package com.epam.tc.jdi.site.pages.elements;


public class Sets {
    private DataSetForTest data1;
    private DataSetForTest data2;
    private DataSetForTest data3;
    private DataSetForTest data4;
    private DataSetForTest data5;

    public Sets(DataSetForTest data1, DataSetForTest data2, DataSetForTest data3, DataSetForTest data4,
                DataSetForTest data5) {
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
        this.data5 = data5;
    }

    public DataSetForTest get1() {
        return data1;
    }

    public DataSetForTest get2() {
        return data2;
    }

    public DataSetForTest get3() {
        return data3;
    }

    public DataSetForTest get4() {
        return data4;
    }

    public DataSetForTest get5() {
        return data5;
    }

}
