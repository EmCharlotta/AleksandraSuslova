package com.epam.tc.jdi;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.tc.hw6.temp.TemporaryUser.ROMAN;
import static com.epam.tc.jdi.site.pages.EpamSite.indexPage;
import static com.epam.tc.jdi.site.pages.IndexPage.loginBar;
import static com.epam.tc.jdi.site.pages.IndexPage.loginForm;
import static com.epam.tc.jdi.site.pages.IndexPage.metalsAndColors;
import static com.epam.tc.jdi.site.pages.MetalsPage.colors;
import static com.epam.tc.jdi.site.pages.MetalsPage.metals;
import static com.epam.tc.jdi.site.pages.MetalsPage.radioEven;
import static com.epam.tc.jdi.site.pages.MetalsPage.radioOdd;
import static com.epam.tc.jdi.site.pages.MetalsPage.result;
import static com.epam.tc.jdi.site.pages.MetalsPage.submitButton;
import static com.epam.tc.jdi.site.pages.MetalsPage.vegetables;
import static com.epam.tc.jdi.site.pages.MetalsPage.weather;
import static com.epam.tc.jdi.site.pages.elements.DefaultUser.ROMAN;
import static org.hamcrest.Matchers.containsString;

import com.epam.tc.hw6.service.webdriver.WebDriverProvider;
import com.epam.tc.jdi.site.pages.EpamSite;
import com.epam.tc.jdi.site.pages.elements.DataProviderFromJson;
import com.epam.tc.jdi.site.pages.elements.DataSetForTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestJdi {

    private WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        driver = WebDriverProvider.getDriver();
        initElements(EpamSite.class);
    }

    @Test(dataProviderClass = DataProviderFromJson.class, dataProvider = "data_from_Json")
    public void indexAndMetalsPagesTest(DataSetForTest dataSetForTest) {
        indexPage.open();
        loginBar.click();
        loginForm.loginAs(ROMAN);
        indexPage.checkOpened();

        metalsAndColors.click();

        radioOdd.select(String.valueOf(dataSetForTest.sum.get(0)));
        radioEven.select(String.valueOf(dataSetForTest.sum.get(1)));

        for (String str : dataSetForTest.elementsList) {
            weather.check(str);
        }

        colors.select(dataSetForTest.color);
        metals.select(dataSetForTest.metal);

        for (String str : dataSetForTest.vegetables) {
            vegetables.check(str);
        }

        submitButton.click();
        int sum = dataSetForTest.sum.get(0) + dataSetForTest.sum.get(1);
        result.assertThat().text(containsString(String.valueOf("Summary: " + sum)));
        result.assertThat().text(containsString("Metal: " + dataSetForTest.metal));
        result.assertThat().text(containsString("Color: " + dataSetForTest.color));

        String elem = dataSetForTest.elementsList.get(0);
        for (int i = 1; i < dataSetForTest.elementsList.size(); i++) {
            elem = elem + ", " + dataSetForTest.elementsList.get(i);
        }
        String veg = dataSetForTest.vegetables.get(0);
        for (int i = 1; i < dataSetForTest.vegetables.size(); i++) {
            veg = veg + ", " + dataSetForTest.vegetables.get(i);
        }

        result.assertThat().text(containsString("Elements: " + elem));
        result.assertThat().text(containsString("Vegetables: " + veg));
    }
}
