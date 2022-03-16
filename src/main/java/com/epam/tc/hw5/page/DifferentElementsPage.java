package com.epam.tc.hw5.page;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPage extends AbstractPage {

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(className = "label-radio")
    private List<WebElement> radios;

    @FindBy(className = "main-content-hg")
    private WebElement content;

    @FindBy(className = "panel-body-list")
    private WebElement list;

    public DifferentElementsPage(
        WebDriver driver) {
        super(driver);
    }

    @Step
    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    @Step
    public List<WebElement> getRadios() {
        return radios;
    }

    @Step
    public void selectDropd(String color) {
        Select colors = new Select(content.findElement(By.className("uui-form-element")));
        colors.selectByVisibleText(color);
    }

    @Step
    public WebElement getContent() {
        return content;
    }

    @Step
    public WebElement getList() {
        return list;
    }
}
