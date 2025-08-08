package BaseTest;

import Pages.LoginPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;

public class BaseTest {
    private final String EMAIL = DataUtils.getJsonData("Login", "email");
    private final String PASSWORD = DataUtils.getJsonData("Login", "password");
    protected WebDriver driver;

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

    @AfterMethod
    public void quit() {
        quitDriver();
        LogsUtils.info("Driver is closed");

    }
}
