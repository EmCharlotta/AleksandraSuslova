package com.epam.tc.jdi.site.pages;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;

@Url("metals-colors.html")
public class MetalsPage extends WebPage {

    @FindBy(id = "submit-button")
    public static Button submitButton;

    //    Text Description;
    //    Label ProductName;
    //    TextArea Abuse;
    //    CheckBox RememberMe;
    //    WebList = List<WebElement>
    //    public Checklist settings;
    //    public Menu mainMenu;
    //    public RadioButtons rButtons;
    //    public MultiDropdown mDrop;
    //    public MultiSelect mSelect;

    public static Checkbox number;

    public static Checkbox weather;

    @JDropdown
    public static Dropdown colors;

    @JDropdown
    public static Dropdown metals;

    @JDropdown
    public static Dropdown vegetables;
}
