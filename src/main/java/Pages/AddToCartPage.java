package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {
    /*private static List<WebElement> products;
    private final By numberOfProductsOnCartIcon = By.cssSelector(".counter.qty");*/
    private final WebDriver driver;
    private final By mediumSize = By.id("option-label-size-143-item-168");
    private final By purpleColor = By.id("option-label-color-93-item-57");
    private final By addToCartButton = By.cssSelector(".action.tocart.primary");
    private final By cartIcon = By.cssSelector(".action.showcart");
    private final By checkoutButton = By.xpath("//*[@id=\"top-cart-btn-checkout\"]");


    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddToCartPage addOrderToCart() {
        Utility.clickingOnElement(driver, mediumSize);
        Utility.clickingOnElement(driver, purpleColor);
        Utility.clickingOnElement(driver, addToCartButton);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Utility.waitForElementTOBeVisible(driver, cartIcon);
        Utility.clickingOnElement(driver, cartIcon);
        Utility.generalWait(driver);
        Utility.clickingOnElement(driver, checkoutButton);
        return this;
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


    //TODO: Add a method to add products to the cart
    /*public AddToCartPage addProductsToCart() {
        products = driver.findElements(addToCartButton);
        LogsUtils.info("Number of products found:" + products.size());
        for (WebElement product : products) {
            product.click();
        }
        Utility.clickingOnElement(driver, numberOfProductsOnCartIcon);
        return this;
    }
     //TODO: Add a method to get the number of products in the cart
    public String getNumOfProductsInCart() {
        try {
            LogsUtils.info("number of products in cart:" + Utility.getText(driver, numberOfProductsOnCartIcon));
            return Utility.getText(driver, numberOfProductsOnCartIcon);
        } catch (Exception e) {
            LogsUtils.error("Error: " + e.getMessage());
            return "0";
        }
    }

    public boolean isProductAddedToCart() {
        try {
            return Utility.getText(driver, numberOfProductsOnCartIcon).equals("1");
        } catch (Exception e) {
            LogsUtils.error("Error:" + e.getMessage());
        }
        return true;
    }*/

}
