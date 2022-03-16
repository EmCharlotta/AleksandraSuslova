package com.epam.tc.hw5.step;

import com.epam.tc.hw5.context.TestContext;
import com.epam.tc.hw5.page.DifferentElementsPage;
import com.epam.tc.hw5.page.EpamIndexPage;
import com.epam.tc.hw5.page.UserTablePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected EpamIndexPage epamIndexPage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    protected AbstractStep() {
        WebDriver driver = TestContext.getInstance().getObject("driver", WebDriver.class);
        epamIndexPage = new EpamIndexPage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
    }
}
