package com.epam.tc.hw2;

import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExerciseOneTest {
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
        driver.findElement(By.className("navbar-right")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
        //    4. Assert Username is loggined
        soft.assertThat(driver.findElement(By.className("navbar-right")).getText()).contains("ROMAN IOVLEV");
        //    5. Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement navigationMenu = driver.findElement(By.className("navbar-nav"));
        soft.assertThat(driver.findElement(By.xpath("//*[text()='Home']")).getText()).isEqualTo("HOME");
        soft.assertThat(driver.findElement(By.xpath("//*[text()='Contact form']")).getText()).isEqualTo("CONTACT FORM");
        soft.assertThat(driver.findElement(By.xpath("//*[text()='Service']")).getText()).isEqualTo("Service");
        soft.assertThat(driver.findElement(By.xpath("//*[text()='Metals & Colors']")).getText())
            .isEqualTo("METALS & COLORS");
        //    6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefits = driver.findElements(By.className("benefit-icon"));
        soft.assertThat(benefits.size()).isEqualTo(4);
        //    7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitsText = driver.findElements(By.className("benefit-txt"));
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
        soft.assertThat(driver.findElement(By.id("frame"))).isNotNull();
        //    9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        soft.assertThat(driver.findElement(By.id("frame-button"))).isNotNull();
        //    10. Switch to original window back
        driver.switchTo().parentFrame();
        //    11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        WebElement sidebar = driver.findElement(By.className("sidebar-menu"));
        soft.assertThat(sidebar.findElement(By.linkText("Home")).getText()).isEqualTo("Home");
        soft.assertThat(sidebar.findElement(By.linkText("Contact form")).getText()).isEqualTo("Contact form");
        soft.assertThat(sidebar.findElement(By.linkText("Service")).getText()).isEqualTo("Service");
        soft.assertThat(sidebar.findElement(By.linkText("Metals & Colors")).getText()).isEqualTo("Metals & Colors");
        soft.assertThat(sidebar.findElement(By.linkText("Elements packs")).getText()).isEqualTo("Elements packs");

        soft.assertAll();
        //    12. Close Browser
        driver.quit();
    }
}
