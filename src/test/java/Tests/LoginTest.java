package Tests;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import Pages.LoginPage;
import Utilities.DataUtils;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;

@Listeners({IInvokedMethodListenerClass.class, ITestResultListenerClass.class})
public class LoginTest {
    private final String EMAIL = DataUtils.getJsonData("Login", "email");
    private final String PASSWORD = DataUtils.getJsonData("Login", "password");
    private final String INVALID_EMAIL = DataUtils.getJsonData("Login", "invalid_email");
    private final String INVALID_PASSWORD = DataUtils.getJsonData("Login", "invalid_password");

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "Browser"));
        getDriver().get(getPropertyValue("environment", "LOGIN_URL"));
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void validLoginTC() throws IOException {
        new LoginPage(getDriver())
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickOnLoginButton();
        Utility.generalWait(getDriver());
        Assert.assertTrue(new LoginPage(getDriver()).assertLoginTc(getPropertyValue("environment", "MyACCOUNT_URL")));
    }

    @Test
    public void InvalidLoginTC() throws IOException {
        new LoginPage(getDriver())
                .enterEmail(INVALID_EMAIL)
                .enterPassword(INVALID_PASSWORD)
                .clickOnLoginButton();
        Assert.assertTrue(new LoginPage(getDriver()).assertLoginTc(getPropertyValue("environment", "HOME_URL")));
    }


    @AfterMethod
    public void quit() {
        quitDriver();

    }
}
