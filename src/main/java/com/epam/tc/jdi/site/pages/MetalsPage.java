package com.epam.tc.jdi.site.pages;


import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.Checklist;
import com.epam.jdi.light.ui.html.complex.Dropdown;
import com.epam.jdi.light.ui.html.complex.MultiSelector;
import com.epam.jdi.light.ui.html.complex.RadioButtons;

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
}
