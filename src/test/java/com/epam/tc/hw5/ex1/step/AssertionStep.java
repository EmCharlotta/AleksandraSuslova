package com.epam.tc.hw5.ex1.step;

import static org.assertj.core.api.Assertions.assertThat;

//import com.epam.tc.lesson05.cucumber.context.TestContext;
import io.cucumber.java.en.Then;
import java.util.List;

public class AssertionStep extends AbstractStep {

    @Then("for checkbox {string} there is a log row {string}")
    public void checkLog() {
        //        List<String> expectedProductTitles = TestContext.getInstance().getObject("productTitles", List.class);
        //        var actualCompareList = comparePage.getProductTitles();
        //
        //        assertThat(actualCompareList)
        //            .containsExactlyInAnyOrderElementsOf(expectedProductTitles);
    }
}
