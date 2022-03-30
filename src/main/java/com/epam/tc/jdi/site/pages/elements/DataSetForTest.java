package com.epam.tc.jdi.site.pages.elements;

import java.util.List;

public class DataSetForTest {

    public List<Integer> sum;
    public List<String> elementsList;
    public String color;
    public String metal;
    public List<String> vegetables;

    public DataSetForTest(List<Integer> sum, List<String> elementsList, String color, String metal,
                          List<String> vegetables) {
        this.sum = sum;
        this.elementsList = elementsList;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;
    }
}
