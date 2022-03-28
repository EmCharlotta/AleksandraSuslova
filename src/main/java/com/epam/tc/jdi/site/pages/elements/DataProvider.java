package com.epam.tc.jdi.site.pages.elements;

import org.testng.annotations.DataProvider;

public class DataProviderFromJson {

    @DataProvider (name = "data_from_Json")
    public Object[][] dataProviding(){
        return new Object[][];
    }
}
