package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private final WebDriver driver;
    private final By mediumSize = By.id("option-label-size-143-item-168");
    private final By purpleColor = By.id("option-label-color-93-item-57");
    private final By addToCartButton = By.cssSelector("#maincontent > div.columns > div > div.widget.block.block-static-block > div.block.widget.block-products-list.grid > div > div > ol > li:nth-child(1) > div > div > div.product-item-inner > div > div.actions-primary > form > button");
    private final By cartIcon = By.cssSelector(".action.showcart");
    private final By checkoutButton = By.xpath("//*[@id=\"top-cart-btn-checkout\"]");
    private final By firstNameField = By.id("UNVACWO");
    private final By lastNameField = By.id("FE309TE");
    private final By companyField = By.id("OBR98Y2");
    private final By address1Field = By.id("JAMIDNA");
    private final By address2Field = By.id("YYX1MET");
    private final By address3Field = By.id("G32ITUU");
    private final By cityField = By.id("LFNN776");
    private final By StateDropdown = By.id("QY2P76S");
    private final By zipCodeField = By.id("EWD1H7R");
    private final By countryDropdown = By.id("XV9K09V");
    private final By phoneNumberField = By.id("A3UIOBL");
    private final By select1RadioButton = By.xpath("//input[@name='ko_unique_1']");
    //private final By select2RadioButton = By.xpath("//input[@name='ko_unique_2']");
    private final By nextButton = By.cssSelector(".button.action.continue.primary");
    private final By placeOrderButton = By.cssSelector(".action.primary.checkout");
    private final By successMessagePurchase = By.cssSelector(".base");


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutPage addOrderToCart() {
        Utility.clickingOnElement(driver, mediumSize);
        Utility.clickingOnElement(driver, purpleColor);
        Utility.clickingOnElement(driver, addToCartButton);
        Utility.clickingOnElement(driver, cartIcon);
        Utility.clickingOnElement(driver, checkoutButton);
        return this;
    }

    public CheckoutPage enterFullName(String firstName, String lastName) {
        Utility.sendData(driver, firstNameField, firstName);
        Utility.sendData(driver, lastNameField, lastName);
        return this;
    }

    public CheckoutPage enterCompany(String company) {
        Utility.sendData(driver, companyField, company);
        return this;
    }

    public CheckoutPage enterAddress(String address1, String address2, String address3) {
        By[] fields = {address1Field, address2Field, address3Field};
        String[] addresses = {address1, address2, address3};
        Utility.sendData(driver, fields, addresses);
        return this;
    }

    public CheckoutPage enterCity(String city) {
        Utility.sendData(driver, cityField, city);
        return this;
    }

    public CheckoutPage selectStateFromDropDown(String state) {
        Utility.selectingFromDropDown(driver, StateDropdown, state);
        return this;
    }

    public CheckoutPage enterZipCode(String zipCode) {
        Utility.sendData(driver, zipCodeField, zipCode);
        return this;
    }

    public CheckoutPage selectCountryFromDropDown(String country) {
        Utility.selectingFromDropDown(driver, countryDropdown, country);
        return this;
    }

    public CheckoutPage enterPhoneNumber(String phoneNumber) {
        Utility.sendData(driver, phoneNumberField, phoneNumber);
        return this;
    }

    public CheckoutPage selectShippingMethod() {
        Utility.clickingOnElement(driver, select1RadioButton);
        return this;
    }

    public CheckoutPage clickNextButton() {
        Utility.clickingOnElement(driver, nextButton);
        return this;
    }

    public CheckoutPage clickPlaceOrderButton() {
        Utility.clickingOnElement(driver, placeOrderButton);
        return this;
    }

    public String getSuccessMessage() {
        return Utility.getText(driver, successMessagePurchase);
    }

    public boolean assertCheckoutPageTc(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);
    }

}
