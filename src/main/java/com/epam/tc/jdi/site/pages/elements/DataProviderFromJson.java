package com.epam.tc.jdi.site.pages.elements;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviderFromJson {

    @DataProvider(name = "data_from_Json")
    public Object[][] dataProviding() {

        Sets sets = readJson();
        DataSetForTest[][] dataSetForTest = new DataSetForTest[5][1];
        dataSetForTest[0][0] = sets.get2();
        dataSetForTest[1][0] = sets.get1();
        dataSetForTest[2][0] = sets.get3();
        dataSetForTest[3][0] = sets.get4();
        dataSetForTest[4][0] = sets.get5();

        return dataSetForTest;
    }

    public Sets readJson() {
        Sets sets = null;
        try {
            FileReader reader = new FileReader("src/main/resources/jdi/JDI_ex8_metalsColorsDataSet.json");
            Gson g = new Gson();
            sets = g.fromJson(reader, Sets.class);
        } catch (IOException er) {
            er.printStackTrace();
        }
        return sets;
    }
}
