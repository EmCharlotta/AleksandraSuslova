package com.epam.tc.hw5.step;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.AssertionsForClassTypes;
import org.openqa.selenium.WebElement;

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
        AssertionsForClassTypes.assertThat(epamIndexPage.getUserName()).contains(name);
    }

    @Then("{string} {string} should be displayed on Users Table on User Table Page")
    public void checkElemInTable(String elemNumber, String column) {
        AssertionsForClassTypes.assertThat(Integer.parseInt(elemNumber))
                               .isEqualTo(userTablePage.getAllInColumn(column).size() - 1);
    }

    @And("User table should contain following values:")
    public void checkTableValues(DataTable dataTable) {
        List<List<String>> table = dataTable.asLists(String.class);

        for (int i = 1; i < 7; i++) {
            AssertionsForClassTypes.assertThat(table.get(i).get(0))
                                   .isEqualTo(userTablePage.getAllInColumn("Number Type Dropdowns").get(i).getText());
            AssertionsForClassTypes.assertThat(table.get(i).get(1))
                                   .isEqualTo(userTablePage.getAllInColumn("Usernames").get(i).getText());
            AssertionsForClassTypes.assertThat(table.get(i).get(2)).isEqualTo(
                userTablePage.getAllInColumn("Description texts under images").get(i).getText().replaceAll("Vip", "")
                             .trim().replaceAll("\\n", " "));
        }
    }

    @And("droplist should contain values in column {string} for user {string}")
    public void checkDroplist(String column, String user, List<String> droplistValues) {
        WebElement drop = userTablePage.getDroplist(column, user);
        List<String> dropFromWeb = new ArrayList<>();
        String[] arr = drop.getText().trim().split("\\n");
        dropFromWeb.add("Dropdown Values");
        for (String str : arr) {
            dropFromWeb.add(str.trim());
        }
        AssertionsForClassTypes.assertThat(droplistValues).isEqualTo(dropFromWeb);
    }
}
