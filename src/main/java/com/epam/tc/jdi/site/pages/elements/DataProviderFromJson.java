package com.epam.tc.jdi.site.pages.elements;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.DataProvider;

public class DataProviderFromJson {

    @DataProvider(name = "data_from_Json")
    public Object[][] dataProviding() {

        Sets sets = readJson();
        List<DataSetForTest> dataSetForTest = sets.getSets;

        return  ;
    }

    public Sets readJson() {
        Sets sets = null;
        try {
            BufferedReader reader =
                new BufferedReader(new FileReader("src/main/resources/jdi/JDI_ex8_metalsColorsDataSet.json"));
            Gson g = new Gson();
            sets = g.fromJson(reader, Sets.class);
        } catch (IOException er) {
            er.printStackTrace();
        }
        return sets;
    }
}
