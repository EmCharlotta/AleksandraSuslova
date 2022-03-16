package com.epam.tc.hw5.page.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuComponent extends AbstractComponent {
    public MenuComponent(WebDriver driver) {
        super(driver);
    }

    public void clickHeader(final String className) {
        wait.until(ExpectedConditions.elementToBeClickable(By.className(className)))
            .click();
    }
}
