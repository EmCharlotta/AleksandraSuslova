package com.epam.tc.hw3;

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

    public void clickToLoginBar() {
        loginBar.click();
    }

    public void login(String uName, String uPassword) {
        name.sendKeys(uName);
        pass.sendKeys(uPassword);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public List<WebElement> getHeaderItems() {
        List<WebElement> list = new ArrayList<>();
        list.add(headerHome);
        list.add(headerContact);
        list.add(headerService);
        list.add(headerMetals);

        return list;
    }

    public List<WebElement> getBenefits() {
        return benefits;
    }

    public List<WebElement> getBenefitsText() {
        return benefitsText;
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public WebElement getSide(String sideItem) {
        return sideBar.findElement(By.linkText(sideItem));
    }

    public void clickHeaderMenu() {
        headerMenu.click();
    }

    public void clickDifferentElement() {
        differentElements.click();
    }
}
