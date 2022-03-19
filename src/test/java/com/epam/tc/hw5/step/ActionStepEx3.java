package com.epam.tc.hw5.step;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;

public class ActionStepEx3 extends AbstractStep {
    @When("I select vip checkbox for {string}")
    public void clickVipCheckbox(String user) {
        userTablePage.clickVip(user);
    }

}

