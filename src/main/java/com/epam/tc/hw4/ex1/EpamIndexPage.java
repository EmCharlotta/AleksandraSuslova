package com.epam.tc.hw4.ex1;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EpamIndexPage {
    @FindBy(className = "navbar-right")
    private WebElement loginBar;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "password")
    private WebElement pass;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[text()='Home']")
    private WebElement headerHome;

    @FindBy(xpath = "//*[text()='Contact form']")
    private WebElement headerContact;

    @FindBy(xpath = "//*[text()='Service']")
    private WebElement headerService;

    @FindBy(xpath = "//*[text()='Metals & Colors']")
    private WebElement headerMetals;

    @FindBy(className = "benefit-icon")
    private List<WebElement> benefits;

    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitsText;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(className = "sidebar-menu")
    private WebElement sideBar;

    @FindBy(className = "navbar-nav")
    private WebElement headerMenu;

    @FindBy(xpath = "//*[text()='Different elements']")
    private WebElement differentElements;

    public EpamIndexPage(
        WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step
    public void clickToLoginBar() {
        loginBar.click();
    }

    @Step
    public void login(String userName, String userPassword) {
        name.sendKeys(userName);
        pass.sendKeys(userPassword);
    }

    @Step
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step
    public List<WebElement> getHeaderItems() {
        List<WebElement> list = new ArrayList<>();
        list.add(headerHome);
        list.add(headerContact);
        list.add(headerService);
        list.add(headerMetals);

        return list;
    }

    @Step
    public List<WebElement> getBenefits() {
        return benefits;
    }

    @Step
    public List<WebElement> getBenefitsText() {
        return benefitsText;
    }

    @Step
    public WebElement getFrame() {
        return frame;
    }

    @Step
    public WebElement getFrameButton() {
        return frameButton;
    }

    @Step
    public WebElement getSide(String sideItem) {
        return sideBar.findElement(By.linkText(sideItem));
    }

    @Step
    public void clickHeaderMenu() {
        headerMenu.click();
    }

    @Step
    public void clickDifferentElement() {
        differentElements.click();
    }
}
