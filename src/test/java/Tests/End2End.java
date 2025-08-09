package Tests;

import BaseTest.BaseTest;

public class End2End extends BaseTest {
}

    /*private static List<WebElement> products;
    private final WebDriver driver;
    private final By mediumSize = By.id("option-label-size-143-item-168");
    private final By purpleColor = By.id("option-label-color-93-item-57");
    private final By checkoutButton = By.id("top-cart-btn-checkout");
    private final By numberOfProductsOnCartIcon = By.cssSelector(".counter.qty");
    private final By addToCartButton = By.xpath("//button[@title='Add to Cart']");


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

    //TODO: Add a method to add products to the cart
    public AddToCartPage addProductsToCart() {
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
    }

    public AddToCartPage clickOnAddToCartButton() {
        Utility.clickingOnElement(driver, addToCartButton);
        return this;
    }
    public CheckoutPage
    public boolean assertAddToCartPageTc(String expectedValue){
        return driver.getCurrentUrl().equals(expectedValue);
    }*/
