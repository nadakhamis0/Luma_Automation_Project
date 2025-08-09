package Tests;

import Pages.AddToCartPage;
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

public class AddToCartTest {
    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "Browser"));
        getDriver().get(getPropertyValue("environment", "HOME_URL"));
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void addProductToCartTest() throws IOException {
        new AddToCartPage(getDriver())
                .selectSize()
                .selectColor()
                .clickOnAddToCartButton()
                .clickOnCartIcon()
                .clickOnCheckoutButton();
        Utility.generalWait(getDriver());
        Assert.assertTrue(new AddToCartPage(getDriver()).assertAddToCartPageTc(getPropertyValue("environment", "CHECKOUT_URL")));
    }

    @AfterMethod
    public void quit() {
        quitDriver();
        LogsUtils.info("Driver is closed");

    }
}
