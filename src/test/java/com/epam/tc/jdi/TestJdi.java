package com.epam.tc.jdi;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.tc.hw6.temp.TemporaryUser.ROMAN;
import static com.epam.tc.jdi.site.pages.EpamSite.indexPage;
import static com.epam.tc.jdi.site.pages.IndexPage.loginBar;
import static com.epam.tc.jdi.site.pages.IndexPage.loginForm;
import static com.epam.tc.jdi.site.pages.IndexPage.metalsAndColors;
import static com.epam.tc.jdi.site.pages.MetalsPage.submitButton;

import com.epam.tc.jdi.site.pages.EpamSite;
import com.epam.tc.jdi.site.pages.elements.DataProviderFromJson;
import com.epam.tc.jdi.site.pages.elements.DataSetForTest;
import com.google.gson.Gson;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestJdi {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        initElements(EpamSite.class);
    }

    @Test (dataProviderClass = DataProviderFromJson.class, dataProvider = "data_from_Json")
    public void indexAndMetalsPagesTest() {
        indexPage.open();
        loginBar.click();
        loginForm.loginAs(ROMAN);
        indexPage.checkOpened();

        metalsAndColors.click();


        //fill form with data providers

        //        setText(String value);
        //        getText();
        //        input(String text);
        //        setAttribute(String name, String value);
        //        select(String name);
        //        setValue(String value);
        //        show();
        //        hover();
        //        find(By) / find(String) / finds(String)
        //        isDisabled() / isHidden()
        //        select() -> new Select(myElement)

        submitButton.click();

        //assert Result section
        //        redButton.assertThat().text(is(“Submit”));
        //        notification.is().displayed();
        //        teaser.assertThat().text(containsString(“JDI is Awesome"))
        //            .cssClass(is(“jdi-teaser")).attr("type", is(“submit"));
        //        results.is().notEmpty();
        //        results.assertThat().values(hasItem(“JDI"));
    }
}
