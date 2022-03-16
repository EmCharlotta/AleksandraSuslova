package com.epam.tc.hw5.step;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ActionStepEx1 extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openIndexPage() {
        epamIndexPage.open();
    }

    @When("I login as user {string} password {string}")
    public void login(final String login, final String password) {
        epamIndexPage.performLogin(login, password);
    }

    @When("I select radio {string}")
    public void selectRadio(String radioIndex) {
        differentElementsPage.getRadios().get(Integer.parseInt(radioIndex)).click();
    }

    @When("I select in dropdown {string}")
    public void selectDropdown(String color) {
        differentElementsPage.selectDropd(color);
    }

    @ParameterType(value = "(.*)")
    public List<Integer> checkboxesIndexes(String s) {
        return Arrays.stream(s.split(","))
                     .map(index -> Integer.parseInt(index.trim()))
                     .collect(Collectors.toList());
    }

    @When("I click on Service button in Header")
    public void clickServiceButton() {
        epamIndexPage.clickHeaderMenu();
    }

    @And("I click on {string} button in Service dropdown")
    public void clickButton(String button) {
        epamIndexPage.clickButton(button);
    }

    @When("I select checkboxes '{checkboxesIndexes}'")
    public void selectCheckboxes(List<Integer> checkboxesIndexes) {

        var expectedLogs = new ArrayList<String>();

        for (int index : checkboxesIndexes) {
            differentElementsPage.getCheckboxes().get(index).click();
        }
    }
}
