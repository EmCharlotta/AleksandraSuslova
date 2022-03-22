package com.epam.tc.hw6;

import com.epam.tc.hw6.service.webdriver.WebDriverProvider;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import java.util.List;
import org.assertj.core.api.AssertionsForClassTypes;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExerciseOneTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverProvider.getDriver();
    }

    @Feature("index page testing")
    @Test
    public void exercise1() {
        //    1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();
        //    2. Assert Browser title
        //    3. Perform login
        EpamIndexPage epamIndexPage = new EpamIndexPage(driver);
        AssertionsForClassTypes.assertThat(driver.getTitle()).isEqualTo("Home Page");
        performLogin(epamIndexPage, "Roman", "Jdi1234");
        //    5. Assert that there are 4 items on the header section are displayed and they have proper texts

        List<WebElement> headerItems = epamIndexPage.getHeaderItems();

        AssertionsForClassTypes.assertThat(headerItems.get(0).getText()).isEqualTo("HOME");
        AssertionsForClassTypes.assertThat(headerItems.get(1).getText()).isEqualTo("CONTACT FORM");
        AssertionsForClassTypes.assertThat(headerItems.get(2).getText()).isEqualTo("Service");
        AssertionsForClassTypes.assertThat(headerItems.get(3).getText())
                               .isEqualTo("METALS & COLORS");
        //    6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefits = epamIndexPage.getBenefits();
        AssertionsForClassTypes.assertThat(benefits.size()).isEqualTo(4);
        //    7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitsText = epamIndexPage.getBenefitsText();
        AssertionsForClassTypes.assertThat(benefitsText.get(0).getText()).isEqualTo("To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project");
        AssertionsForClassTypes.assertThat(benefitsText.get(1).getText()).isEqualTo("To be flexible and\n"
            + "customizable");
        AssertionsForClassTypes.assertThat(benefitsText.get(2).getText()).isEqualTo("To be multiplatform");
        AssertionsForClassTypes.assertThat(benefitsText.get(3).getText()).isEqualTo("Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…");
        //    8. Assert that there is the iframe with “Frame Button” exist
        AssertionsForClassTypes.assertThat(epamIndexPage.getFrame()).isNotNull();
        //    9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        AssertionsForClassTypes.assertThat(epamIndexPage.getFrameButton()).isNotNull();
        //    10. Switch to original window back
        driver.switchTo().parentFrame();
        //    11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        //    12. Close Browser
        driver.quit();
    }

    @Story("perform login")
    @Step
    public void performLogin(EpamIndexPage epamIndexPage, String userName, String userPassword) {
        epamIndexPage.clickToLoginBar();
        epamIndexPage.login(userName, userPassword);
        epamIndexPage.clickLoginButton();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverProvider.closeDriver();
    }
}
