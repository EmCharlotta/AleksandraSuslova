package com.epam.tc.hw5.step;

import io.cucumber.java.en.Then;
import org.assertj.core.api.AssertionsForClassTypes;

public class AssertionStep extends AbstractStep {

    @Then("for {string} there is a log row {string}")
    public void checkLog(String parameter, String logText) {

        AssertionsForClassTypes.assertThat(differentElementsPage.getList().getText()).contains(logText);
    }

    @Then("Browser title is {string}")
    public void checkTitle(String title) {
        AssertionsForClassTypes.assertThat(epamIndexPage.getTitle().equals(title));
    }

    @Then("User name in the left-top side of screen is {string}")
    public void checkUserName(String name) {
        AssertionsForClassTypes.assertThat(epamIndexPage.getUserName())
                               .contains(name);
    }
}
