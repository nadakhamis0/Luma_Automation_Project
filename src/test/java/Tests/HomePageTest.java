package Tests;

import Pages.HomePage;
import Utilities.LogsUtils;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;

public class HomePageTest {

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "Browser"));
        LogsUtils.info("Chrome driver is opened");
        getDriver().get(getPropertyValue("environment", "LOGIN_URL"));
        LogsUtils.info("Navigated to Login Page");
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void hoveringHomePageTest() throws IOException {
        new HomePage(getDriver())
                .clickOnLogo()
                .HoverOverAllPage()
                .scrollToAllProjects();
        Utility.generalWait(getDriver());
        Assert.assertTrue(new HomePage(getDriver()).assertHomePageTc(getPropertyValue("environment", "HOME_URL")));
    }

    @AfterMethod
    public void quit() {
        quitDriver();
        LogsUtils.info("Driver is closed");

    }
}
