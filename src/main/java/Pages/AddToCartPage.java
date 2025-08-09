package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {
    private final WebDriver driver;
    private final By mediumSize = By.id("option-label-size-143-item-168");
    private final By purpleColor = By.id("option-label-color-93-item-57");
    private final By addToCartButton = By.cssSelector("#maincontent > div.columns > div > div.widget.block.block-static-block > div.block.widget.block-products-list.grid > div > div > ol > li:nth-child(1) > div > div > div.product-item-inner > div > div.actions-primary > form > button");
    private final By cartIcon = By.cssSelector(".action.showcart");
    private final By checkoutButton = By.xpath("//*[@id=\"top-cart-btn-checkout\"]");


    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddToCartPage selectSize() {
        Utility.clickingOnElement(driver, mediumSize);
        return this;
    }

    public AddToCartPage selectColor() {
        Utility.clickingOnElement(driver, purpleColor);
        return this;
    }

    public AddToCartPage clickOnAddToCartButton() {
        Utility.clickingOnElement(driver, addToCartButton);
        return this;
    }

    public AddToCartPage clickOnCartIcon() {
        Utility.clickingOnElement(driver, cartIcon);
        return this;
    }

    public CheckoutPage clickOnCheckoutButton() {
        Utility.clickingOnElement(driver, checkoutButton);
        return new CheckoutPage(driver);
    }

    public boolean assertAddToCartPageTc(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);
    }

}
