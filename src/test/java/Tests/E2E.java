package Tests;

import BaseTest.BaseTest;
import Pages.AddToCartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static DriverFactory.DriverFactory.getDriver;
import static Utilities.DataUtils.getPropertyValue;

public class E2E extends BaseTest {
    private final String EMAIL = DataUtils.getJsonData("Login", "email");
    private final String PASSWORD = DataUtils.getJsonData("Login", "password");
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

    @Test
    public void end2endTestScenario() throws IOException {
        new LoginPage(getDriver())
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickOnLoginButton();
        new HomePage(getDriver())
                .clickOnLogo();
        new AddToCartPage(getDriver())
                .addOrderToCart();
        new CheckoutPage(getDriver())
                .enterFirstName(FIRST_NAME)
                .enterLastName(LAST_NAME)
                .enterCompany(COMPANY)
                .enterAddress(ADDRESS1, ADDRESS2, ADDRESS3)
                .enterCity(CITY)
                //.selectStateFromDropDown(STATE)
                .enterZipCode(ZIPCODE)
                .selectCountryFromDropDown(COUNTRY)
                .enterPhoneNumber(PHONE_NUMBER)
                .selectShippingMethod()
                .clickNextButton()
                .clickPlaceOrderButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(new CheckoutPage(getDriver()).assertCheckoutPageTc(getPropertyValue("environment", "SUCCESS_ORDER_URL")));
    }

    @Test
    public void end2endTestScenario2() throws IOException {
        new LoginPage(getDriver())
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickOnLoginButton();
        new HomePage(getDriver())
                .clickOnLogo();
        new AddToCartPage(getDriver())
                .addOrderToCart();
        new CheckoutPage(getDriver())
                .clickNextButton()
                .clickPlaceOrderButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(new CheckoutPage(getDriver()).assertCheckoutPageTc(getPropertyValue("environment", "SUCCESS_ORDER_URL")));
    }
}
