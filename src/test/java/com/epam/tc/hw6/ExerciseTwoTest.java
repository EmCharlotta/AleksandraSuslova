package com.epam.tc.hw6;

import com.epam.tc.hw6.service.webdriver.WebDriverProvider;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.assertj.core.api.AssertionsForClassTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExerciseTwoTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(ITestContext context) {
        driver = WebDriverProvider.getDriver();
    }

    @Feature("Index and Second page testing")
    @Test
    public void exercise2() {
        //        1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();
        //        2. Assert Browser title
        AssertionsForClassTypes.assertThat(driver.getTitle()).isEqualTo("Home Page");
        //        3. Perform login
        EpamIndexPage epamIndexPage = new EpamIndexPage(driver);
        performLogin(epamIndexPage, "Roman", "Jdi1234");
        //        4. Assert User name in the left-top side of screen that user is loggined
        AssertionsForClassTypes.assertThat(driver.findElement(By.className("navbar-right")).getText())
                               .contains("ROMAN IOVLEV");
        //        5. Open through the header menu Service -> Different Elements Page

        epamIndexPage.clickHeaderMenu();
        epamIndexPage.clickDifferentElement();

        //        6. Select checkboxes
        SecondPage secondPage = new SecondPage(driver);

        secondPage.getCheckboxes().get(0).click();
        secondPage.getCheckboxes().get(2).click();

        //        7. Select radio
        secondPage.getRadios().get(3).click();
        //        8. Select in dropdown

        WebElement content = secondPage.getContent();
        Select colors = new Select(content.findElement(By.className("uui-form-element")));
        colors.selectByVisibleText("Yellow");
        //        9. Assert that
        //•for each checkbox there is an individual log row and value is corresponded to the status
        //of checkbox
        WebElement list = secondPage.getList();
        AssertionsForClassTypes.assertThat(list.getText()).contains("Water: condition changed to true");
        AssertionsForClassTypes.assertThat(list.getText()).contains("Wind: condition changed to true");
        //•for radio button there is a log row and value is corresponded to the status of radio button
        AssertionsForClassTypes.assertThat(list.getText()).contains("metal: value changed to Selen");
        //•for dropdown there is a log row and value is corresponded to the selected value.
        AssertionsForClassTypes.assertThat(list.getText()).contains("Colors: value changed to Yellow");
        //       10. Close Browser
        driver.quit();
    }

    @Story("perform login")
    @Step
    public void performLogin(EpamIndexPage epamIndexPage, String userName, String userPassword) {
        epamIndexPage.clickToLoginBar();
        epamIndexPage.login(userName, userPassword);
        epamIndexPage.clickLoginButton();
    }
}
