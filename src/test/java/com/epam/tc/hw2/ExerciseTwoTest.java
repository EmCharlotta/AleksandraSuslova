package com.epam.tc.hw2;

import java.util.List;
import org.assertj.core.api.AssertionsForClassTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ExerciseTwoTest {
    @Test
    public void exercise2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        //        1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();
        //        2. Assert Browser title
        AssertionsForClassTypes.assertThat(driver.getTitle()).isEqualTo("Home Page");
        //        3. Perform login
        driver.findElement(By.className("navbar-right")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
        //        4. Assert User name in the left-top side of screen that user is loggined
        AssertionsForClassTypes.assertThat(driver.findElement(By.className("navbar-right")).getText())
                               .contains("ROMAN IOVLEV");
        //        5. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.className("navbar-nav")).click();
        driver.findElement(By.xpath("//*[text()='Different elements']")).click();

        //        6. Select checkboxes
        List<WebElement> checkboxes = driver.findElements(By.className("label-checkbox"));
        checkboxes.get(0).click();
        checkboxes.get(2).click();
        //        7. Select radio
        List<WebElement> radio = driver.findElements(By.className("label-radio"));
        radio.get(3).click();
        //        8. Select in dropdown
        WebElement content = driver.findElement(By.className("main-content-hg"));
        Select colors = new Select(content.findElement(By.className("uui-form-element")));
        colors.selectByVisibleText("Yellow");
        //        9. Assert that
        //•for each checkbox there is an individual log row and value is corresponded to the status
        //of checkbox
        WebElement list = driver.findElement(By.className("panel-body-list"));
        AssertionsForClassTypes.assertThat(list.getText()).contains("Water: condition changed to true");
        AssertionsForClassTypes.assertThat(list.getText()).contains("Wind: condition changed to true");
        //•for radio button there is a log row and value is corresponded to the status of radio button
        AssertionsForClassTypes.assertThat(list.getText()).contains("metal: value changed to Selen");
        //•for dropdown there is a log row and value is corresponded to the selected value.
        AssertionsForClassTypes.assertThat(list.getText()).contains("Colors: value changed to Yellow");
        //       10. Close Browser
        driver.quit();
    }
}
