package com.epam.tc.hw3;

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

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getRadios() {
        return radios;
    }

    public WebElement getContent() {
        return content;
    }

    public WebElement getList() {
        return list;
    }
}
