package BaseTest;

import Pages.AddToCartPage;
import Pages.CheckoutPage;
import Pages.LoginPage;
import Utilities.LogsUtils;
import Utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;

public class BaseTest {
    protected LoginPage loginPage;
    protected AddToCartPage addToCartPage;
    protected CheckoutPage checkoutPage;
    protected WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "Browser"));
        LogsUtils.info("Chrome driver is opened");
        getDriver().get(getPropertyValue("environment", "LOGIN_URL"));
        LogsUtils.info("Navigated to Login Page");
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void quit() {
        Utility.takeScreenShot(getDriver(), "e2e");
        quitDriver();
        LogsUtils.info("Driver is closed");

    }
}
