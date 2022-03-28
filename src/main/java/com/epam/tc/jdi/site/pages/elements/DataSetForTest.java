package com.epam.tc.jdi.site.pages.elements;

import java.util.List;

public class DataSetForTest {

    public List<Integer> sum;
    public List<String> elementsList;
    public String color;
    public String metal;
    public List<String> vegetables;
    //      "summary": [1,8],  -- всегда два
    //    "elements": ["Water", "Fire"], --может быть от 1 до 4
    //        "color": "Red",
    //        "metals": "Gold",
    //        "vegetables": ["Cucumber"]  -- может быть от 1 до 4
}
