package com.epam.tc.hw6.service.webdriver;

import com.epam.tc.hw6.service.exception.IllegalBrowserNameException;
import com.epam.tc.hw6.service.exception.WebDriverLaunchTypeException;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

@NoArgsConstructor(access = AccessLevel.NONE)
public final class WebDriverFactory {

    private static final String LOCAL_LAUCH_TYPE = "local";
    private static final String REMOTE_LAUCH_TYPE = "remote";

    public static WebDriver createDriver(final String launchType, final Browser browser) {
        WebDriver driver;
        if (LOCAL_LAUCH_TYPE.equalsIgnoreCase(launchType)) {
            driver = createLocalDriver(browser);
        } else if (REMOTE_LAUCH_TYPE.equalsIgnoreCase((launchType))) {
            driver = createRemoteDriver(browser);
        } else {
            throw new WebDriverLaunchTypeException();
        }
        return driver;
    }

    private static WebDriver createLocalDriver(final Browser browser) {
        WebDriver driver;

        switch (browser) {
            case CHROME:
                driver = createChromeDriver();
                break;
            case FIREFOX:
                driver = createFirefoxDriver();
                break;
            case EDGE:
                driver = createEdgeDriver();
                break;
            default:
                throw new IllegalBrowserNameException();
        }
        return driver;
    }

    private static WebDriver createEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    // REMOTE
    private static WebDriver createRemoteDriver(final Browser browser) {
        Capabilities capabilities;
        switch (browser) {
            case CHROME:
                capabilities = createRemoteChromeCapabilities();
                break;

            case FIREFOX:
                capabilities = createRemoteFirefoxCapabilities();
                break;

            case EDGE:
                capabilities = createRemoteEdgeCapabilities();
                break;

            default:
                throw new IllegalBrowserNameException();
        }

        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.97.144:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }

        return driver;
    }

    private static Capabilities createRemoteChromeCapabilities() {
        return new ChromeOptions();
    }

    private static Capabilities createRemoteFirefoxCapabilities() {
        return new FirefoxOptions();
    }

    private static Capabilities createRemoteEdgeCapabilities() {
        return new EdgeOptions();
    }
}
