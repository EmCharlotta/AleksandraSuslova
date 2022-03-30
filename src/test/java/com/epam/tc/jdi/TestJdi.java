package com.epam.tc.jdi;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
//import static com.epam.jdi.light.ui.html.PageFactory.initElements;
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

import com.epam.tc.jdi.site.pages.EpamSite;
import com.epam.tc.jdi.site.pages.elements.DataProviderFromJson;
import com.epam.tc.jdi.site.pages.elements.DataSetForTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestJdi {

    private WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        initElements(driver, EpamSite.class);
    }

    @Test(dataProviderClass = DataProviderFromJson.class, dataProvider = "data_from_Json")
    public void indexAndMetalsPagesTest(DataSetForTest dataSetForTest) {
        indexPage.open();
        loginBar.click();
        loginForm.loginAs(ROMAN);
        indexPage.checkOpened();

        metalsAndColors.click();

        radioOdd.select(String.valueOf(dataSetForTest.summary[0]));
        radioEven.select(String.valueOf(dataSetForTest.summary[1]));

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
        result.assertThat().text(containsString(String.valueOf("Summary: " + sum)));
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
}
