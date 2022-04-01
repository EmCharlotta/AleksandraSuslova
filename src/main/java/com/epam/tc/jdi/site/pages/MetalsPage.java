package com.epam.tc.jdi.site.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.MultiSelector;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import org.openqa.selenium.WebElement;

@Url("/metals-colors.html")
public class MetalsPage extends WebPage {

    @FindBy(id = "submit-button")
    public static Button submitButton;

    @FindBy(id = "odds-selector")
    public static RadioButtons radioOdd;
    @FindBy(id = "even-selector")
    public static RadioButtons radioEven;

    @FindBy(id = "elements-checklist")
    public static Checklist weather;

    @FindBy(id = "colors")
    @JDropdown
    public static Dropdown colors;

    @FindBy(id = "metals")
    @JDropdown
    public static Dropdown metals;

    @FindBy(id = "vegetables")
    public static MultiSelector vegetables;

    @FindBy (className = "info-panel-body-result")
    public static UIElement result;

    @XPath("//*[text()='Logout']") public static WebElement logout;

}
