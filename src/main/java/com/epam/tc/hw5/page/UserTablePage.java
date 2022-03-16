package com.epam.tc.hw5.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage extends AbstractPage {

    @FindBy(xpath = "//table[@id=\"user-table\"]//tr[1]")
    private WebElement lineIvan;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public void clickVip(String name) {
        if (name.equals("Sergey Ivan")) {
            lineIvan.findElement(By.id("ivan")).click();
        }
    }
}
