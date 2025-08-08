package Tests;

import BaseTest.BaseTest;

public class End2End extends BaseTest {
}

    /*TODO: Add a method to add products to the cart
    public AddToCartPage addProductsToCart() {
        products = driver.findElements(addToCartButton);
        for (WebElement product : products) {
            product.click();
        }
        Utility.clickingOnElement(driver, numberOfProductsOnCartIcon);
        return this;
    }

    //TODO: Add a method to get the number of products in the cart
    public String getNumOfProductsInCart() {
        try {
            return Utility.getText(driver, numberOfProductsOnCartIcon);
        } catch (Exception e) {
            LogsUtils.error("Error: " + e.getMessage());
            return "0";
        }
    }

    public boolean isCartEmpty() {
        try {
            return Utility.getText(driver, numberOfProductsOnCartIcon).equals("0");
        } catch (Exception e) {
            LogsUtils.error("Error:" + e.getMessage());
        }
        return true;
    }

    public AddToCartPage clickOnAddToCartButton() {
        Utility.clickingOnElement(driver, addToCartButton);
        return this;
    }
}*/
