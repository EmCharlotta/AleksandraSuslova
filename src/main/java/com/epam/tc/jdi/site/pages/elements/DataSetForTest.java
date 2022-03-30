package com.epam.tc.jdi.site.pages.elements;

import java.util.Arrays;

public class DataSetForTest {

    public int[] summary;
    public String[] elements;
    public String color;
    public String metals;
    public String[] vegetables;

    public DataSetForTest(int[] sum, String[] elementsList, String color, String metal, String[] vegetables) {
        this.summary = sum;
        this.elements = elementsList;
        this.color = color;
        this.metals = metal;
        this.vegetables = vegetables;
    }

    @Override
    public String toString() {
        return "DataSetForTest{" + "summary=" + Arrays.toString(summary) + ", elements=" + Arrays.toString(elements)
            + ", color='" + color + '\'' + ", metals='" + metals + '\'' + ", vegetables=" + Arrays.toString(vegetables)
            + '}';
    }
}
