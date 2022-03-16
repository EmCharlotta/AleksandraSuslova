package com.epam.tc.hw5.page;

import com.epam.tc.hw5.page.component.MenuComponent;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EpamIndexPage extends AbstractPage {
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

    private MenuComponent menuComponent;

    @FindBy(xpath = "//*[text()='Different elements']")
    private WebElement differentElements;

    @FindBy(xpath = "(//ul[@role='menu']/li)[5]")
    private WebElement userTable;

    public EpamIndexPage(
        WebDriver driver) {
        super(driver);
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
    public void open() {
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();
    }

    @Story("perform login")
    @Step
    public void performLogin(String userName, String userPassword) {
        clickToLoginBar();
        login(userName, userPassword);
        clickLoginButton();
    }

    @Step
    public String getTitle() {
        return driver.getTitle();
    }

    @Step
    public String getUserName() {
        return driver.findElement(By.className("navbar-right")).getText();
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
        menuComponent = new MenuComponent(driver);
        menuComponent.clickHeader("navbar-nav");
    }

    @Step
    public void clickButton(String button) {
        if (button.equals("Different Elements")) {
            differentElements.click();
        }
        if (button.equals("User Table")) {
            userTable.click();
        }
    }
}
