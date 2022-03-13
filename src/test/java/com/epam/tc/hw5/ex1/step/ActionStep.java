package com.epam.tc.hw5.ex1.step;

//import com.epam.tc.lesson05.cucumber.context.TestContext;
//import com.epam.tc.lesson05.page.CitilinkCatalogItemsPage;
//import com.epam.tc.lesson05.page.CitilinkIndexPage;
//import com.epam.tc.lesson05.page.CitilinkProductsPage;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openIndexPage() {
        //indexPage.open();
    }

    @When("I login as user {string} password {string}")
    public void login(final String login, final String password) {
        //        indexPage.clickCatalogButton();
        //        indexPage.selectCatalogCategory(mainCategory);
        //
        //        catalogItemsPage.selectSubcategory(subCategory);
    }

    @ParameterType(value = "(.*)")
    public List<String> checkboxNames(String s) {
        return Arrays.stream(s.split(","))
                     .map(index -> String.valueOf(index.trim()))
                     .collect(Collectors.toList());
    }

    @When("I select checkboxes '{checkboxNames}'")
    public void selectCheckboxes(List<String> checkboxes) {
        //        var products = citilinkProductsPage.getProducts();
        //        var expectedProductTitle = new ArrayList<String>();
        //
        //        for (int index : productIndexes) {
        //            var productTitle = products.get(index - 1).getTitle();
        //            expectedProductTitle.add(productTitle);
        //            products.get(index - 1).addProductToCompareList();
        //        }
        //        citilinkProductsPage.clickCompareButton();
        //        TestContext.getInstance().setObject("productTitles", expectedProductTitle);
    }
}
