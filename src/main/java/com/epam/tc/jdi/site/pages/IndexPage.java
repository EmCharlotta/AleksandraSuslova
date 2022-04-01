package com.epam.tc.jdi.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.tc.jdi.site.pages.elements.LoginForm;
import org.openqa.selenium.WebElement;

@Url("/index.html")
@Title("Home Page")
public class IndexPage extends WebPage {

    @FindBy(className = "navbar-right")
    public static Button loginBar;

    @Css("form")  public static LoginForm loginForm;

    @XPath("//*[text()='Metals & Colors']")
    public static Button metalsAndColors;

}
