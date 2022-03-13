package com.epam.tc.hw5.ex1;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecondPage {

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(className = "label-radio")
    private List<WebElement> radios;

    @FindBy(className = "main-content-hg")
    private WebElement content;

    @FindBy(className = "panel-body-list")
    private WebElement list;

    public SecondPage(
        WebDriver driver) {
        PageFactory.initElements(driver, this);
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
    public WebElement getContent() {
        return content;
    }

    @Step
    public WebElement getList() {
        return list;
    }
}
