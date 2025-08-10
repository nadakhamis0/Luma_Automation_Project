package Tests;

import Pages.CheckoutPage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;

public class CheckoutTest {
    private final String FIRST_NAME = DataUtils.getJsonData("ShippingAddress", "firstname");
    private final String LAST_NAME = DataUtils.getJsonData("ShippingAddress", "lastname");
    private final String COMPANY = DataUtils.getJsonData("ShippingAddress", "company");
    private final String ADDRESS1 = DataUtils.getJsonData("ShippingAddress", "Street1Address");
    private final String ADDRESS2 = DataUtils.getJsonData("ShippingAddress", "Street2Address");
    private final String ADDRESS3 = DataUtils.getJsonData("ShippingAddress", "Street3Address");
    private final String CITY = DataUtils.getJsonData("ShippingAddress", "city");
    private final String STATE = DataUtils.getJsonData("ShippingAddress", "State");
    private final String ZIPCODE = DataUtils.getJsonData("ShippingAddress", "zipCode");
    private final String COUNTRY = DataUtils.getJsonData("ShippingAddress", "country");
    private final String PHONE_NUMBER = DataUtils.getJsonData("ShippingAddress", "phoneNumber");


    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "Browser"));
        getDriver().get(getPropertyValue("environment", "HOME_URL"));
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void validSignUpTest() throws IOException {
        new CheckoutPage(getDriver())
                .addOrderToCart()
                .enterFullName(FIRST_NAME, LAST_NAME)
                .enterCompany(COMPANY)
                .enterAddress(ADDRESS1, ADDRESS2, ADDRESS3)
                .enterCity(CITY)
                .selectStateFromDropDown(STATE)
                .enterZipCode(ZIPCODE)
                .selectCountryFromDropDown(COUNTRY)
                .enterPhoneNumber(PHONE_NUMBER)
                .selectShippingMethod()
                .clickNextButton()
                .clickPlaceOrderButton()
                .getSuccessMessage();
        Assert.assertTrue(new CheckoutPage(getDriver()).assertCheckoutPageTc(getPropertyValue("environment", "SUCCESS_ORDER_URL")));
    }


    @AfterMethod
    public void quit() {
        quitDriver();

    }
}
