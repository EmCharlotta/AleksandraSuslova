package com.epam.hw3;

import com.epam.tc.hw3.EpamIndexPage;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class ExerciseOneTest {

    public static String[] getLoginPass() {
        Properties properties = new Properties();

        try (InputStream input = ExerciseOneTest.class.getClassLoader().getResourceAsStream("login.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] logPass = new String[2];
        logPass[0] = properties.getProperty("login");
        logPass [1] = properties.getProperty("password");

        return logPass;
    }


    @Test
    public void exercise1() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        //    1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();
        //    2. Assert Browser title
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(driver.getTitle()).isEqualTo("Home Page");
        //    3. Perform login
        EpamIndexPage epamIndexPage = new EpamIndexPage(driver);
        epamIndexPage.clickToLoginBar();
        epamIndexPage.login(getLoginPass()[0], getLoginPass()[1]);
        epamIndexPage.clickLoginButton();

        //    4. Assert Username is loggined
        soft.assertThat(driver.findElement(By.className("navbar-right")).getText()).contains("ROMAN IOVLEV");
        //    5. Assert that there are 4 items on the header section are displayed and they have proper texts

        List<WebElement> headerItems = epamIndexPage.getHeaderItems();

        soft.assertThat(headerItems.get(0).getText()).isEqualTo("HOME");
        soft.assertThat(headerItems.get(1).getText()).isEqualTo("CONTACT FORM");
        soft.assertThat(headerItems.get(2).getText()).isEqualTo("Service");
        soft.assertThat(headerItems.get(3).getText())
            .isEqualTo("METALS & COLORS");
        //    6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefits = epamIndexPage.getBenefits();
        soft.assertThat(benefits.size()).isEqualTo(4);
        //    7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitsText = epamIndexPage.getBenefitsText();
        soft.assertThat(benefitsText.get(0).getText()).isEqualTo("To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project");
        soft.assertThat(benefitsText.get(1).getText()).isEqualTo("To be flexible and\n"
            + "customizable");
        soft.assertThat(benefitsText.get(2).getText()).isEqualTo("To be multiplatform");
        soft.assertThat(benefitsText.get(3).getText()).isEqualTo("Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…");
        //    8. Assert that there is the iframe with “Frame Button” exist
        soft.assertThat(epamIndexPage.getFrame()).isNotNull();
        //    9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        soft.assertThat(epamIndexPage.getFrameButton()).isNotNull();
        //    10. Switch to original window back
        driver.switchTo().parentFrame();
        //    11. Assert that there are 5 items in the Left Section are displayed and they have proper text

        soft.assertThat(epamIndexPage.getSide("Home").getText()).isEqualTo("Home");
        soft.assertThat(epamIndexPage.getSide("Contact form").getText()).isEqualTo("Contact form");
        soft.assertThat(epamIndexPage.getSide("Service").getText()).isEqualTo("Service");
        soft.assertThat(epamIndexPage.getSide("Metals & Colors").getText()).isEqualTo("Metals & Colors");
        soft.assertThat(epamIndexPage.getSide("Elements packs").getText()).isEqualTo("Elements packs");

        soft.assertAll();
        //    12. Close Browser
        driver.quit();
    }
}
