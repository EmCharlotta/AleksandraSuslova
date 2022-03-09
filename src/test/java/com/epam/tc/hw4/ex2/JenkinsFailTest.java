package com.epam.tc.hw4.ex2;

import com.epam.tc.hw4.ex1.EpamIndexPage;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JenkinsFailTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        context.setAttribute("driver", driver);
    }

    @Test
    public void exercise1() {

        //    1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();
        //    2. Assert Browser title
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(driver.getTitle()).isEqualTo("Home Page");
        //    3. Perform login
        EpamIndexPage epamIndexPage = new EpamIndexPage(driver);
        epamIndexPage.clickToLoginBar();
        epamIndexPage.login("Roman", "Jdi1234");
        epamIndexPage.clickLoginButton();

        //    4. Assert Username is loggined
        soft.assertThat(driver.findElement(By.className("navbar-right")).getText()).contains("ROMAN IOVLEV2");
        soft.assertAll();
        //    12. Close Browser
        driver.quit();
    }
}
