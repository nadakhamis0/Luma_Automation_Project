package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private final WebDriver driver;
    private final By mediumSize = By.id("option-label-size-143-item-168");
    private final By purpleColor = By.id("option-label-color-93-item-57");
    private final By addToCartButton = By.cssSelector(".action.tocart.primary");
    private final By cartIcon = By.cssSelector(".action.showcart");
    private final By checkoutButton = By.xpath("//*[@id=\"top-cart-btn-checkout\"]");
    private final By emailField = By.xpath("//div[@class='control _with-tooltip']//input[@id='customer-email']");
    private final By firstNameField = By.cssSelector("[name=\"firstname\"]");
    private final By lastNameField = By.xpath("//input[@name='lastname']");
    private final By companyField = By.xpath("//input[@name='company']");
    private final By address1Field = By.cssSelector("input[name='street[0]']");
    private final By address2Field = By.cssSelector("input[name='street[1]']");
    private final By address3Field = By.cssSelector("input[name='street[2]']");
    private final By cityField = By.cssSelector("input[name='city']");
    private final By StateDropdown = By.cssSelector("select[name='region_id']");
    private final By zipCodeField = By.xpath("//input[@name='postcode']");
    private final By countryDropdown = By.cssSelector("select[name='country_id']");
    private final By phoneNumberField = By.cssSelector("input[name='telephone']");
    private final By flatRateRadioButton = By.cssSelector("[value=\"flatrate_flatrate\"]");
    //private final By bestWayRadioButton = By.xpath("//input[@name='ko_unique_2']");
    private final By nextButton = By.cssSelector("button[class='button action continue primary']");
    private final By newAddressButton = By.cssSelector("button[class='action action-show-popup'");
    private final By billingAddressTheSame = By.cssSelector("input[name='billing-address-same-as-shipping']");
    private final By placeOrderButton = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutPage addOrderToCart() {
        Utility.clickingOnElement(driver, mediumSize);
        Utility.clickingOnElement(driver, purpleColor);
        Utility.clickingOnElement(driver, addToCartButton);
        Utility.waitForElementTOBeVisible(driver, cartIcon);
        Utility.clickingOnElement(driver, cartIcon);
        Utility.clickingOnElement(driver, checkoutButton);
        return this;
    }

    public CheckoutPage enterEmail(String email) {
        Utility.sendData(driver, emailField, email);
        return this;
    }

    public CheckoutPage enterFirstName(String firstName) {
        Utility.sendData(driver, firstNameField, firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
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
        Utility.clickingOnElement(driver, flatRateRadioButton);
        Utility.generalWait(driver);
        return this;
    }

    public CheckoutPage clickNextButton() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Utility.clickingOnElement(driver, nextButton);
        Utility.takeScreenShot(driver, "checkoutPage");
        return this;
    }

    public CheckoutPage clickOnNewAddressButton() {
        Utility.clickingOnElement(driver, newAddressButton);
        return this;
    }

    public CheckoutPage clickBillingAddrressTheSame() {
        Utility.clickingOnElement(driver, billingAddressTheSame);
        return this;
    }

    public CheckoutPage clickPlaceOrderButton() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Utility.clickingOnElement(driver, placeOrderButton);
        Utility.generalWait(driver);
        Utility.takeScreenShot(driver, "checkoutPage");
        return this;
    }

    public boolean assertCheckoutPageTc(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);
    }

}
