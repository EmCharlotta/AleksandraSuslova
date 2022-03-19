package com.epam.tc.hw6.service.webdriver;

import com.epam.tc.hw6.service.exception.IllegalBrowserNameException;
import com.epam.tc.hw6.service.exception.WebDriverLaunchTypeException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.NONE)
public final class WebDriverFactory {

    private static final String LOCAL_LAUCH_TYPE = "local";
    private static final String REMOTE_LAUCH_TYPE = "remote";

    public static WebDriver createDriver(final String launchType, final Browser browser) {
        WebDriver driver;
        if (LOCAL_LAUCH_TYPE.equalsIgnoreCase(launchType)) {
            driver = createLocalDriver(browser);
        } else if (REMOTE_LAUCH_TYPE.equalsIgnoreCase((launchType))) {
            driver = null;
        } else {
            throw new WebDriverLaunchTypeException();
        }
        return driver;
    }

    private static WebDriver createLocalDriver(final Browser browser) {
        WebDriver driver;

        switch (browser) {
            case CHROME:
                createChromeDriver();
                break;
            case FIREFOX:
                createFirefoxDriver();
                break;
            default:
                throw new IllegalBrowserNameException();
                return driver;
        }
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager
    }

    private static WebDriver createChromeDriver() {
    }
}
