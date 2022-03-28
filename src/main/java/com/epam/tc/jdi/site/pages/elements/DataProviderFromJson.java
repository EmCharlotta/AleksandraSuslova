package com.epam.tc.jdi.site.pages.elements;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.crypto.Data;
import org.testng.annotations.DataProvider;

public class DataProviderFromJson {

    @DataProvider(name = "data_from_Json")
    public Object[][] dataProviding() {
        DataSetForTest[] dataSetForTests = readJson();
        for (DataSetForTest d: dataSetForTests){
            d.color
        }


        return new Object[][];
    }

    public DataSetForTest[] readJson() {
        DataSetForTest[] dataSetForTest = null;
        try {
            BufferedReader reader =
                new BufferedReader(new FileReader("src/main/resources/jdi/JDI_ex8_metalsColorsDataSet.json"));
            Gson g = new Gson();
            dataSetForTest = g.fromJson(reader, DataSetForTest[].class);
        } catch (IOException er) {
            er.printStackTrace();
        }
        return dataSetForTest;
    }
}
