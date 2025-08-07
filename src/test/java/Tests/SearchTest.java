package Tests;

import Pages.LoginPage;
import Pages.SearchPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;

public class SearchTest {
    private final String EMAIL = DataUtils.getJsonData("EditInfo", "email");
    private final String PASSWORD = DataUtils.getJsonData("EditInfo", "password");

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "Browser"));
        LogsUtils.info("Chrome driver is opened");
        getDriver().get(getPropertyValue("environment", "LOGIN_URL"));
        LogsUtils.info("Navigated to Login Page");
        new LoginPage(getDriver())
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickOnLoginButton();
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void searchTest() throws IOException {
        new SearchPage(getDriver())
                .enterInSearchBox("women's top")
                .clickOnSearchButton();
        LogsUtils.info("Search button is clicked");
        Assert.assertTrue(new SearchPage(getDriver()).assertSearchTc(getPropertyValue("environment", "SEARCH_URL")));

    }

    @AfterMethod
    public void quit() {
        quitDriver();
        LogsUtils.info("Driver is closed");

    }
}
