package com.epam.tc.jdi;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.tc.jdi.site.pages.EpamSite.indexPage;
import static com.epam.tc.jdi.site.pages.IndexPage.loginBar;
import static com.epam.tc.jdi.site.pages.IndexPage.loginForm;
import static com.epam.tc.jdi.site.pages.IndexPage.metalsAndColors;
import static com.epam.tc.jdi.site.pages.MetalsPage.colors;
import static com.epam.tc.jdi.site.pages.MetalsPage.logout;
import static com.epam.tc.jdi.site.pages.MetalsPage.metals;
import static com.epam.tc.jdi.site.pages.MetalsPage.radios;
import static com.epam.tc.jdi.site.pages.MetalsPage.result;
import static com.epam.tc.jdi.site.pages.MetalsPage.submitButton;
import static com.epam.tc.jdi.site.pages.MetalsPage.vegetables;
import static com.epam.tc.jdi.site.pages.MetalsPage.weather;
import static com.epam.tc.jdi.site.pages.elements.DefaultUser.ROMAN;
import static org.hamcrest.Matchers.containsString;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.tc.jdi.site.pages.EpamSite;
import com.epam.tc.jdi.site.pages.elements.DataProviderFromJson;
import com.epam.tc.jdi.site.pages.elements.DataSetForTest;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestJdi {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        initElements(EpamSite.class);
    }

    @Test(dataProviderClass = DataProviderFromJson.class, dataProvider = "data_from_Json")
    public void indexAndMetalsPagesTest(DataSetForTest dataSetForTest) {
        indexPage.open();
        loginBar.click();
        loginForm.loginAs(ROMAN);
        indexPage.checkOpened();

        metalsAndColors.click();

        int val1 = dataSetForTest.summary[0];
        int val2 = dataSetForTest.summary[1];

        int radio1 = 0;
        int radio2 = 0;

        switch (val1) {
            case 1:
                radio1 = 1;
                break;
            case 3:
                radio1 = 2;
                break;
            case 5:
                radio1 = 3;
                break;
            case 7:
                radio1 = 4;
                break;
            default:
                throw new IllegalArgumentException("Wrong input for odd radiobutton number value");
        }
        switch (val2) {
            case 2:
                radio2 = 5;
                break;
            case 4:
                radio2 = 6;
                break;
            case 6:
                radio2 = 7;
                break;
            case 8:
                radio2 = 8;
                break;
            default:
                throw new IllegalArgumentException("Wrong input for even radiobutton number value");
        }

        radios.get(radio1).click();
        radios.get(radio2).click();

        for (String str : dataSetForTest.elements) {
            weather.check(str);
        }

        colors.select(dataSetForTest.color);
        metals.select(dataSetForTest.metals);

        for (String str : dataSetForTest.vegetables) {
            vegetables.check(str);
        }

        submitButton.click();
        int sum = dataSetForTest.summary[0] + dataSetForTest.summary[1];
        result.assertThat().text(containsString("Summary: " + sum));
        result.assertThat().text(containsString("Metal: " + dataSetForTest.metals));
        result.assertThat().text(containsString("Color: " + dataSetForTest.color));

        String elem = dataSetForTest.elements[0];
        for (int i = 1; i < dataSetForTest.elements.length; i++) {
            elem = elem + ", " + dataSetForTest.elements[i];
        }
        String veg = dataSetForTest.vegetables[0];
        for (int i = 1; i < dataSetForTest.vegetables.length; i++) {
            veg = veg + ", " + dataSetForTest.vegetables[i];
        }

        result.assertThat().text(containsString("Elements: " + elem));
        result.assertThat().text(containsString("Vegetables: " + veg));
    }

    @AfterMethod
    public void after() {
        loginBar.click();
        logout.click();
    }
}
